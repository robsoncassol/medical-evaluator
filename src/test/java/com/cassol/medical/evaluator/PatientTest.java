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
		patient.evaluate("é um bom médico",10,doctor);
		Assert.assertTrue(patient.numberOfreviews() > 0);
	}





}
