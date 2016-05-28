package it.heavenhospital.model;

import javax.persistence.EntityManager;


import it.heavenhospital.persistence.PazienteDaoJPA;

public class FacadePaziente {

	public FacadePaziente(){}

	/* metodo chiamato quando si vuole inserire un paziente. Questo verrà chiamato dopo che il Controller MVC verificherà i dati della richiesta Http */
	/* in particolare, questo metodo renderà persistente il paziente */
	public void inserisciStudente(Paziente paziente,EntityManager em){ 
		 
		PazienteDaoJPA pazienteDao = new PazienteDaoJPA(em);

		pazienteDao.save(paziente);
	}

}
