package it.heavenhospital.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.heavenhospital.model.Prerequisito;

public class PrerequisitoDaoJPA implements PrerequisitoDao {
	private EntityManager em;
	private EntityTransaction tx;
	
	public PrerequisitoDaoJPA(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void save(Prerequisito prerequisito) {
		tx = em.getTransaction();
		tx.begin();
		em.persist(prerequisito);
		tx.commit();
	}

	@Override
	public void delete(Prerequisito prerequisito) {
		tx = em.getTransaction();
		tx.begin();
		em.remove(prerequisito);
		tx.commit();
	}

	@Override
	public void update(Prerequisito prerequisito) {
		tx = em.getTransaction();
		tx.begin();
		em.merge(prerequisito);
		tx.commit();
	}

	@Override
	public List<Prerequisito> findAll() {
		List<Prerequisito> prerequisiti = em.createNamedQuery("allPrerequisiti").getResultList();
		return prerequisiti;
	}

	@Override
	public Prerequisito findByPrimaryKey(String nome) {
		return em.find(Prerequisito.class, nome);
	}

}
