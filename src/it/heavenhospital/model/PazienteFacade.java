package it.heavenhospital.model;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.heavenhospital.persistence.PazienteDaoJPA;

/**
 * I metodi di questa classe richiamano quelli della corrispondente classe Dao
 * in modo tale da essere inconsapevole dell'implementazione SQL per le operazioni CRUD
 * 
 * @author Matteo
 *
 */

@Stateless
public class PazienteFacade {
	
	@PersistenceContext(unitName = "heavenhospital-unit")
	private EntityManager em;
	
	// chiedo alla classe PazienteDao di occuparsi dell'invocazione dei metodi dell'em e di eventuali istruzioni SQL, creando un livello d'indirezione
	public Paziente createPaziente(String nome, String cognome, String email, String password){
		PazienteDaoJPA pazienteDao = new PazienteDaoJPA(em);
		Paziente paziente = new Paziente(email, password, nome, cognome);
		pazienteDao.save(paziente);
		return paziente;
	}
	
	public void deletePaziente(Paziente paziente){
		PazienteDaoJPA pazienteDao = new PazienteDaoJPA(em);
		pazienteDao.delete(paziente);
	}
	
	public void deletePaziente(Long id){
		PazienteDaoJPA pazienteDao = new PazienteDaoJPA(em);
		pazienteDao.delete(id);
	}
	
	public void updatePaziente(Paziente paziente){
		PazienteDaoJPA pazienteDao = new PazienteDaoJPA(em);
		pazienteDao.update(paziente);
	}
	
	public Paziente getPaziente(Long id){
		PazienteDaoJPA pazienteDao = new PazienteDaoJPA(em);
		return pazienteDao.findByPrimaryKey(id);
	}
	
	public Paziente getPaziente(String email){
		PazienteDaoJPA pazienteDao = new PazienteDaoJPA(em);
		return pazienteDao.findByEmail(email);
	}
	
	public List<Paziente> getAllPazienti(){
		PazienteDaoJPA pazienteDao = new PazienteDaoJPA(em);
		List<Paziente> pazienti = pazienteDao.findAll();
		return pazienti;
	}
	
}
