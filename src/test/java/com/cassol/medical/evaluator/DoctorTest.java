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
	public void shouldGetARating(){
		Question q1 = new Question("resolveu seu problema ?",10);
		
		patient.evaluate(q1,Stars.THREE,doctor);
		
		assertEquals(new Float(30),doctor.rating());
	}
	
	@Test
	public void shouldGetAAverageRating(){
		Question q1 = new Question("resolveu seu problema ?",10);
		Question q2 = new Question("é pontual ?",3);
		
		patient.evaluate(q1,Stars.THREE,doctor);
		patient.evaluate(q2,Stars.FIVE,doctor);
		
		assertEquals(new Float(22.5),doctor.rating());
	}



	
	

}
