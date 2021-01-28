<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Subject</title>
</head>
<body>

	<div align="center">
		<h1>Subject Management</h1>
        <h2>
         <a href="SubjectController?action=new">Add New Subject</a>
         &nbsp;&nbsp;&nbsp;
         <a href="SubjectController?action=list">List All Subjects</a>
         
        </h2>
	</div>
	<div align="center">
		 <c:if test="${subject != null }">
			<form action="SubjectController?action=update" method="post">
		</c:if> 
		 <c:if test="${subject == null }"> 
			<form action="SubjectController?action=insert" method="post">
		 </c:if>
			<table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${subject != null}">
               Edit Subject
              </c:if> 
              <c:if test="${subject == null}">
               Add New Subject
              </c:if>
             </h2>
            </caption>
          <c:if test="${subject != null}">
           <input type="hidden" name="id" value="<c:out value='${subject.id}' />" />
          </c:if>           
            <tr>
                <th>Subject Name: </th>
                <td>
                 <input type="text" name="subjectName" size="45"
                   value="<c:out value='${subject.subjectName}' />"
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