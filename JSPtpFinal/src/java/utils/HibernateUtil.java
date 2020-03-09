package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
		
	}
	
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}
	
	

}
