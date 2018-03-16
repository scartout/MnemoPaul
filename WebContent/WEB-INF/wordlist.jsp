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
    <title>Edit deck</title>
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
    
    <c:if test="${not empty requestScope.words}">
    <div class="container">
	  <h2>Your cards list</h2>            
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Card pl</th>
	        <th>Card en</th>
	        <th>Card deck</th>
	        <th>Card tag</th>
	        <th>Review date</th>
	      </tr>
	    </thead>
	    <tbody>
	      <c:forEach var="word" items="${requestScope.words}">
	      <tr>
	        <td>${word.card_pl}</td>
	        <td>${word.card_en}</td>
	        <td>${word.deck}</td>
	        <td>${word.tag}</td>
	        <td>${word.date}</td>
	        <td><form action="edit" method="post">
				<input type="hidden" name="word_id" value="${word.word_id}">
	        	<input class="btn btn-warning" type="submit" value="Edit"></form></td>
			<td><form action="delete" method="post">
				<input type="hidden" name="word_id" value="${word.word_id}">
	        	<input class="btn btn-danger" type="submit" value="Delete"></form></td>
	      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	</div>
	</c:if>

    <c:if test="${empty requestScope.words}">
    	<br><br><br><br><br>
    	<h1 class="centered">You don't have any flashcards</h1>
    	<h1 class="centered"> <a href="${pageContext.request.contextPath}/new">Add it now</a></h1>
    </c:if>
     
	<jsp:include page="fragment/footer.jspf" />
     
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>