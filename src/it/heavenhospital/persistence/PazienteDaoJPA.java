package it.heavenhospital.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.heavenhospital.model.Paziente;

public class PazienteDaoJPA implements PazienteDao {
	private EntityManager em;
	private EntityTransaction tx;
	
	public PazienteDaoJPA(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void save(Paziente paziente) {
		tx = em.getTransaction();
		tx.begin();
		em.persist(paziente);
		tx.commit();
	}

	@Override
	public void delete(Paziente paziente) {
		tx = em.getTransaction();
		tx.begin();
		em.remove(paziente);
		tx.commit();
	}

	@Override
	public void update(Paziente paziente) {
		tx = em.getTransaction();
		tx.begin();
		em.merge(paziente);
		tx.commit();
	}

	@Override
	public List<Paziente> findAll() {
		List<Paziente> pazienti = em.createNamedQuery("allPazienti").getResultList();
		return pazienti;
	}

	@Override
	public Paziente findByPrimaryKey(Long id) {
		return em.find(Paziente.class, id);
	}

}
