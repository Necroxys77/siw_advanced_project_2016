package it.heavenhospital.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.heavenhospital.model.TipologiaEsame;

public class TipologiaEsameDaoJPA implements TipologiaEsameDao {
	private EntityManager em;
	private EntityTransaction tx;
	
	public TipologiaEsameDaoJPA(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void save(TipologiaEsame tipologiaEsame) {
		tx = em.getTransaction();
		tx.begin();
		em.persist(tipologiaEsame);
		tx.commit();
	}

	@Override
	public void delete(TipologiaEsame tipologiaEsame) {
		tx = em.getTransaction();
		tx.begin();
		em.remove(tipologiaEsame);
		tx.commit();
	}

	@Override
	public void update(TipologiaEsame tipologiaEsame) {
		tx = em.getTransaction();
		tx.begin();
		em.merge(tipologiaEsame);
		tx.commit();
	}

	@Override
	public List<TipologiaEsame> findAll() {
		List<TipologiaEsame> tipologieEsami = em.createQuery("SELECT t FROM TipologiaEsame t").getResultList();
		return tipologieEsami;
	}

	@Override
	public TipologiaEsame findByPrimaryKey(Long id) {
		return em.find(TipologiaEsame.class, id);
	}

}
