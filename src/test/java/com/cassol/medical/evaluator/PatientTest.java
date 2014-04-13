package com.cassol.medical.evaluator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PatientTest  {
	
	private Patient patient;
	private Doctor doctor;

	
	@Before
	public void setup(){
		patient = new Patient("Pedro");
		doctor = new Doctor("Tiago");
	}
	
	@Test
	public void shouldMakeAGoodEvaluationOfTheDoctor(){
		Question question = new Question("O médico é pontual?",5);
		patient.evaluate(question,Stars.ONE,doctor);
		
		Assert.assertTrue(patient.numberOfReviews() > 0);
	}





}
