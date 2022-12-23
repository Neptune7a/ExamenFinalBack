package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bill;
import com.example.demo.repository.BillRepository;

@RestController
public class BillController {
	@Autowired
	BillRepository billRepository;
	
	@GetMapping
	public List<Bill> getUserAll() {

		return billRepository.findAll();
	}
	
	@PostMapping
	public Bill postBills(@RequestBody Bill bill) {
		
		billRepository.save(bill);
		
		return bill;
		

	}
	
	
}
