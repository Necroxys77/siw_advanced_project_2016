<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Login</title>

<!-- Bootstrap core CSS -->
<link href="Static/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="Static/css/jumbotron.css" rel="stylesheet">

<!-- personal css -->
<link href="Static/css/personal.css" rel="stylesheet">
</head>

<body>		
			 					
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.jsp">Homepage</a>
				</div>
				<!--/.nav-collapse -->
		</div>
	</nav>
	
	
	
	
	<f:view>
	<div class="container">
		<h:form>
		<div class="col-md-6 col-md-offset-3">
		
			<div class="form-group has-error form-group-sm">
			
				<h2 class="form-signin-heading">Inserisci i dati per l'autenticazione</h2>

					<label for="inputEmail" >Email: </label>
				
					<h:inputText styleClass="form-control" value="#{amministratoreController.email}" required="true"
						requiredMessage="Email obbligatoria" id="email" />
					<h:message for="email" />
					<br>
					<label for="inputPassword" >Password:</label>
					
					<h:inputSecret styleClass="form-control" value="#{amministratoreController.password}"
						required="true" requiredMessage="Password obbligatoria"
						id="password" />
					<h:message for="password" />
				 <label class="control-label" for="inputError1">${amministratoreController.loginErr}</label>
					<h:commandButton styleClass="btn btn-lg btn-primary btn-block"
						value="Submit" action="#{amministratoreController.validate}" />

			</div>
			<hr>
			</div>
		</h:form>
		
		</div>
	</f:view>
	
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script language="JavaScript" type="text/javascript"
		src="Static/js/jquery.min.js"></script>
	<script language="JavaScript" type="text/javascript"
		src="Static/js/bootstrap.min.js"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

	
</body>
</html>