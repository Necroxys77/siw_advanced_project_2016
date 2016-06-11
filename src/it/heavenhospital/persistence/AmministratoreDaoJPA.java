package it.heavenhospital.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.heavenhospital.model.Amministratore;

public class AmministratoreDaoJPA implements AmministratoreDao {
	public EntityManager em;
	
	//passo l'EntityManager al construttore della classe in modo tale che sia sempre lo stesso
	public AmministratoreDaoJPA(EntityManager em) {
		this. em = em;
	}
	
	
	@Override
	public void save(Amministratore amministratore) {
		em.persist(amministratore);
	}

	@Override
	public void delete(Amministratore amministratore) {
		em.remove(amministratore);
	}

	@Override
	public void update(Amministratore amministratore) {
		em.merge(amministratore);
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
	
	@Override
	public Amministratore findAdmin(String email, String password){
		Query query = em.createQuery("SELECT a FROM Amministratore a WHERE a.email='"+ email + "' AND a.password='"+password+"'");
		//Query query = em.createQuery("SELECT a FROM Amministratore a WHERE a.email=? AND a.password=?");
		//query.setParameter(1,email);
		//query.setParameter(2,password);
		Amministratore amministratore = (Amministratore)query.getSingleResult();
		return amministratore;
	}
}
