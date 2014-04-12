package com.cassol.medical.evaluator;

public class Evaluation {
	
	private String text;
	private int value;
	private Doctor doctor;
	private Patient patient;
	
	public Evaluation(String text, int value, Doctor doctor, Patient patient) {
		this.text = text;
		this.value = value;
		this.doctor = doctor;
		this.patient = patient;
	}

	public int getValue() {
		return value;
	}

	

}
