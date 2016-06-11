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

<title>Heaven Hospital Project 2016</title>

<!-- Bootstrap core CSS -->
<link href="Static/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="Static/css/jumbotron.css" rel="stylesheet">

<!-- carousel -->
<link href="Static/css/carousel.css" rel="stylesheet">

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
				<!--  <a class="navbar-brand">Heaven-Hospital</a> -->
			</div>
			<div class="navbar-collapse collapse" aria-expanded="false"
				style="height: 1px;">

				<ul class="nav navbar-nav">
					<c:if test="${amministratoreController.amministratore.email != null}">


						<li class="active"><a href="admin-home.jsp">Benvenuto
								${amministratoreController.amministratore.nome}</a></li>
					</c:if>
					<li><a href="login.jsp">Login Amministratore</a></li>

				</ul>
			</div>

			<!--/.navbar-collapse -->
		</div>
	</nav>
	


	<!-- CAROUSEL -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide" src="Static/Imgsrc/doctors_1_plus.jpg"
					height="100" alt="First slide">
				<div class="container">
					<div class="carousel-caption">
						<h1 class="shadow_box">Personale altamente qualificato</h1>
						<p class="shadow_box">Ai primi posti nell'assistenza ai
							pazienti di tutte le eta', Heaven Hospital offre anche assistenza a domicilio</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide"
					src="Static/Imgsrc/laboratories_1_plus.jpg" alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1 class="shadow_box">Laboratori all'avanguardia</h1>
						<p class="shadow_box">I nuovi laboratori costruiti con le ultime tecnologie permettono
						al nostro personale di lavorare con maggiore effecienza e attenzione, offrendo al paziente
						il miglior servizio attualmente disponibile</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide" src="Static/Imgsrc/results_1_plus.jpg"
					alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1 class="shadow_box">Risultati in tempi rapidi</h1>
						<p class="shadow_box">Grazie al gran numero del nostro personale, ogni paziente non dovra' aspettare
						mesi prima di effettuare un esame. Inoltre, quest'ultimo verra' notificato via email una volta che i risultati dei suoi
						esami saranno disponibili
						</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- /.carousel -->


	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<h1>Heaven Hospital</h1>
			<p><i>Heaven Hospital</i> e' stata rinosciuta dalla regione Lazio come migliore clinica su territorio regionale, con 
			un'elevata soddisfazione da parte dei pazienti per la nostra professionalita' e competenza. Ai primi posti tra le migliori
			cliniche anche a livello nazionale.</p>
		</div>
	</div>
	
	
	<div class="container">
		<f:view>
		
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-15">
				<h2>Consulta Tipologie Esame</h2>
				<hr>
				<p><i>Heaven Hospital</i> offre molte tipologie di esami: dai semplici controlli di routine a quelli piu' complessi
				 e per tutte le tasche. Consulta la nostra offerta!</p>
				<p>
					<h:form>
						<h:commandButton action="#{tipologiaEsameController.listTipologieEsame}" 
							value="Elenco Tipologie Esame" type="submit"/>
					</h:form>
				</p>
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
	<!-- Carousel -->
	<script language="JavaScript" type="text/javascript">
		$(document).ready(function() {
			$('.carousel').carousel({
				interval : 3000
			})
		});
	</script>

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

