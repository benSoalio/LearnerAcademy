<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Classe</title>
</head>
<body>

	<div align="center">
		<h1>Classe Management</h1>
        <h2>
         <a href="ClasseController?action=new">Add New Classe</a>
         &nbsp;&nbsp;&nbsp;
         <a href="ClasseController?action=list">List All Classe</a>
         
        </h2>
	</div>
	
	<div align="center">
		 <c:if test="${classe != null }">
			<form action="ClasseController?action=update" method="post">
		</c:if> 
		 <c:if test="${classe == null }"> 
			<form action="ClasseController?action=insert" method="post">
		 </c:if>
			<table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${ classe != null}">
               Edit Classe
              </c:if> 
              <c:if test="${classe == null}">
               Add New Classe
              </c:if>
             </h2>
            </caption>
          <c:if test="${classe != null}">
           <input type="hidden" name="id" value="<c:out value='${classe.id}' />" />
          </c:if>           
            <tr>
                <th>Classe Name: </th>
                <td>
                 <input type="text" name="classeName" size="45"
                   value="<c:out value='${classe.classeName}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Classe Subject: </th>
                <td>
                <select id="subject" name="subject_id">
                	<c:forEach var="subject" items="${listSubject}">
                		<option value="${subject.id}">${subject.subjectName}</option>
                	</c:forEach>	
                </select>
                </td>
            </tr>
            
            <tr>
                <th>Classe Teacher: </th>
                <td>
                <select id="teacher" name="teacher_id">
                	<c:forEach var="teacher" items="${listTeacher}">
                		<option value="${teacher.id}">${teacher.teacherName}</option>
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
	
	<!-- <h1>Add Classe</h1>
	<form action="ClasseController">
		<label for="classeName">Classe name:</label> 
		<input type="text" id="classeName" name="classeName"><br>
		
		<br> <label for="teacherName">Teacher name:</label> 
		<input type="text" id="teacherName" name="teacherName"><br>
		
		<br> <label for="subjectName">Subject name:</label> 
		<input type="text" id="subjectName" name="subjectName"><br>
		<br> <input type="submit" value="Submit">

	</form> -->
</body>
</html>