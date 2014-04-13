package com.cassol.medical.evaluator;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doctor {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="doctor", cascade=CascadeType.ALL)
	private List<Evaluation> evaluations = new ArrayList<>();

	private Doctor() {
	}

	public Doctor(String name) {
		this();
		this.name = name;
	}

	public Float rating() {
		float totalRate = 0;
		for (Evaluation rate : evaluations) {
			totalRate+=rate.getValue();
		}
		return totalRate/evaluations.size();
	}

	public void addEvaluation(Evaluation eval) {
		evaluations.add(eval);
	}
	
	public String getName(){
		return name;
	}

}
