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

<title>Inserimento Esame</title>

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
						<li class="active"><a href="admin-home.jsp">Benvenuto
								${amministratoreController.amministratore.nome}</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
		</div>
	</nav>

	<!-- Main jumbotron for a primary marketing message or call to action -->

		<div class="container">
		<h1>Inserimento nuovo Esame</h1>
		<br>
		<hr>
		<br>
	
	
		<!--  Inizio campi per la tipologia -->
		<f:view>
		<h:form>
			<fieldset class="form-group">
				<label for="dataDiEsecuzione">Data Esame: </label> <h:inputText value="#{esameController.dataDiEsecuzione}" 
                    								 styleClass="form-control"
                    								 required="true"
                   									requiredMessage="La data dell'esame e' obbligatoria"
                     								id="dataDiEsecuzione">
                     										<f:convertDateTime pattern="dd-MM-yyyy"/>
                     								</h:inputText>
                     								 <h:message for="dataDiPrenotazione" />
			</fieldset>
			<fieldset class="form-group">
				<label for="idmedico">Medico: </label><h:selectOneMenu value="#{esameController.idmedico}">
														<c:forEach var="medico" items="#{medicoController.medici}">
															<f:selectItem itemValue="#{medico.id}" itemLabel="#{medico.nome} #{medico.cognome}" />
														</c:forEach>
													</h:selectOneMenu>
			<br />
			</fieldset>
			<fieldset class="form-group">
				<label for="idtipologia">Tipologia: </label><h:selectOneMenu value="#{esameController.idtipologia}">
														<c:forEach var="tipologia" items="#{tipologiaEsameController.tipologieEsame}">
															<f:selectItem itemValue="#{tipologia.id}" itemLabel="#{tipologia.nome}" />
														</c:forEach>
													</h:selectOneMenu>
			<br />
			</fieldset>
			<fieldset class="form-group">
				<label for="idpaziente">Paziente: </label><h:selectOneMenu value="#{esameController.idpaziente}">
														<c:forEach var="paziente" items="#{pazienteController.pazienti}">
															<f:selectItem itemValue="#{paziente.id}" itemLabel="#{paziente.nome} #{paziente.cognome}" />
														</c:forEach>
													</h:selectOneMenu>
			<br />
			</fieldset>
			
			
			
			
			<div>
				<h:commandButton value="Inserisci"  action="#{esameController.createEsame}"/>
			</div>
			<br> 
			<div> Non vuoi inserire un nuovo <i>Esame</i>? <a href='<c:url value="/faces/admin-home.jsp" />'>Torna indietro</a>!
			</div>
			
		</h:form>
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

