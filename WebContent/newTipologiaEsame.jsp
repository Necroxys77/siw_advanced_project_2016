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

<title>Inserimento Tipologia Esame</title>

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
		<h1>Inserimento nuova Tipologia Esame</h1>
		<br>
		<hr>
		<br>
	
	
		<!--  Inizio campi per la tipologia -->
		<f:view>
		<h:form>
			<fieldset class="form-group">
				<label for="nome">Nome: </label> <h:inputText value="#{tipologiaEsameController.nome}" 
                    								 styleClass="form-control"
                    								 required="true"
                   									requiredMessage="Il nome e' obbligatorio!"
                     								id="nome"/> <h:message for="nome" />
			</fieldset>
			<fieldset class="form-group">
				<label for="descrizione">Descrizione: </label> <h:inputTextarea value="#{tipologiaEsameController.descrizione}" 
                    								 	styleClass="form-control"
                    								 	required="false"
                    								 	cols="20"
                    								 	rows="5"
                     									id="descrizione"> 
                     									<f:validateLength maximum="2000"/>
                     									</h:inputTextarea>
                     									<h:message for="descrizione" />
			</fieldset>
			<fieldset class="form-group">
				<label for="costo">Costo(&euro;): </label> <h:inputText value="#{tipologiaEsameController.costo}" 
                    								 styleClass="form-control"
                    								 required="true"
                   									requiredMessage="Il costo e' obbligatorio!"
                   									converterMessage="Il costo deve essere un numero!"
                     								id="costo"/> <h:message for="costo" />
			</fieldset>
			<fieldset class="form-group">
				<label for="indicatore1">Indicatore 1: </label> <h:inputText value="#{tipologiaEsameController.indicatoriArray[0]}" 
                    								 styleClass="form-control"
                    								 required="false"
                   				                     id="indicatore1"/> <h:message for="indicatore1" />
			</fieldset>
			<fieldset class="form-group">
				<label for="indicatore2">Indicatore 2: </label> <h:inputText value="#{tipologiaEsameController.indicatoriArray[1]}" 
                    								 styleClass="form-control"
                    								 required="false"
                   				                     id="indicatore2"/> <h:message for="indicatore2" />
			</fieldset>
			<fieldset class="form-group">
				<label for="nomeprerequisito1">Nome Prerequisito 1: </label> <h:inputText value="#{tipologiaEsameController.nomiPrerequisiti[0]}" 
                    								 styleClass="form-control"
                    								 required="false"
                   				                     id="nomeprerequisito1"/> <h:message for="nomeprerequisito1" />
			</fieldset>
			<fieldset class="form-group">
				<label for="descrizioneprerequisito1">Descrizione Prerequisito 1: </label> <h:inputText value="#{tipologiaEsameController.descrizioniPrerequisiti[0]}" 
                    								 styleClass="form-control"
                    								 required="false"
                   				                     id="descrizioneprerequisito1"/> <h:message for="descrizioneprerequisito1" />
			</fieldset>
			<fieldset class="form-group">
				<label for="nomeprerequisito2">Nome Prerequisito 2: </label> <h:inputText value="#{tipologiaEsameController.nomiPrerequisiti[1]}" 
                    								 styleClass="form-control"
                    								 required="false"
                   				                     id="nomeprerequisito2"/> <h:message for="nomeprerequisito1" />
			</fieldset>
			<fieldset class="form-group">
				<label for="descrizioneprerequisito2">Descrizione Prerequisito 2: </label> <h:inputText value="#{tipologiaEsameController.descrizioniPrerequisiti[1]}" 
                    								 styleClass="form-control"
                    								 required="false"
                   				                     id="descrizioneprerequisito2"/> <h:message for="descrizioneprerequisito2" />
			</fieldset>		
			
			
			
			<div>
				<h:commandButton value="Inserisci"  action="#{tipologiaEsameController.createTipologiaEsame}"/>
			</div>
			<br> 
			<div> Non vuoi inserire una nuova <i>Tipologia Esame</i>? <a href='<c:url value="/faces/admin-home.jsp" />'>Torna indietro</a>!
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

