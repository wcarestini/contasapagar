package com.contasapagar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contasapagar.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
	
}
