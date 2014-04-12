package com.cassol.medical.evaluator;

import java.util.ArrayList;
import java.util.List;

public class Patient {

	private String name;
	private List<Evaluation> reviews = new ArrayList<>();

	public Patient(String name) {
		this.name = name;
	}

	public void evaluate(String text, int value, Doctor doctor) {
		Evaluation eval = new Evaluation(text, value,doctor,this);
		doctor.addEvaluation(eval);
		reviews.add(eval);
		
	}

	public int numberOfreviews() {
		return reviews.size();
	}

}
