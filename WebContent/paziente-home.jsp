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

<title>Homepage Paziente</title>

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
				<div class="navbar-collapse collapse" aria-expanded="false"
					style="height: 1px;">
					<ul class="nav navbar-nav">
						<li class="active"><a href="paziente.jsp">Benvenuto
								${pazienteController.paziente.nome}</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
		</div>
	</nav>

	<!-- Main jumbotron for a primary marketing message or call to action -->

	<div class="container">
		<!-- Secondo gruppo di colonne -->
		<f:view>
		<div class="row">
			<div class="col-md-4">
				<h2>Consulta Tipologie Esame</h2>
				<p>Consulta l'elenco delle Tipologie Offerte dalla clinica Heaven Hospital.</p>
				<p>
					<h:form>
						<h:commandButton action="#{tipologiaEsameController.listTipologieEsame}" 
							value="Elenco Tipologie Esame" type="submit"/>
					</h:form>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Consulta Esami</h2>
				<p>Consulta l'elenco dei tuoi esami e richiedene il dettaglio per i risultati, se esistono.</p>
				<p>
					<a class="btn btn-default" href='<c:url value="#" />' role="button">Elenco Esami
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				
			</div>
		</div>		
		</f:view>
		
		<hr>

		<footer>
			<p>
				&copy; 2016 Sistemi Informativi su Web, <b>Mariani Matteo</b> e <b>Marino
					Bernardo</b>
			</p>
		</footer>
	</div>
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

