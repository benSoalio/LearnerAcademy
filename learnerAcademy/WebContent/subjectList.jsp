<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subject Management</title>
</head>
<body>
	<div align="center">
		<h1>List of Subjects</h1>
        <h2>
         <a href="SubjectController?action=new">Add New Subject</a>
         &nbsp;&nbsp;&nbsp;
         <a href="SubjectController?action=list">List All Subjects</a>
         
        </h2>
        <h3><a href="index.html">Home Page</a></h3>
	</div>
	<div align="center">
        
	<table border="1" cellpadding="5">
            <caption>List of Subjects</caption>
		<tr>
			<th>Subject Name</th>
			<th> Actions</th>
		</tr>
		<c:forEach var="subject" items="${listSubject}"> 
			<tr>
				<td><c:out value="${subject.subjectName}"></c:out></td>
				  
				<td>
                     <a href="SubjectController?action=edit&id=<c:out value='${subject.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="SubjectController?action=delete&id=<c:out value='${subject.id}' />">Delete</a>                     
                 </td>
			</tr>
		
		 </c:forEach> 
	</table>
	</div>
</body>
</html>