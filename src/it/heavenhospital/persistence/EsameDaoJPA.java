package it.heavenhospital.persistence;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.heavenhospital.model.Esame;
import it.heavenhospital.model.Indicatore;

public class EsameDaoJPA implements EsameDao {
	private EntityManager em;
	private EntityTransaction tx;

	public EsameDaoJPA(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(Esame esame) {
		tx = em.getTransaction();
		tx.begin();
		em.persist(esame);
		tx.commit();
	}

	@Override
	public void delete(Esame esame) {
		tx = em.getTransaction();
		tx.begin();
		em.remove(esame);
		tx.commit();
	}

	@Override
	public void update(Esame esame) {
		tx = em.getTransaction();
		tx.begin();
		em.merge(esame);
		tx.commit();
	}

	@Override
	public List<Esame> findAll() {
		List<Esame> esami = em.createNamedQuery("allEsami").getResultList();
		return esami;
	}

	@Override
	public Esame findByPrimaryKey(Long id) {
		return em.find(Esame.class, id);
	}

	@Override
	public Map<Indicatore, String> findRisultatiEsame(Long id) {
		Esame esame = this.findByPrimaryKey(id);
		return esame.getRisultati();
	}
}
	