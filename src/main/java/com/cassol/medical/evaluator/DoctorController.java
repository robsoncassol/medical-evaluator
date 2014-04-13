package com.cassol.medical.evaluator;


import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;


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
		
		doctor = (Doctor) sessionFactory.getCurrentSession().merge(doctor);
		patient = (Patient) sessionFactory.getCurrentSession().merge(patient);
		
		
//		Evaluation evaluate = patient.evaluate("Médico ruim", 2, doctor);
//		
//		result.use(Results.json()).from(evaluate).serialize();
	}
	

}
