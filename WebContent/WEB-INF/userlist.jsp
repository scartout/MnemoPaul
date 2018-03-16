<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %> 
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Edit user</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
  </head>
 
  <body>

  	<jsp:include page="fragment/navbar.jspf" />
  	
  	<style>
   	h2{
  		color: white;
  		text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
  	}
  	th{
  		color: white;
  		text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
  	}
  	td{
  		background-color: #E8E8E8;
  	}
    body{
    	background-image: url("images/header4.jpg");
    }
    </style>
    
    <c:if test="${not empty requestScope.users}">
    <div class="container">
	  <h2>User list</h2>            
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Id</th>
	        <th>Login</th>
	        <th>Email</th>
	        <th>Role</th>
	      </tr>
	    </thead>
	    <tbody>
	      <c:forEach var="user" items="${requestScope.users}">
	      <tr>
	        <td>${user.user_id}</td>
	        <td>${user.username}</td>
	        <td>${user.email}</td>
	        <td>${user.role}</td>
			<c:if test="${user.role == 'user'}">
				<td><form action="updateuser" method="post">
				<input type="hidden" name="user_id" value="${user.user_id}">
	        	<input class="btn btn-warning" type="submit" value="Get Admin"></form></td>
				<td><form action="deleteuser" method="post">
				<input type="hidden" name="user_id" value="${user.user_id}">
	        	<input class="btn btn-danger" type="submit" value="Delete"></form></td></c:if>
	        <c:if test="${user.role != 'user'}">
	        	<td></td>
	        	<td></td>
	        </c:if>	
	      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	</div>
	</c:if>
     
	<jsp:include page="fragment/footer.jspf" />
     
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>