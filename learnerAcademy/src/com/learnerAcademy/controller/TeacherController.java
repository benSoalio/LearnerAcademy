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

import com.learnerAcademy.dao.TeacherDAO;

import com.learnerAcademy.pojo.Teacher;

/**
 * Servlet implementation class TeacherController
 */
@WebServlet("/TeacherController")
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private TeacherDAO teacherDao  = new TeacherDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherController() {
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
		String action = request.getParameter("action");
		
		
		try {
			switch(action) {
			case "new" :
//				System.out.print(action);
				showNewForm(request, response);
			case "insert":
                insertTeacher(request, response);
                break;
            case "delete":
                deleteTeacher(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateTeacher(request, response);
                break;
            default:
//            	System.out.print(action);
                listTeacher(request, response);
                break;
			}
			
		} catch(SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Teacher > listTeacher = teacherDao.getAllTeacher();
		        request.setAttribute("listTeacher", listTeacher);
		        
		        RequestDispatcher dispatcher = request.getRequestDispatcher("teacherList.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
//				List<Classe> listClasse = classeDao.getAllClasse();
//				request.setAttribute("listClasse", listClasse);
//				System.out.println("gogo " +listClasse);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("addTeacher.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Teacher existingTeacher =  teacherDao.getTeacher(id);
//		        List<Classe> listClasse = classeDao.getAllClasse();
		        
		        request.setAttribute("teacher", existingTeacher);
//		        request.setAttribute("listClasse", listClasse);
		        
		        RequestDispatcher dispatcher = request.getRequestDispatcher("addTeacher.jsp");
		        dispatcher.forward(request, response);
		        
		    }
	
	private void insertTeacher(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		
//		int classe_id = Integer.parseInt(request.getParameter("classe_id"));
		String teacherName = request.getParameter("teacherName");
		
//		Classe classe = classeDao.getClasse(classe_id);
		
		Teacher teacher = new Teacher();
		teacher.setTeacherName(teacherName);
		
		
//		teacherDao.saveTeacher(teacher);
		      
		response.sendRedirect("TeacherController?action=list");
		teacherDao.saveTeacher(teacher);
		        
		    }
	
	private void updateTeacher(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
//		        int classe_id = Integer.parseInt(request.getParameter("classe_id"));
		        String teacherName = request.getParameter("teacherName");
		        
		        Teacher teacher = teacherDao.getTeacher(id);
//		        Classe classe = classeDao.getClasse(classe_id);
		        
		        teacher.setTeacherName(teacherName);
//		        student.setClasse(classe);
				
				
		        teacherDao.updateTeacher(teacher);
		        response.sendRedirect("TeacherController?action=list");
		    }
	
	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        teacherDao.deleteTeacher(id);
		        response.sendRedirect("TeacherController?action=list");
		    }

}
