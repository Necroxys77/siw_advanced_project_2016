package it.heavenhospital.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

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
	

}
