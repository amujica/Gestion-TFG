package es.upm.dit.isst.webLab.dao;


import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.webLab.model.Professor;
import es.upm.dit.isst.webLab.model.TFG;

public class ProfessorDAOImplementation implements ProfessorDAO{
	private static ProfessorDAOImplementation instancia = null;
	private ProfessorDAOImplementation() {}
	public static ProfessorDAOImplementation getInstance() {
		if (null == instancia)
			instancia = new ProfessorDAOImplementation();
		return instancia;
	}
	@Override
	public void create(Professor professor) {
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
			session.save( professor );
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		
	}
	@Override
	public Professor read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Professor prof = session.get( Professor.class, email );
		session.getTransaction().commit();
		session.close();
		return prof;
	}
	@Override
	public void update(Professor professor) {
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  session.saveOrUpdate( professor );
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		
	}
	@Override
	public void delete(Professor professor) {
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  session.delete( professor );
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		
	}
	
		@SuppressWarnings("unchecked")
	@Override
	public Collection<Professor> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Professor> profs = session.createQuery( "from Professor" ).list();
		session.getTransaction().commit();
		session.close();
		return profs;
	}

}