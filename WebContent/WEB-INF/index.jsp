<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <title>MnemoPaul</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
  	<link rel="stylesheet" href="assets/css/main.css" />
  </head>
 
  <body>
    
    <jsp:include page="fragment/navbar.jspf"/>
   
	<section id="header" class="dark">
		<header>
			<h1>Welcome to MnemoPaul</h1>
			<p>Learn English with mnemonics</p>
		</header>
		<footer>
			<a href="${pageContext.request.contextPath}/login" class="button scrolly"><span class="glyphicon glyphicon-log-in"></span> Sign in or register</a>
			<a href="${pageContext.request.contextPath}/new" class="button scrolly"><span class="glyphicon glyphicon-plus"></span> Add new card</a>
			<a href="${pageContext.request.contextPath}/wordlist" class="button scrolly"><span class="glyphicon glyphicon-scissors"></span> Edit existing card</a>
			<a href="${pageContext.request.contextPath}/repeatchoise" class="button scrolly"><span class="glyphicon glyphicon-list"></span> Start repeat</a>
		</footer>
	</section>


     
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>