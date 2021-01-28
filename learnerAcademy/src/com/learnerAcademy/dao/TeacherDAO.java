package com.learnerAcademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.learnerAcademy.pojo.Teacher;
import com.learnerAcademy.util.HibernateUtil;

public class TeacherDAO {
	
//	save Teacher
	public void saveTeacher(Teacher teacher) {
		
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.save(teacher);
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
	}
	
//	update Teacher
	public void updateTeacher(Teacher teacher) {
		
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.update(teacher);
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
	}
	
//	delete Teacher
	public void deleteTeacher(int id) {
		
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        Teacher teacher = session.get(Teacher.class, id);
        
        if (teacher != null) {
        	session.delete(teacher);
        	System.out.println("Teacher deleted");
        }
        
        
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
	}
	
//	get teacher by id
	public Teacher getTeacher(int id) {
		Teacher teacher = null;
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
         teacher = session.get(Teacher.class, id);
        
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
		
		return teacher;
	}
	
//	get all classes 
	@SuppressWarnings("unchecked")
	public List <Teacher> getAllTeacher() {
		
		List <Teacher>  listOfTeacher = null;
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
         listOfTeacher = session.createQuery("from Teacher").getResultList();
        
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
		
		return listOfTeacher;
	}
	
}
