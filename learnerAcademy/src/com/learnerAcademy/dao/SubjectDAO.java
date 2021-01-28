package com.learnerAcademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.learnerAcademy.pojo.Subject;
import com.learnerAcademy.util.HibernateUtil;

public class SubjectDAO {
	
//	save Subject
	public void saveSubject(Subject subject) {
		
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.save(subject);
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
	}
	
//	update subject
	public void updateSubject(Subject subject) {
		
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.update(subject);
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
	}
	
//	delete Subject
	public void deleteSubject(int id) {
		
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        Subject subject = session.get(Subject.class, id);
        
        if (subject != null) {
        	session.delete(subject);
        	System.out.println("Subject deleted");
        }
        
        
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
	}
	
//	get subject by id
	public Subject getSubject(int id) {
		Subject subject = null;
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
         subject = session.get(Subject.class, id);
        
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
		
		return subject;
	}
	
//	get all classes 
	@SuppressWarnings("unchecked")
	public List <Subject> getAllSubject() {
		
		List <Subject>  listOfSubject = null;
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
         listOfSubject = session.createQuery("from Subject").getResultList();
        
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
		
		return listOfSubject;
	}

	
}
