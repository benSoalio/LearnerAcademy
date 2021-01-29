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
import com.learnerAcademy.dao.StudentDAO;
import com.learnerAcademy.pojo.Classe;
import com.learnerAcademy.pojo.Student;


/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ClasseDAO classeDao = new ClasseDAO();
	private StudentDAO studentDao = new StudentDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
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
                insertStudent(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateStudent(request, response);
                break;
            default:

                listStudent(request, response);
                break;
			}
			
		} catch(SQLException ex) {
			throw new ServletException(ex);
		}
		
		
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Student > listStudent = studentDao.getAllStudent();
		        request.setAttribute("listStudent", listStudent);
		        
		        RequestDispatcher dispatcher = request.getRequestDispatcher("studentList.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
				List<Classe> listClasse = classeDao.getAllClasse();
				request.setAttribute("listClasse", listClasse);
				System.out.println("gogo " +listClasse);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("addStudent.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Student existingStudent =  studentDao.getStudent(id);
		        List<Classe> listClasse = classeDao.getAllClasse();
		        
		        request.setAttribute("student", existingStudent);
		        request.setAttribute("listClasse", listClasse);
		        
		        RequestDispatcher dispatcher = request.getRequestDispatcher("addStudent.jsp");
		        dispatcher.forward(request, response);
		        

		    }
	
	private void insertStudent(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		
		int classe_id = Integer.parseInt(request.getParameter("classe_id"));
		String studentName = request.getParameter("studentName");
		
		Classe classe = classeDao.getClasse(classe_id);
		
		Student student = new Student();
		student.setStudentName(studentName);
		student.setClasse(classe);
		
		studentDao.saveStudent(student);
		      
		response.sendRedirect("StudentController?action=list");
		        
		    }
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        int classe_id = Integer.parseInt(request.getParameter("classe_id"));
		        String studentName = request.getParameter("studentName");
		        
		        Student student = studentDao.getStudent(id);
		        Classe classe = classeDao.getClasse(classe_id);
		        
		        student.setStudentName(studentName);
		        student.setClasse(classe);
				
				
		        studentDao.updateStudent(student);
		        response.sendRedirect("StudentController?action=list");
		    }
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        studentDao.deleteStudent(id);
		        response.sendRedirect("StudentController?action=list");
		    }
}
