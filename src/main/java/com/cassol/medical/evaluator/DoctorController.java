package com.cassol.medical.evaluator;


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
		Patient patient = new Patient("Johnn");
		Question ask = new Question("Atende rápido", 3);
		
		doctor = (Doctor) sessionFactory.getCurrentSession().merge(doctor);
		patient = (Patient) sessionFactory.getCurrentSession().merge(patient);
		ask = (Question) sessionFactory.getCurrentSession().merge(ask);
		
		
		Evaluation evaluate = patient.evaluate(ask, Stars.THREE, doctor);

		result.use(Results.json()).from(evaluate).serialize();
	}
	

}
