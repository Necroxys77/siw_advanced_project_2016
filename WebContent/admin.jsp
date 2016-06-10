<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"/>

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css"/>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Amministratore</title>
</head>
<body>

	<f:view>

		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
				<a class="navbar-brand" href="index.jsp">Heaven-Hospital</a>
				</div>
				
				<!--/.nav-collapse -->
			</div>
		</nav>
		<div class="jumbotron">
		<div class="container">
			
				<h2>Hello ${amministratoreController.amministratore.email} !</h2>
				<div>Nome: ${amministratoreController.amministratore.nome}</div>
				<div>Cognome: ${amministratoreController.amministratore.cognome}</div>
				

				<a href="admin-home.jsp" class="btn btn-primary">Sezione amministratore</a>
			</div>
		</div>
	</f:view>

</body>
</html>