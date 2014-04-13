package com.cassol.medical.evaluator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {

	@Id
	@GeneratedValue
	private Long id;
	private String text;
	private Integer weight;
	
	private Question() {
	}

	public Question(String text, Integer weight) {
		this();
		this.text = text;
		this.weight = weight;
	}

	public String getText() {
		return text;
	}

	public Integer getWeight() {
		return weight;
	}



	
	

}
