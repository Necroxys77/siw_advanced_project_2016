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

<title>Elenco Tipologie Esame</title>

<!-- Bootstrap core CSS -->
<link href="Static/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="Static/css/jumbotron.css" rel="stylesheet">

<!-- personal css -->
<link href="Static/css/personal.css" rel="stylesheet">
</head>

<f:view>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target=".navbar-collapse">
				</button>
				<a class="navbar-brand" href="index.jsp">Heaven-Hospital</a>
			</div>
			<div class="navbar-collapse collapse" aria-expanded="false"
				style="height: 1px;">
				<ul class="nav navbar-nav">
					
					<li class="active"><a href='<c:url value="/faces/admin-home.jsp" />'>Hello ${amministratoreController.amministratore.email}</a>


				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>


	<!-- Main jumbotron for a primary marketing message or call to action -->

	<div class="container">


		
			<h1>Elenco Tipologie Esame</h1>
			<br>
			<hr>
			<br>
			
			<h:form>
			<table class= "table">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Descrizione</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tipologiaEsame" items="#{tipologiaEsameController.tipologieEsame}">
					<tr class ="info">
						<td>
						<h:commandLink action="#{tipologiaEsameController.findTipologiaEsame}" value="#{tipologiaEsame.nome}">
							<f:param name="id" value="#{tipologiaEsame.id}"/>
						</h:commandLink>
						</td>
						<td>${tipologiaEsame.descrizione}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			</h:form>
			<br>
			<br>
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

