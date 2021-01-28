<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher Management</title>
</head>
<body>
	<div align="center">
		<h1>List of Teacher</h1>
        <h2>
         <a href="TeacherController?action=new">Add New Teacher</a>
         &nbsp;&nbsp;&nbsp;
         <a href="TeacherController?action=list">List All Teachers</a>
         
        </h2>
        <h3><a href="index.html">Home Page</a></h3>
	</div>
	<div align="center">
        
	<table border="1" cellpadding="5">
            <caption>List of Teachers</caption>
		<tr>
			<th>Teacher Name</th>
			<th> Actions</th>
		</tr>
		<c:forEach var="teacher" items="${listTeacher}"> 
			<tr>
				<td><c:out value="${teacher.teacherName}"></c:out></td>
				  
				<td>
                     <a href="TeacherController?action=edit&id=<c:out value='${teacher.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="TeacherController?action=delete&id=<c:out value='${teacher.id}' />">Delete</a>                     
                 </td>
			</tr>
		
		 </c:forEach> 
	</table>
	</div>
</body>
</html>