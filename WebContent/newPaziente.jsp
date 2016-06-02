<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Paziente</title>
</head>
<body>
<f:view>
<h:form>
    <div>Nome: <h:inputText value="#{pazienteController.nome}" 
                     required="true"
                     requiredMessage="Il nome e' obbligatorio"
                     id="nome"/> <h:message for="nome" />
	</div>
    <div>Cognome: <h:inputText value="#{pazienteController.cognome}" 
                     required="true"
                     requiredMessage="Il cognome e' obbligatorio"
                     id="cognome"/> <h:message for="cognome" />
	</div>
    <div>Email: <h:inputText value="#{pazienteController.email}" 
                     required="true"
                     requiredMessage="L'email e' obbligatoria"
                     id="email"/> <h:message for="email" />
	</div>
    <div>Password: <h:inputText value="#{pazienteController.password}" 
    				required="true"
    				requiredMessage="La password e' obbligatoria" 
    				id="password"/> <h:message for="password" />               
	</div>
	<div>
		<h:commandButton value="Submit"  action="#{pazienteController.createPaziente}"/>
	</div>
</h:form>
</f:view>
</body>
</html>