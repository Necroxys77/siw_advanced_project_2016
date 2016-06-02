package it.heavenhospital.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.heavenhospital.model.TipologiaEsame;

public class TipologiaEsameDaoJPA implements TipologiaEsameDao {
	private EntityManager em;
	
	public TipologiaEsameDaoJPA(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void save(TipologiaEsame tipologiaEsame) {
		em.persist(tipologiaEsame);
	}

	@Override
	public void delete(TipologiaEsame tipologiaEsame) {
		em.remove(tipologiaEsame);
	}

	@Override
	public void update(TipologiaEsame tipologiaEsame) {
		em.merge(tipologiaEsame);
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
	
	@Override
	public TipologiaEsame findByNome(String nome) {
		Query query = em.createQuery("SELECT t FROM TipologiaEsame t WHERE t.nome=?");
		query.setParameter(1, nome);
		return (TipologiaEsame) query.getSingleResult();
 	}
}
