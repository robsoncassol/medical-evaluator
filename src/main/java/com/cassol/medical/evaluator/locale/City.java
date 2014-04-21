package com.cassol.medical.evaluator.locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class City {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToOne
	private State state;
	
}
