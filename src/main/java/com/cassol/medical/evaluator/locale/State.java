package com.cassol.medical.evaluator.locale;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class State {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String acronym;
	
	@OneToMany(mappedBy="state", cascade=CascadeType.ALL)
	private List<City> cities = new ArrayList<>();
	
}
