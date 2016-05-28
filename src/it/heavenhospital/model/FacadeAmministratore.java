package it.heavenhospital.model;

import javax.persistence.EntityManager;

import it.heavenhospital.persistence.AmministratoreDaoJPA;
import it.heavenhospital.persistence.EsameDaoJPA;
import it.heavenhospital.persistence.MedicoDaoJPA;
import it.heavenhospital.persistence.TipologiaEsameDaoJPA;

public class FacadeAmministratore {

	public FacadeAmministratore(){}

	/* metodo chiamato quando si vuole inserire un amministratore. Questo verr� chiamato dopo che il Controller MVC verificher� i dati della richiesta Http */
	/* in particolare, questo metodo render� persistente l'amministratore */
	public void inserisciAmministratore(Amministratore amministratore, EntityManager em){ 
		 
		AmministratoreDaoJPA amministratoreDao = new AmministratoreDaoJPA(em);

		amministratoreDao.save(amministratore);
	}
	
	/* Per il caso d'uso uc4, la resposabilit� di inserire una tipologia d'esame
	 * � stata assegnata all'amministratore.
	 */
	public void inserisciTipologiaEsame(TipologiaEsame tipologia, EntityManager em){ 
		 
		TipologiaEsameDaoJPA tipologiaDao = new TipologiaEsameDaoJPA(em);

		tipologiaDao.save(tipologia);
	}
	
	/* Per il caso d'uso uc2, la resposabilit� di inserire un esame
	 * � stata assegnata all'amministratore.
	 */
	public void inserisciEsame(Esame esame, EntityManager em){ 
		 
		EsameDaoJPA esameDao = new EsameDaoJPA(em);

		esameDao.save(esame);
	}
	
	/* Anche se non esiste un caso d'uso "inserimento dati del Medico",
	 * per coerenza con quanto visto sinora nei precedenti casi d'uso,
	 * pu� essere opportuno assegnare tale responsabilit� all'amministratore.
	 */
	public void inserisciMedico(Medico medico, EntityManager em){ 
		 
		MedicoDaoJPA medicoDao = new MedicoDaoJPA(em);

		medicoDao.save(medico);
	}
	
}
