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

<title>Homepage Amministratore</title>

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
				<a	class="navbar-brand" href='<c:url value="/faces/index.jsp" />'>Homepage</a> <a 
					class="navbar-brand" href="#">Sezione Amministratore</a>
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
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>Inserimento nuova Tipologia Esame</h2>
				<p>Inserisci una nuova Tipologia Esame nell'offerta della clinica Heaven Hospital.
					<u>Attenzione: non potranno essere inserite Tipologie Esame che condividono lo stesso nome</u>.
					Consulta prima l'elenco delle Tipologie Esame offerte per evitare incovenienti. </p>
				<p>
					<a class="btn btn-default" href='<c:url value="/faces/newTipologiaEsame.jsp" />' role="button">Inserisci nuova Tipologia
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Inserimento nuovo Esame</h2>
				<p>Inserisci un nuovo Esame per un paziente della clinica Heaven Hospital.</p>
				<p>
					<a class="btn btn-default" href='<c:url value="/faces/newEsame.jsp" />' role="button">Inserisci nuovo Esame
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Inserimento Risultati Esame</h2>
				<p>Inserisci i Risultati di un esame di un paziente della clinica Heaven Hospital</p>
				<p>
					<a class="btn btn-default" href="#" role="button">Inserisci Risultati Esame
						&raquo;</a>
				</p>
			</div>
		</div>
		<hr>
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
				<h2>Inserimento nuovo Amministratore</h2>
				<p>Inserisci un nuovo Amministratore della clinica Heaven Hospital.</p>
				<p>
					<a class="btn btn-default" href='<c:url value="/faces/newAmministratore.jsp" />' role="button">Inserisci nuovo Amministratore
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Inserimento nuovo Paziente</h2>
				<p>Inserisci un nuovo Paziente nella clinica Heaven Hospital.</p>
				<p>
					<a class="btn btn-default" href='<c:url value="/faces/newPaziente.jsp" />' role="button">Inserisci nuovo Paziente
						&raquo;</a>
				</p>
			</div>
		</div>		
		</f:view>
		<hr>
		<!-- Terzo gruppo di colonne -->
		<div class="row">
			<div class="col-md-4">
				<h2>Inserimento nuovo Medico</h2>
				<p>Inserisci un nuovo Medico nella clinica Heaven Hospital.</p>
				<p>
					<a class="btn btn-default" href='<c:url value="/faces/newMedico.jsp" />' role="button">Inserisci nuovo Medico
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				
			</div>
			<div class="col-md-4">
			<h2>Consulta Esami di un Medico</h2>
				<p>Visualizza l'elenco degli esami effettuati da un medico.</p>
				<p>
					<a class="btn btn-default" href='<c:url value="/faces/esamiMedico.jsp" />' role="button">Elenco Esami di un medico
						&raquo;</a>
				</p>
			</div>
		</div>		
		

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

