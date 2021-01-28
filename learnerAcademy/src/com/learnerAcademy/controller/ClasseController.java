package com.learnerAcademy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnerAcademy.dao.ClasseDAO;
import com.learnerAcademy.dao.SubjectDAO;
import com.learnerAcademy.dao.TeacherDAO;
import com.learnerAcademy.pojo.Classe;
import com.learnerAcademy.pojo.Subject;
import com.learnerAcademy.pojo.Teacher;


/**
 * Servlet implementation class ClasseController
 */
@WebServlet("/ClasseController")
public class ClasseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClasseDAO classeDao  = new ClasseDAO();
	private TeacherDAO teacherDao = new TeacherDAO();
	private SubjectDAO subjectDao = new SubjectDAO();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClasseController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		try {
			switch(action) {
			case "new" :
//				System.out.print(action);
				showNewForm(request, response);
			case "insert":
                insertClasse(request, response);
                break;
            case "delete":
                deleteClasse(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateClasse(request, response);
                break;
            default:
//            	System.out.print(action);
                listClasse(request, response);
                break;
			}
			
		} catch(SQLException ex) {
			throw new ServletException(ex);
		}
		
		
		
	}
	
	private void listClasse(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Classe > listClasse = classeDao.getAllClasse();
		        request.setAttribute("listClasse", listClasse);
		        
		        RequestDispatcher dispatcher = request.getRequestDispatcher("classeList.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
				List<Subject> listSubject = subjectDao.getAllSubject();
				List <Teacher> listTeacher = teacherDao.getAllTeacher();
				request.setAttribute("listSubject", listSubject);
				request.setAttribute("listTeacher", listTeacher);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("addClasse.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Classe existingClasse =  classeDao.getClasse(id);
		        List<Subject> listSubject = subjectDao.getAllSubject();
		        List <Teacher> listTeacher = teacherDao.getAllTeacher();
		        
		        request.setAttribute("classe", existingClasse);
		        request.setAttribute("listSubject", listSubject);
		        request.setAttribute("listTeacher", listTeacher);
		        
		        RequestDispatcher dispatcher = request.getRequestDispatcher("addClasse.jsp");
		        dispatcher.forward(request, response);
		        

		    }
	
	private void insertClasse(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		String classeName = request.getParameter("classeName");
		int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
        int subject_id = Integer.parseInt(request.getParameter("subject_id"));
		
        Subject subject = subjectDao.getSubject(subject_id);
		
        Teacher teacher = teacherDao.getTeacher(teacher_id);
		
		Classe classe = new Classe(classeName,teacher, subject);
		
		classeDao.saveClasse(classe);
      
		response.sendRedirect("ClasseController?action=list");
		        
		    }
	
	private void updateClasse(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
		        int subject_id = Integer.parseInt(request.getParameter("subject_id"));
		        String classeName = request.getParameter("classeName");
		        
				
				Subject subject = subjectDao.getSubject(subject_id);
				
				
				Teacher teacher = teacherDao.getTeacher(teacher_id);
				
		        
		        Classe classe = classeDao.getClasse(id);
		        classe.setTeacher(teacher);
		        classe.setSubject(subject);
		        classe.setClasseName(classeName);
		        
		        classeDao.updateClasse(classe);
		        response.sendRedirect("ClasseController?action=list");
		    }
	
	private void deleteClasse(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        classeDao.deleteClasse(id);
		        response.sendRedirect("ClasseController?action=list");
		    }
	
	
	
	

}
