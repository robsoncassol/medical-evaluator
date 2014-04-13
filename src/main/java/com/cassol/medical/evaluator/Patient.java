package com.cassol.medical.evaluator;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patient {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="patient")
	private List<Evaluation> evaluations = new ArrayList<>();

	public Patient(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public void evaluate(String text, int value, Doctor doctor) {
		Evaluation eval = new Evaluation(text, value,doctor,this);
		doctor.addEvaluation(eval);
		evaluations.add(eval);
		
	}

	public int numberOfReviews() {
		return evaluations.size();
	}

}
