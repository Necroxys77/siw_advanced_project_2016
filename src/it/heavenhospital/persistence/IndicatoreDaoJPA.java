package it.heavenhospital.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.heavenhospital.model.Indicatore;

public class IndicatoreDaoJPA implements IndicatoreDao {
	private EntityManager em;
	private EntityTransaction tx;
	
	public IndicatoreDaoJPA(EntityManager em) {
		this.em = em;
	}
		
	@Override
	public void save(Indicatore indicatore) {
		tx = em.getTransaction();
		tx.begin();
		em.persist(indicatore);
		tx.commit();
	}

	@Override
	public void delete(Indicatore indicatore) {
		tx = em.getTransaction();
		tx.begin();
		em.remove(indicatore);
		tx.commit();
	}

	@Override
	public void update(Indicatore indicatore) {
		tx = em.getTransaction();
		tx.begin();
		em.merge(indicatore);
		tx.commit();
	}

	@Override
	public List<Indicatore> findAll() {
		List<Indicatore> indicatori = em.createNamedQuery("allIndicatori").getResultList();
		return indicatori;
	}

	@Override
	public Indicatore findByPrimaryKey(Long id) {
		return em.find(Indicatore.class, id);
	}

}
