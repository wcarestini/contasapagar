package com.contasapagar.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contasapagar.entity.Bill;
import com.contasapagar.repository.BillRepository;

@Service
public class BillService {
	
	@Autowired
	private BillRepository dao;
		
	public Bill save(Bill bill) {
		bill = verifyIfBillIsInArrears(bill);
		return dao.save(bill);
	}
	
	public List<Bill> findAll(){
		return dao.findAll();
	}

	private Bill verifyIfBillIsInArrears(Bill bill) {
		LocalDate payday = bill.getPayday();
		LocalDate expirationDate = bill.getExpirationDate();
		if(payday.isAfter(expirationDate)) {
			bill.setNumberOfDaysInArrears(payday.compareTo(expirationDate));
			bill = calculatesInterestAndFine(bill);
		}
		
		return bill;
	}
	
	private Bill calculatesInterestAndFine(Bill bill) {
		Integer numberOfDaysInArrears = bill.getNumberOfDaysInArrears();
		BigDecimal fine;
		BigDecimal interest;
		if(numberOfDaysInArrears > 5) {
			fine = new BigDecimal(0.05);
			interest = new BigDecimal(0.003);
		} else if (numberOfDaysInArrears > 3) {
			fine = new BigDecimal(0.03);
			interest = new BigDecimal(0.002);
		} else {
			fine = new BigDecimal(0.02);
			interest = new BigDecimal(0.001);
		}
		
		BigDecimal finalFine = bill.getOriginalAmount().multiply(fine);
		BigDecimal finalInterest = bill.getOriginalAmount().multiply(interest.multiply(new BigDecimal(numberOfDaysInArrears)));
		BigDecimal correctedAmount = bill.getOriginalAmount().add(finalFine).add(finalInterest);
		bill.setCorrectedAmount(correctedAmount.round(new MathContext(6)));
		
		return bill;
		
	}
	
}
