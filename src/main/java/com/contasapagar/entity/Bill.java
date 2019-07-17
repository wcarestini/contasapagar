package com.contasapagar.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.contasapagar.util.LocalDateDeserializer;
import com.contasapagar.util.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Bill {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String name;
	
	@NotNull
	private BigDecimal originalAmount;
	
	@NotNull
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate expirationDate;
	
	@NotNull
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate payday;
	
	@NotNull
	private Integer numberOfDaysInArrears = 0;
	
	@NotNull
	private BigDecimal correctedAmount;
	
	public Bill() {
		
	}
	
	public Bill(String name, BigDecimal originalAmount,
			LocalDate expirationDate, LocalDate payday) {
		this.name = name;
		this.originalAmount = originalAmount;
		this.expirationDate = expirationDate;
		this.payday = payday;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public LocalDate getPayday() {
		return payday;
	}

	public void setPayday(LocalDate payday) {
		this.payday = payday;
	}

	public Integer getNumberOfDaysInArrears() {
		return numberOfDaysInArrears;
	}

	public void setNumberOfDaysInArrears(Integer numberOfDaysInArrears) {
		this.numberOfDaysInArrears = numberOfDaysInArrears;
	}

	public BigDecimal getCorrectedAmount() {
		return correctedAmount;
	}

	public void setCorrectedAmount(BigDecimal correctedAmount) {
		this.correctedAmount = correctedAmount;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", name=" + name + ", originalAmount=" + originalAmount + ", expirationDate="
				+ expirationDate + ", payday=" + payday + ", numberOfDaysInArrears=" + numberOfDaysInArrears
				+ ", correctedAmount=" + correctedAmount + "]";
	}
	
	
	
}
