package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Bill;
import com.example.demo.entity.User;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.UserRepository;



@RestController
@RequestMapping("/users")
public class UserController {


	@Autowired
	UserRepository userRepository;
	private BillRepository billRepository;
	
	@GetMapping
	public List<User> getUserAll() {

		return userRepository.findAll();
	}
	
	@GetMapping("/{id}/bills") //por id
	public List<Bill> user(@PathVariable Integer id){
		Optional<User> usuarios=userRepository.findById(id);
		if(usuarios.isPresent()) {
			return usuarios.get().getBills();
		}
		
		return null;
	}
	
	@PostMapping("/{id}/bills")
	public Bill postBillByUser(@RequestBody Bill bill, @PathVariable Integer id) {
		
		Optional<User> usuarios=userRepository.findById(id);
		if(usuarios.isPresent()) {
			//aqui debería setearle el bill
			usuarios.get().setBills(bill);
		}
		
		return bill;
		
		
	}
	
	@DeleteMapping("/{id}/bills/{idbill}")
	public Bill deleteBillById(@PathVariable Integer id, @PathVariable Integer idbill) {
		
		billRepository = null;
		
		Optional<User>usuarios=userRepository.findById(id);
		Optional<Bill>bills=billRepository.findById(idbill);
		if(usuarios.isPresent()) {
			if(bills.isPresent()) {
				Bill bill= bills.get();
				billRepository.deleteById(idbill); //ni idea
				return bill;
			}
		}
		
		return null;
	}
	
	
	
	
	@GetMapping("/{id}/bills/{idmov}") //porsiaca
	public List<Bill> userBill(@PathVariable Integer id,@PathVariable Integer idmov){
		
		Optional<User>usuarios=userRepository.findById(id);
		if(usuarios.isPresent()) {
			
			return usuarios.get().getBills();
		}
		
		return null;
	}
	
	
	
	
}
