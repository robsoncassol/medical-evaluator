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

	private Stars stars;
	
	@ManyToOne
	private Doctor doctor;
	
	@ManyToOne
	private Patient patient;
	
	@ManyToOne
	private Question question;

	
	private Evaluation(){
		
	}

	public Evaluation(Question question, Stars stars, Doctor doctor, Patient patient) {
		this();
		this.question = question;
		this.stars = stars;
		this.doctor = doctor;
		this.patient = patient;
	}


	public Doctor getDoctor() {
		return doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public float getValue() {
		return question.getWeight()*this.stars.number();
	}

}
