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
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  </head>
 
  <body>
  
  	<jsp:include page="fragment/navbar.jspf" />

   	<style>
   	h2{
  		color: white;
  		text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
  	}
  	div{
  		color: white;
  		text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
  	}
    body{
    	background-image: url("images/header4.jpg");
    }
    </style> 

    <div class="container">
        <div class="col-md-8 col-md-offset-2">
            <form class="form-signin" method="post" action="new">
            	<br>
                <h2 class="form-signin-heading">Add new word</h2>
                <textarea maxlength="200" id="InputWordPl" name="InputWord_pl" rows="3" name="Polish card"
                    class="form-control" placeholder="Polish" required autofocus></textarea>
                <div id="resultPl">Remaining <span>200</span></div>
                <textarea maxlength="200" id="InputWordEng" name="InputWord_en" rows="3" name="English card"
                    class="form-control" placeholder="English" required autofocus></textarea>
                <div id="resultEng">Remaining <span>200</span></div>
                <textarea maxlength="50" id="InputDeck" name="InputDeck" rows="1" name="Deck"
                    class="form-control" placeholder="Deck" required autofocus></textarea>
                <div id="resultDeck">Remaining <span>50</span></div>
                <textarea maxlength="50" id="InputTag" name="InputTag" rows="1" name="Tag"
                    class="form-control" placeholder="Tag" ></textarea>
                <div id="resultTag">Remaining <span>50</span></div>
                <input class="btn btn-lg btn-primary btn-block" type="submit"
                    value="Add" />
                
            </form>
        </div>
    </div>
    
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