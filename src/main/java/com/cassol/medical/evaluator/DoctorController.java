package com.cassol.medical.evaluator;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
@Path("/doctor")
public class DoctorController {
	
	private final Result result;
	private final SessionFactory sessionFactory;
	
	
	public DoctorController(Result result, SessionFactory sessionFactory) {
		this.result = result;
		this.sessionFactory = sessionFactory;
	}

	@Path("/show")
	@Transactional
	public void show(){
		Doctor doctor = new Doctor("Dr. Alexandre");
		
		sessionFactory.getCurrentSession().save(doctor);
		
	}
	

}
