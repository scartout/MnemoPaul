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
    <title>Review</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
  </head>
 
  <body>
  
  	<jsp:include page="fragment/navbar.jspf" />
    
    <%
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
	Date now = new Date();
	Calendar cal = Calendar.getInstance();
	
	String buttonnull=null;
	
	String button0days=sdf.format(new Date());
	
	cal.setTime(now);
	cal.add(Calendar.DAY_OF_YEAR, 4);
	Date now4days = cal.getTime();
	String button4days=sdf.format(now4days);
	
	cal.setTime(now);
	cal.add(Calendar.DAY_OF_YEAR, 10);
	Date now10days = cal.getTime();
	String button10days=sdf.format(now10days);
	
	cal.setTime(now);
	cal.add(Calendar.DAY_OF_YEAR, 20);
	Date now20days = cal.getTime();
	String button20days=sdf.format(now20days);
	
	cal.setTime(now);
	cal.add(Calendar.DAY_OF_YEAR, 30);
	Date now30days = cal.getTime();
	String button30days=sdf.format(now30days);
	%>
	
    <br><br><br>
    <c:if test="${not empty requestScope.words}">
        <c:forEach var="word" items="${requestScope.words}" varStatus="stat">
        	<c:if test="${stat.first}">
            <div class="container">
              <div class="row bs-callout bs-callout-primary">
                <div class="col-md-6 col-md-offset-3">
                <h4 class="centered"><c:out value="${word.deck}" /></h4>
                  <h4 class="centered"><c:out value="${word.tag}" /></h4>
                  <h1 class="centered"><c:out value="${word.card_pl}" /></h1>
                 <div id="spoiler" style="display:none"> 
    				<h1 class="centered"><c:out value="${word.card_en}" /></h1>
    				<div class="centered">
    				<table>
    					<c:if test="${word.date == null}">
    					<form action="date" method="post">
    						<input type="hidden" name="word_id" value="${word.word_id}">
    						<input type="hidden" name="date" value=<%=buttonnull%>>
				    		<input class="btn btn-default" type="submit" value="Again">
				    	</form>
    					</c:if>
    					<form action="date" method="post">
    						<input type="hidden" name="word_id" value="${word.word_id}">
    						<input type="hidden" name="date" value=<%=button0days%>>
				    		<input class="btn btn-danger" type="submit" value="Today">
				    	</form>
    					<form action="date" method="post">
    						<input type="hidden" name="word_id" value="${word.word_id}">
    						<input type="hidden" name="date" value=<%=button4days%>>
				    		<input class="btn btn-warning" type="submit" value="4 days">
				    	</form>
	    				<c:if test="${word.date != null && word.date >= now}">
	    				<form action="date" method="post">
    						<input type="hidden" name="word_id" value="${word.word_id}">
    						<input type="hidden" name="date" value=<%=button10days%>>
				    		<input class="btn btn-success" type="submit" value="10 days">
				    	</form> 	
						<form action="date" method="post">
    						<input type="hidden" name="word_id" value="${word.word_id}">
    						<input type="hidden" name="date" value=<%=button20days%>>
				    		<input class="btn btn-info" type="submit" value="20 days">
				    	</form> 
						<form action="date" method="post">
    						<input type="hidden" name="word_id" value="${word.word_id}">
    						<input type="hidden" name="date" value=<%=button30days%>>
				    		<input class="btn btn-primary" type="submit" value="30 days">
				    	</form>
				    	</c:if>
				    </table>		
		    		</div>
    			</div>
    			<div class="centered">
    				<br>
    				<button class="btn btn-default" title="Unhide" type="button" onclick="if(document.getElementById('spoiler')
        				.style.display=='none') {document.getElementById('spoiler')
        				.style.display=''}else{document.getElementById('spoiler')
            			.style.display='none'}">Unhide/hide</button><br>
                </div>
                </div>
              </div>
            </div>
    	</c:if>
        </c:forEach>
    </c:if>
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