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
    <title>Choose the repeat</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
  </head>
 
  <body>
  
  <jsp:include page="fragment/navbar.jspf" />
  
  <style>
  h1{
  	color: white;
  	text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
  }
  body{
   	background-image: url("images/header4.jpg");
  }
  </style> 
  
  <c:choose>
  <c:when test="${not empty requestScope.decks}">
  
  <br>
  <h1 class="centered">Choose deck:</h1>
  <br><br>
  
  <div class="form-group">
  	<label class="col-xs-4 control-label"></label>
  	<div class="col-xs-4 selectContainer">
  		<form action="repeat" method="post">
  		<select class="form-control" name="deck">
  			<option value="null"><c:out value="" /></option>
  			<c:if test="${not empty requestScope.decks}">
        	<c:forEach var="deck2" items="${requestScope.decks}" varStatus="stat">
        		<option value="${deck2.deck}"><c:out value="${deck2.deck}" /></option>
        	</c:forEach>
        	</c:if>
  		</select>
  		<br>
  		<div class="centered">
  		<input class="btn btn-success" type="submit" value="Start repeat!">
  		</div>
  		</form>
  	</div>
  </div>
  </c:when>
  <c:when test="${empty requestScope.decks}">
  		<br><br><br>
    	<h1 class="centered">You don't have any flashcards</h1>
    	<h1 class="centered"> <a href="${pageContext.request.contextPath}/new">Add it now</a></h1>
  </c:when>
  </c:choose>
  
  <jsp:include page="fragment/footer.jspf" />
     
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>