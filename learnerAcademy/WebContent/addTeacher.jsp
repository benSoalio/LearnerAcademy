<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Teacher</title>
</head>
<body>

	<div align="center">
		<h1>Teacher Management</h1>
        <h2>
         <a href="TeacherController?action=new">Add New Teacher</a>
         &nbsp;&nbsp;&nbsp;
         <a href="TeacherController?action=list">List All Teachers</a>
         
        </h2>
	</div>
	<div align="center">
		 <c:if test="${teacher != null }">
			<form action="TeacherController?action=update" method="post">
		</c:if> 
		 <c:if test="${teacher == null }"> 
			<form action="TeacherController?action=insert" method="post">
		 </c:if>
			<table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${teacher != null}">
               Edit Teacher
              </c:if> 
              <c:if test="${teacher == null}">
               Add New Teacher
              </c:if>
             </h2>
            </caption>
          <c:if test="${teacher != null}">
           <input type="hidden" name="id" value="<c:out value='${teacher.id}' />" />
          </c:if>           
            <tr>
                <th>Teacher Name: </th>
                <td>
                 <input type="text" name="teacherName" size="45"
                   value="<c:out value='${teacher.teacherName}' />"
                  />
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