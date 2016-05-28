package it.heavenhospital.model;

import javax.persistence.EntityManager;

import it.heavenhospital.persistence.AmministratoreDaoJPA;
import it.heavenhospital.persistence.EsameDaoJPA;
import it.heavenhospital.persistence.MedicoDaoJPA;
import it.heavenhospital.persistence.TipologiaEsameDaoJPA;

public class FacadeAmministratore {

	public FacadeAmministratore(){}

	/* metodo chiamato quando si vuole inserire un amministratore. Questo verrà chiamato dopo che il Controller MVC verificherà i dati della richiesta Http */
	/* in particolare, questo metodo renderà persistente l'amministratore */
	public void inserisciAmministratore(Amministratore amministratore, EntityManager em){ 
		 
		AmministratoreDaoJPA amministratoreDao = new AmministratoreDaoJPA(em);

		amministratoreDao.save(amministratore);
	}
	
	/* Per il caso d'uso uc4, la resposabilità di inserire una tipologia d'esame
	 * è stata assegnata all'amministratore.
	 */
	public void inserisciTipologiaEsame(TipologiaEsame tipologia, EntityManager em){ 
		 
		TipologiaEsameDaoJPA tipologiaDao = new TipologiaEsameDaoJPA(em);

		tipologiaDao.save(tipologia);
	}
	
	/* Per il caso d'uso uc2, la resposabilità di inserire un esame
	 * è stata assegnata all'amministratore.
	 */
	public void inserisciEsame(Esame esame, EntityManager em){ 
		 
		EsameDaoJPA esameDao = new EsameDaoJPA(em);

		esameDao.save(esame);
	}
	
	/* Anche se non esiste un caso d'uso "inserimento dati del Medico",
	 * per coerenza con quanto visto sinora nei precedenti casi d'uso,
	 * può essere opportuno assegnare tale responsabilità all'amministratore.
	 */
	public void inserisciMedico(Medico medico, EntityManager em){ 
		 
		MedicoDaoJPA medicoDao = new MedicoDaoJPA(em);

		medicoDao.save(medico);
	}
	
}
