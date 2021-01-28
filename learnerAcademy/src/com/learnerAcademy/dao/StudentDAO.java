package com.learnerAcademy.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learnerAcademy.pojo.Student;
import com.learnerAcademy.util.HibernateUtil;

public class StudentDAO {
	
//	save student
	public void saveStudent(Student  student) {
		
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.save(student);
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
	}
	
//	update Student
	public void updateStudent(Student student) {
		
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.update(student);
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
	}
	
//	delete Student
	public void deleteStudent(int id) {
		
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        Student student = session.get(Student.class, id);
        
        if (student != null) {
        	session.delete(student);
        	System.out.println("student deleted");
        }
        
        
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
	}
//	get student by id
	public Student getStudent(int id) {
		Student student = null;
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
         student = session.get(Student.class, id);
        
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
		
		return student;
	}
	
//	get all students
	@SuppressWarnings("unchecked")
	public List <Student> getAllStudent() {
		
		List <Student>  listOfStudent = null;
		try {
			
        SessionFactory factory = HibernateUtil.getSessionFactory();
               
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
         listOfStudent = session.createQuery("from Student").getResultList();
        
        
        transaction.commit();

        session.close();
  
            
        } catch (Exception ex) {
     
                throw ex;
        }
		
		return listOfStudent;
	}

//	get Student by classe
	
//	@SuppressWarnings("unchecked")
//	public List <Student> getAllStudentByClasse(int classe_id) {
//		
//		List <Student>  listOfStudent = null;
//		try {
//			
//        SessionFactory factory = HibernateUtil.getSessionFactory();
//               
//        Session session = factory.openSession();
//        
//        Transaction transaction = session.beginTransaction();
//        String hql = "from Student S where S.classe.id = : classe_id";
//        Query query = session.createQuery(hql);
//        query.setParameter("classe_id", classe_id);
//        
//         listOfStudent = query.getResultList();
//        
//        
//        transaction.commit();
//
//        session.close();
//  
//            
//        } catch (Exception ex) {
//     
//                throw ex;
//        }
//		
//		return listOfStudent;
//	}
	
}
