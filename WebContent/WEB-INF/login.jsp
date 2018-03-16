<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
    <title>Sign in</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
	
  </head>

  <body>
  
  	<jsp:include page="fragment/navbar.jspf"/>
  
    <style>
  	h2{
  		color: white;
  		text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
  	}
  	body{
  		background-image: url("images/header2.png");
  	}
  	</style>
  
  	<br></br>
    <div class="container">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <form class="form-signin" action="j_security_check" method="post">
                <h2 class="form-signin-heading">Sign in</h2>
                <input name="j_username" type="text" class="form-control" placeholder="Login" required autofocus>
                <input name="j_password" type="password" class="form-control" placeholder="Password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                <br></br>
                <h2 class="form-signin-heading">Or register</h2>
                <a class="btn btn-lg btn-primary btn-block" href="${pageContext.request.contextPath}/register">Register</a>
            </form>
        </div>
    </div>
     
    <jsp:include page="fragment/footer.jspf"/> 
     
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>