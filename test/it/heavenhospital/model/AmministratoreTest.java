package it.heavenhospital.model;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AmministratoreTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	private Amministratore amministratore = new Amministratore("prova@gmail.com","Prova123","Marco","Bianchi");

	
	@BeforeClass
	public static void initEntityManager() throws Exception {
		emf = Persistence.createEntityManagerFactory("heavenhospital-unit");
		em = emf.createEntityManager();
	}
	
	@AfterClass
	public static void closeEntityManager() throws Exception {
		if (em!=null) em.close();
		if (emf!=null) emf.close();
	}
	
	@Before
	public void initTransaction(){
		tx = em.getTransaction();
	}
	
	@Test
	public void shouldCreateAnAmministratore() throws Exception{
		//rendo persistente l'oggetto nel DBMS
		tx.begin();
		em.persist(amministratore);
		tx.commit();
		//verifico
		assertNotNull("ID should not null",amministratore.getId());
		List<Amministratore> amministratori = em.createNamedQuery("allAmministratori").getResultList();
		assertEquals(1,amministratori.size());
	}
	
	// verificare che non si aggiungano oggetti con la stessa email?
}
