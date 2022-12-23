package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Bill implements Serializable {
	
	@Id
	private Integer id;
	private Timestamp date;
	@ManyToOne
	private User user;
	private String numeric;
	private Integer type;
	private String observation;
	
	
	
	
}
