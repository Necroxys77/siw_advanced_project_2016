package it.heavenhospital.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.heavenhospital.model.Medico;

public class MedicoDaoJPA implements MedicoDao {
	private EntityManager em;
	private EntityTransaction tx;

	public MedicoDaoJPA(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(Medico medico) {
		tx = em.getTransaction();
		tx.begin();
		em.persist(medico);
		tx.commit();
	}

	@Override
	public void delete(Medico medico) {
		tx = em.getTransaction();
		tx.begin();
		em.remove(medico);
		tx.commit();
	}

	@Override
	public void update(Medico medico) {
		tx = em.getTransaction();
		tx.begin();
		em.merge(medico);
		tx.begin();
	}

	@Override
	public List<Medico> findAll() {
		List<Medico> medici = em.createNamedQuery("allMedici").getResultList();
		return medici;
	}

	@Override
	public Medico findByPrimaryKey(Long id) {
		return em.find(Medico.class, id);
	}

	@Override
	public Medico findByNomeCognome(String nome, String cognome) {
		Query query = em.createQuery("SELECT m FROM Medico m WHERE m.nome=? AND m.cognome=?");
		query.setParameter(1, nome);
		query.setParameter(2, cognome);
		return (Medico) query.getSingleResult();
 	}
}
