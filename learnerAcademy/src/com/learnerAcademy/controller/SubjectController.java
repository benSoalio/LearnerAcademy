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

import com.learnerAcademy.dao.SubjectDAO;

import com.learnerAcademy.pojo.Subject;

/**
 * Servlet implementation class SubjectController
 */
@WebServlet("/SubjectController")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SubjectDAO subjectDao  = new SubjectDAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectController() {
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

				showNewForm(request, response);
			case "insert":
                insertSubject(request, response);
                break;
            case "delete":
                deleteSubject(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateSubject(request, response);
                break;
            default:

                listSubject(request, response);
                break;
			}
			
		} catch(SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listSubject(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Subject > listSubject = subjectDao.getAllSubject();
		        request.setAttribute("listSubject", listSubject);
		        
		        RequestDispatcher dispatcher = request.getRequestDispatcher("subjectList.jsp");
		        dispatcher.forward(request, response);
		    }

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {

		        RequestDispatcher dispatcher = request.getRequestDispatcher("addSubject.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Subject existingSubject =  subjectDao.getSubject(id);

		        
		        request.setAttribute("subject", existingSubject);

		        
		        RequestDispatcher dispatcher = request.getRequestDispatcher("addSubject.jsp");
		        dispatcher.forward(request, response);
		        

		    }
	
	private void insertSubject(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		

		String subjectName = request.getParameter("subjectName");
		

		
		Subject subject = new Subject();
		subject.setSubjectName(subjectName);
		
		

		      
		response.sendRedirect("SubjectController?action=list");
		subjectDao.saveSubject(subject);
		        
		    }
	
	private void updateSubject(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));

		        String subjectName = request.getParameter("subjectName");
		        
		        Subject subject = subjectDao.getSubject(id);

		        
		        subject.setSubjectName(subjectName);

				
				
		        subjectDao.updateSubject(subject);
		        response.sendRedirect("SubjectController?action=list");
		    }
	
	private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        subjectDao.deleteSubject(id);
		        response.sendRedirect("SubjectController?action=list");
		    }

}
