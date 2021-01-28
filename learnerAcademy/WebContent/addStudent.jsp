<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
</head>
<body>

	<div align="center">
		<h1>Student Management</h1>
        <h2>
         <a href="StudentController?action=new">Add New Student</a>
         &nbsp;&nbsp;&nbsp;
         <a href="StudentController?action=list">List All Student</a>
         
        </h2>
	</div>
	
	<div align="center">
		 <c:if test="${student != null }">
			<form action="StudentController?action=update" method="post">
		</c:if> 
		 <c:if test="${student == null }"> 
			<form action="StudentController?action=insert" method="post">
		 </c:if>
			<table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${student != null}">
               Edit Student
              </c:if> 
              <c:if test="${student == null}">
               Add New Student
              </c:if>
             </h2>
            </caption>
          <c:if test="${student != null}">
           <input type="hidden" name="id" value="<c:out value='${student.id}' />" />
          </c:if>           
            <tr>
                <th>Student Name: </th>
                <td>
                 <input type="text" name="studentName" size="45"
                   value="<c:out value='${student.studentName}' />"
                  />
                </td>
            </tr>
            
            <tr>
                <th>Student Classe: </th>
                <td>
                 <select id="subject" name="classe_id">
                	<c:forEach var="classe" items="${listClasse}">
                		<option value="${classe.id}">${classe.classeName}</option>
                	</c:forEach>	
                </select>
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
		</form>
		
	</div>
</body>
</html>