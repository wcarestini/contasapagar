package com.contasapagar.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contasapagar.entity.Bill;
import com.contasapagar.service.BillService;

@RestController
@RequestMapping("bill")
public class BillResource {
	
	@Autowired
	private BillService service;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Bill bill){
		return new ResponseEntity<>(service.save(bill), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
}
