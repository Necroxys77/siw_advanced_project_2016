package it.heavenhospital.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.heavenhospital.model.Amministratore;

public class AmministratoreDaoJPA implements AmministratoreDao {
	public EntityManager em;
	//apro una transazione in ogni metodo Dao che prevede una modifica nella base di dati
	public EntityTransaction tx;
	
	//passo l'EntityManager al construttore della classe in modo tale che sia sempre lo stesso
	public AmministratoreDaoJPA(EntityManager em) {
		this. em = em;
	}
	
	
	@Override
	public void save(Amministratore amministratore) {
		tx = em.getTransaction();
		tx.begin();
		em.persist(amministratore);
		tx.commit();
	}

	@Override
	public void delete(Amministratore amministratore) {
		tx = em.getTransaction();
		tx.begin();
		em.remove(amministratore);
		tx.commit();
	}

	@Override
	public void update(Amministratore amministratore) {
		tx = em.getTransaction();
		tx.begin();
		em.merge(amministratore);
		tx.commit();
	}

	@Override
	public List<Amministratore> findAll() {
		List<Amministratore> amministratori = em.createNamedQuery("allAmministratori").getResultList();
		return amministratori;
	}

	@Override
	public Amministratore findByPrimaryKey(Long id) {
		return em.find(Amministratore.class, id);
	}
	
	@Override
	public Amministratore findByEmail(String email){
		Query query = em.createQuery("SELECT a FROM Amministratore a WHERE a.email=?");
		return (Amministratore)query.setParameter(1,email).getSingleResult();
	}
}
