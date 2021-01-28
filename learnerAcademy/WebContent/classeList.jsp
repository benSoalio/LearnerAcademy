<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of classes</title>
</head>
<body>

	<div align="center">
		<h1>List of classes</h1>
        <h2>
         <a href="ClasseController?action=new">Add New Classe</a>
         &nbsp;&nbsp;&nbsp;
         <a href="ClasseController?action=list">List All Classe</a>
         
        </h2>
        <h3><a href="index.html">Home Page</a></h3>
	</div>
	<div align="center">
        
	<table border="1" cellpadding="5">
            <caption>List of Classes</caption>
		<tr>
			<th>Classe Name</th>
			<th>Teacher Name</th>
			<th>Subject Name</th>
			<th> Actions</th>
		</tr>
		<c:forEach var="classe" items="${listClasse}"> 
			<tr>
				<td><c:out value="${classe.classeName}"></c:out></td>
				 <td><c:out value="${classe.teacher.teacherName}"></c:out></td>
				<td><c:out value="${classe.subject.subjectName}"></c:out></td> 
				<td>
                     <a href="ClasseController?action=edit&id=<c:out value='${classe.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="ClasseController?action=delete&id=<c:out value='${classe.id}' />">Delete</a>                     
                 </td>
			</tr>
		
		 </c:forEach> 
	</table>
	</div>
</body>
</html>