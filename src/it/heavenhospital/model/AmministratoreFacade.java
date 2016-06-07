package it.heavenhospital.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.heavenhospital.persistence.AmministratoreDaoJPA;
import it.heavenhospital.persistence.TipologiaEsameDaoJPA;

@Stateless
public class AmministratoreFacade {
	
	@PersistenceContext(unitName = "heavenhospital-unit")
	private EntityManager em;
	
	//attribuire alla FacadeAmministratore il compito di gestire qualsiasi cosa relativa all'amministratore?
	
	//metodi inerenti alla gestione delle Tipologie
	
	public TipologiaEsame createTipologiaEsame(String nome, String descrizione, Integer costo){
		TipologiaEsameDaoJPA tipologiaDao = new TipologiaEsameDaoJPA(em);
		TipologiaEsame tipologia = new TipologiaEsame(nome, descrizione, costo);
		tipologiaDao.save(tipologia);
		return tipologia;
	}
	
	public TipologiaEsame getTipologiaEsame(Long id){
		TipologiaEsameDaoJPA tipologiaDao = new TipologiaEsameDaoJPA(em);
		TipologiaEsame tipologia = tipologiaDao.findByPrimaryKey(id);
		return tipologia;
	}
	
	public List<TipologiaEsame> getAllTipologieEsame() {
		TipologiaEsameDaoJPA tipologiaDao = new TipologiaEsameDaoJPA(em);
		List<TipologiaEsame> tipologie = tipologiaDao.findAll();
		return tipologie;
	}
	
	//metodi inerenti alla gestione dell'amministratore
	public Amministratore createAmministratore(String nome, String cognome, String email, String password){
		AmministratoreDaoJPA amministratoreDao = new AmministratoreDaoJPA(em);
		Amministratore amministratore =new Amministratore(email, password, nome, cognome);
		amministratoreDao.save(amministratore);
		return amministratore;
	}
}
