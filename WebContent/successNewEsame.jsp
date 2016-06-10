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

<title>Riepilogo Esame</title>

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
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href='<c:url value="/faces/index.jsp" />'>Homepage</a>
				<a class="navbar-brand"
					href='<c:url value="/faces/admin-home.jsp" />'>Sezione
					Amministratore</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<form class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" placeholder="Email" class="form-control">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control">
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
				</form>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<!-- Main jumbotron for a primary marketing message or call to action -->

	<div class="container">


		<f:view>
			<h1>Inserimento nuovo Esame effettuato con successo!</h1>
			<br>
			<hr>
			<br>
			<h2>Dettagli</h2>
			<br>

			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome Paziente</th>
						<th>Cognome Paziente</th>
						<th>Id Medico</th>
						<th>Nome Medico</th>
						<th>Cognome Medico</th>
						<th>Tipologia Esame</th>
						<th>Data di Prenotazione</th>
						<th>Data Esame</th>
					</tr>
				</thead>
				<tbody>
					<tr class="success">
						<td>${esameController.esame.id}</td>
						<td>${esameController.esame.paziente.nome}</td>
						<td>${esameController.esame.paziente.cognome}</td>
						<td>${esameController.esame.medico.id}</td>
						<td>${esameController.esame.medico.nome}</td>
						<td>${esameController.esame.medico.cognome}</td>
						<td>${esameController.esame.tipologiaEsame.nome}</td>
						<td>${esameController.esame.dataDiPrenotazione}</td>
						<td>${esameController.esame.dataDiEsecuzione}</td>
					</tr>
				</tbody>
			</table>

			<br>
			<br>
			<div>
				<a href='<c:url value="/faces/newEsame.jsp" />'>Continua
					ad inserire nuovi <i>Esami</i>
				</a>. <br> <a href='<c:url value="/faces/admin-home.jsp" />'>Concludi
					inserimento <i>Esami</i>
				</a>.
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

