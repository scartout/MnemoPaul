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
    <title>Edit decks</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
  </head>
 
  <body>
  
  	<jsp:include page="fragment/navbar.jspf" />
    
    <div class="container">
	  <h2>Your cards list</h2>            
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Card pl</th>
	        <th>Card en</th>
	        <th>Card deck</th>
	        <th>Card tag</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	      	<td>${words.card_pl}</td>
	        <td>${words.card_en}</td>
	        <td>${words.deck}</td>
	        <td>${words.tag}</td>
	      </tr>
	    </tbody>
	   	
	   	<form action="update" method="post">
	   	<tbody>
	      <tr>
	      	<td><textarea maxlength="200" name="InputWord_pl" rows="10" name="Polish"
                    class="form-control" placeholder="Polish"></textarea></td>
            <td><textarea maxlength="200" name="InputWord_en" rows="10" name="English"
                    class="form-control" placeholder="English"></textarea></td>
            <td><textarea maxlength="200" name="InputDeck" rows="1" name="Deck"
                    class="form-control" placeholder="Deck"></textarea></td>
            <td><textarea maxlength="200" name="InputTag" rows="1" name="Tag"
                    class="form-control" placeholder="Tag" ></textarea></td>
            <td>
            <input type="hidden" name="word_id" value="${words.word_id}">
            <input class="btn btn-warning" type="submit" value="Update" />
			</td>      
	      </tr>
	    </tbody>
	    </form>
	  </table>
	</div>

    <c:if test="${empty requestScope.words}">
    	<h1 class="centered">You don't have any flashcards</h1>
    	<h1 class="centered"> <a href="${pageContext.request.contextPath}/new">Add it now</a></h1>
    </c:if>
     
	<jsp:include page="fragment/footer.jspf" />
     
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>