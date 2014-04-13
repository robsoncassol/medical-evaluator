package com.cassol.medical.evaluator;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToMany(mappedBy="patient", cascade=CascadeType.ALL)
	private List<Evaluation> evaluations = new ArrayList<>();

	public Patient() {
	}
	
	public Patient(String name) {
		this();
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public int numberOfReviews() {
		return evaluations.size();
	}

	public Evaluation evaluate(Question question, Stars stars, Doctor doctor) {
		Evaluation evaluation = new Evaluation(question,stars,doctor,this);
		doctor.addEvaluation(evaluation);
		evaluations.add(evaluation);
		return evaluation;
	}


}
