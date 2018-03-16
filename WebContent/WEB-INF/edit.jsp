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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
    body{
    	background-image: url("images/header4.jpg");
    }
    </style> 
    
    <div class="container">
	  <h2>Your cards list</h2>            
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Card pl</th>
	        <th>Card en</th>
	        <th>Card deck</th>
	        <th>Card tag</th>
	        <th> </th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	      	<td>${words.card_pl}</td>
	        <td>${words.card_en}</td>
	        <td>${words.deck}</td>
	        <td>${words.tag}</td>
	        <td> <td>
	      </tr>
	    </tbody>
	   	
	   	<form action="update" method="post">
	   	<tbody>
	      <tr>
	      	<td><textarea id="InputWordPl" "maxlength="200" name="InputWord_pl" rows="10" name="Polish"
                    class="form-control" placeholder="Polish"></textarea>
            <div id="resultPl">Remaining <span>200</span></div></td>
            <td><textarea id="InputWordEng" maxlength="200" name="InputWord_en" rows="10" name="English"
                    class="form-control" placeholder="English"></textarea>
            <div id="resultEng">Remaining <span>200</span></div></td>
            <td><textarea maxlength="50" id="InputDeck" name="InputDeck" rows="1" name="Deck"
                    class="form-control" placeholder="Deck"></textarea>
            <div id="resultDeck">Remaining <span>50</span></div></td>
            <td><textarea maxlength="50" id="InputTag" name="InputTag" rows="1" name="Tag"
                    class="form-control" placeholder="Tag" ></textarea>
            <div id="resultTag">Remaining <span>50</span></div></td>
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
    
    <script type="text/javascript">
	var limit1 = 200;
	$(document).ready(
	function()
	{
		$("#InputWordPl").keyup(
		function()
		{
			var count_chars1 = $(this).val().length;
			if (count_chars1 > limit1)
			{
				var new_value = $(this).val().substring(0, limit1);
				$(this).val(new_value)
			}
			$("#resultPl span").html(limit1 - $(this).val().length);
		});
	});
	</script>
	
	<script type="text/javascript">
	var limit2 = 200;
	$(document).ready(
	function()
	{
		$("#InputWordEng").keyup(
		function()
		{
			var count_chars2 = $(this).val().length;
			if (count_chars2 > limit2)
			{
				var new_value = $(this).val().substring(0, limit2);
				$(this).val(new_value)
			}
			$("#resultEng span").html(limit2 - $(this).val().length);
		});
	});
	</script>
	
	<script type="text/javascript">
	var limit3 = 50;
	$(document).ready(
	function()
	{
		$("#InputDeck").keyup(
		function()
		{
			var count_chars3 = $(this).val().length;
			if (count_chars3 > limit3)
			{
				var new_value = $(this).val().substring(0, limit3);
				$(this).val(new_value)
			}
			$("#resultDeck span").html(limit3 - $(this).val().length);
		});
	});
	</script>
	
	<script type="text/javascript">
	var limit4 = 50;
	$(document).ready(
	function()
	{
		$("#InputTag").keyup(
		function()
		{
			var count_chars4 = $(this).val().length;
			if (count_chars4 > limit4)
			{
				var new_value = $(this).val().substring(0, limit4);
				$(this).val(new_value)
			}
			$("#resultTag span").html(limit4 - $(this).val().length);
		});
	});
	</script>
     
	<jsp:include page="fragment/footer.jspf" />
     
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>