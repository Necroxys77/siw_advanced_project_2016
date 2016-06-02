<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Paziente</title>
</head>
<body>
	<f:view>
		<h2>Dettaglio</h2>
		<div>Nome: ${pazienteController.paziente.nome}</div>
		<div>Cognome: ${pazienteController.paziente.cognome}</div>
		<div>Email: ${pazienteController.paziente.email}</div>
		<div>Password: ${pazienteController.paziente.password}</div>
	</f:view>
</body>
</html>