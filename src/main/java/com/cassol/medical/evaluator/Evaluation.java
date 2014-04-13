package com.cassol.medical.evaluator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Evaluation {

	@Id
	@GeneratedValue
	private Long id;
	private String text;
	private int value;
	
	@ManyToOne
	private Doctor doctor;
	
	@ManyToOne
	private Patient patient;
	
	private Evaluation(){
		
	}

	public Evaluation(String text, int value, Doctor doctor, Patient patient) {
		this();
		this.text = text;
		this.value = value;
		this.doctor = doctor;
		this.patient = patient;
	}

	public int getValue() {
		return value;
	}

	public String getText() {
		return text;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public Patient getPatient() {
		return patient;
	}

}
