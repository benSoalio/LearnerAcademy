<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management</title>
</head>
<body>
	<div align="center">
		<h1>List of Students</h1>
        <h2>
         <a href="StudentController?action=new">Add New Student</a>
         &nbsp;&nbsp;&nbsp;
         <a href="StudentController?action=list">List All Students</a>
         
        </h2>
        <h3><a href="index.html">Home Page</a></h3>
	</div>
	<div align="center">
        
	<table border="1" cellpadding="5">
            <caption>List of Classes</caption>
		<tr>
			<th>Student Name</th>
			<th>Classe Name</th>
			<th> Actions</th>
		</tr>
		<c:forEach var="student" items="${listStudent}"> 
			<tr>
				<td><c:out value="${student.studentName}"></c:out></td>
				 <td><c:out value="${student.classe.classeName}"></c:out></td> 
				<td>
                     <a href="StudentController?action=edit&id=<c:out value='${student.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="StudentController?action=delete&id=<c:out value='${student.id}' />">Delete</a>                     
                 </td>
			</tr>
		
		 </c:forEach> 
	</table>
	</div>
</body>
</html>