<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Register</title>
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
  	body{
  		background-image: url("images/header2.png");
  	}
  	</style>
     
    <br><br>
    <div class="container">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <form class="form-signin" method="post" action="#">
                <h2 class="form-signin-heading">Register</h2>
                <input name="inputUsername" type="text" name="inputUsername" class="form-control" placeholder="Login" required autofocus />
                <input name="inputPassword" type="password" class="form-control" placeholder="Password" required />
                <input name="confirmPassword" type="password" class="form-control" placeholder="Confirm password" required />
                <input name="inputEmail" type="email" class="form-control" placeholder="E-mail" required autofocus />
                <button class="btn btn-lg btn-primary btn-block" type="submit" >Register</button>
            </form>
        </div>
    </div>
     
    <jsp:include page="fragment/footer.jspf" />
     
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>