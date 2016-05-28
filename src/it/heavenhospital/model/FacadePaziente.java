package it.heavenhospital.model;

import javax.persistence.EntityManager;


import it.heavenhospital.persistence.PazienteDaoJPA;

public class FacadePaziente {

	public FacadePaziente(){}

	/* metodo chiamato quando si vuole inserire un paziente. Questo verr� chiamato dopo che il Controller MVC verificher� i dati della richiesta Http */
	/* in particolare, questo metodo render� persistente il paziente */
	public void inserisciStudente(Paziente paziente,EntityManager em){ 
		 
		PazienteDaoJPA pazienteDao = new PazienteDaoJPA(em);

		pazienteDao.save(paziente);
	}

}
