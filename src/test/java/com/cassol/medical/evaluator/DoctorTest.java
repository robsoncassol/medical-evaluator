package com.cassol.medical.evaluator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoctorTest {
	
	private Patient patient;
	private Doctor doctor;

	
	@Before
	public void setup(){
		patient = new Patient("Pedro");
		doctor = new Doctor("Tiago");
	}
	
	
	@Test
	public void shouldGetAAverageRating(){
		patient.evaluate("é um bom médico",10,doctor);
		patient.evaluate("chega atrazado",5,doctor);
		assertTrue(doctor.rating()==7.5);
	}



	
	

}
