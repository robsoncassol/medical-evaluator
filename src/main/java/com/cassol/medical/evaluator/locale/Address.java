package com.cassol.medical.evaluator.locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private Long id;
	
	private String street;
	private String number;
	private String postCode;

	@ManyToOne
	private City city;
	
	
}
