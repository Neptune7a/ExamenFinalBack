package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bill;
import com.example.demo.entity.User;

import com.example.demo.repository.UserRepository;



@RestController
@RequestMapping("/users")
public class UserController {


	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public List<User> getUserAll() {

		return userRepository.findAll();
	}
	
	@GetMapping("/{id}/bills")
	public List<Bill> user(@PathVariable Integer id){
		Optional<User> usuarios=userRepository.findById(id);
		if(usuarios.isPresent()) {
			return usuarios.get().getBills();
		}
		
		return null;
	}
	
	
}
