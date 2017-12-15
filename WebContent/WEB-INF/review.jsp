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
	
	<jsp:useBean id="dateValue" class="java.util.Date" />
	<jsp:setProperty name="dateValue" property="time" value="${h.time}" />
    
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
    					<c:if test="${word.date == null}">
    						<a href="${pageContext.request.contextPath}/date?word_id=${word.word_id}&date=<%=buttonnull%>"
				    		class="btn btn-default" type="button">Again</a>
    					</c:if> 
    					<a href="${pageContext.request.contextPath}/date?word_id=${word.word_id}&date=<%=button0days%>"
				    	class="btn btn-danger" type="button">Today</a>
				    	<a href="${pageContext.request.contextPath}/date?word_id=${word.word_id}&date=<%=button4days%>"
				    	class="btn btn-warning" type="button">4 days</a>
	    				<c:if test="${word.date != null}">
	    					<a href="${pageContext.request.contextPath}/date?word_id=${word.word_id}&date=<%=button10days%>"
					    	class="btn btn-success" type="button">10 days</a>
		    				<c:if test="${(word.date < dateValue)}">	
						    	<a href="${pageContext.request.contextPath}/date?word_id=${word.word_id}&date=<%=button20days%>"
						    	class="btn btn-info" type="button">20 days</a>
						    	<a href="${pageContext.request.contextPath}/date?word_id=${word.word_id}&date=<%=button30days%>"
					    		class="btn btn-primary" type="button">30 days</a>
				    		</c:if> 
				    	</c:if>
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