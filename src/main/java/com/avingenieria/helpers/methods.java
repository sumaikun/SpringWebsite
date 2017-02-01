package com.avingenieria.helpers;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class methods {
	
	private static SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public static int id_generator(String table){	
		int id;
		try {
			 Session session;			
			 session = sessionFactory.openSession();
							
			String squery = "from "+table;
			Query query = session.createQuery(squery);						
			if(!query.list().isEmpty())
			{
				id = query.list().size();
				id += 1;
			}
			else {
				id=1;
				
			}
			}catch(Exception e){
				throw e;
			}
		
		return id;	
	}
}
