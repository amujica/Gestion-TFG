package es.upm.dit.isst.webLab.dao;

import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.webLab.model.TFG;

public class TFGDAOImplementation implements TFGDAO {
	private static TFGDAOImplementation instancia = null;
	private TFGDAOImplementation() {}
	public static TFGDAOImplementation getInstance() {
		if (null == instancia)
			instancia = new TFGDAOImplementation();
		return instancia;
	}
	
	@Override
	public void create(TFG tfg) {		
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
			session.save( tfg );
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
	}
	
	@Override
	public TFG read(String email) {
			Session session = SessionFactoryService.get().openSession();
			session.beginTransaction();
			TFG tfg = session.get( TFG.class, email );
			session.getTransaction().commit();
			session.close();
			return tfg;
	}
	
	
	@Override
	public void update(TFG tfg) {
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  session.saveOrUpdate( tfg );
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
	}
		
		
	@Override
	public void delete(TFG tfg) {
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  session.delete( tfg );
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
	}
	
		@SuppressWarnings("unchecked")
	@Override
	public Collection<TFG> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<TFG> tfgs = session.createQuery( "from TFG" ).list(); //ese from no se si esta bien
		session.getTransaction().commit();
		session.close();
		return tfgs;
	}
	  
}