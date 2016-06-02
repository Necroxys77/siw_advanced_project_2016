package it.heavenhospital.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.heavenhospital.model.Paziente;

public class PazienteDaoJPA implements PazienteDao {
	private EntityManager em;

	public PazienteDaoJPA(EntityManager em) {
		this.em = em;
	}

	//ci pensa il contenitore a gestire le connessioni
	@Override
	public void save(Paziente paziente) {
		em.persist(paziente);
	}

	@Override
	public void delete(Paziente paziente) {
		em.remove(paziente);
	}
	
	public void delete(Long id){
		Paziente paziente = em.find(Paziente.class, id);
		this.delete(paziente);
	}

	@Override
	public void update(Paziente paziente) {
		em.merge(paziente);
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

	@Override
	public Paziente findByEmail(String email) {
		Query query = em.createQuery("SELECT p FROM Paziente p WHERE p.email=?");
		return (Paziente)query.setParameter(1, email).getSingleResult();
	}
}

