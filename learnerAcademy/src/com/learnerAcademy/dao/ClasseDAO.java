package com.learnerAcademy.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learnerAcademy.pojo.Classe;
import com.learnerAcademy.util.HibernateUtil;



public class ClasseDAO {
	
//	save classe
	public void saveClasse(Classe classe) {
		
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.save(classe);
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
	}
	
//	update classe
	public void updateClasse(Classe classe) {
		
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.update(classe);
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
	}
	
//	delete classe
	public void deleteClasse(int id) {
		
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        Classe classe = session.get(Classe.class, id);
        
        if (classe != null) {
        	session.delete(classe);
        	System.out.println("Classe deleted");
        }
        
        
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
	}
	
//	get classe by id
	public Classe getClasse(int id) {
		Classe classe = null;
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
         classe = session.get(Classe.class, id);
        
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
		
		return classe;
	}
	
//	get all classes 
//	@SuppressWarnings("unchecked")
	public List <Classe> getAllClasse() {
		
		List <Classe>  listOfClasse = new ArrayList<Classe>();
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
         listOfClasse =  session.createQuery("Select c from Classe c", Classe.class).getResultList();
         
        
        
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
		
		return listOfClasse;
	}

	
}
