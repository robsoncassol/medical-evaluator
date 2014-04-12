package com.cassol.medical.evaluator;

import java.util.ArrayList;
import java.util.List;

public class Doctor {

	private String name;
	private List<Evaluation> ratings = new ArrayList<>();

	public Doctor(String name) {
		this.name = name;
	}

	public float rating() {
		float totalRate = 0;
		for (Evaluation rate : ratings) {
			totalRate+=rate.getValue();
		}
		return totalRate/ratings.size();
	}

	public void addEvaluation(Evaluation eval) {
		ratings.add(eval);
	}

}
