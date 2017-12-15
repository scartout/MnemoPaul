<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Add new word</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
  </head>
 
  <body>
  
  	<jsp:include page="fragment/navbar.jspf" />
     
    <div class="container">
        <div class="col-md-8 col-md-offset-2">
            <form class="form-signin" method="post" action="new">
            	<br>
                <h2 class="form-signin-heading">Add new word</h2>
                <textarea maxlength="200" name="InputWord_pl" rows="5" name="Polish card"
                    class="form-control" placeholder="Polish" required autofocus></textarea>
                <textarea maxlength="200" name="InputWord_en" rows="5" name="English card"
                    class="form-control" placeholder="English" required autofocus></textarea>
                <textarea maxlength="200" name="InputDeck" rows="1" name="Deck"
                    class="form-control" placeholder="Deck" required autofocus></textarea>
                <textarea maxlength="200" name="InputTag" rows="1" name="Tag"
                    class="form-control" placeholder="Tag" ></textarea>
                <input class="btn btn-lg btn-primary btn-block" type="submit"
                    value="Add" />
            </form>
        </div>
    </div>
     
	<jsp:include page="fragment/footer.jspf" />
     
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>