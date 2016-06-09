package it.heavenhospital.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.heavenhospital.model.Indicatore;
import it.heavenhospital.model.TipologiaEsame;

public class IndicatoreDaoJPA implements IndicatoreDao {
	private EntityManager em;
	
	public IndicatoreDaoJPA(EntityManager em) {
		this.em = em;
	}
		
	@Override
	public void save(Indicatore indicatore) {
		em.persist(indicatore);
	}

	@Override
	public void delete(Indicatore indicatore) {
		em.remove(indicatore);
	}

	@Override
	public void update(Indicatore indicatore) {
		em.merge(indicatore);
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
	
	@Override
	public Indicatore findByNome(String nome){
		Query query = em.createQuery("SELECT i FROM Indicatore i WHERE i.nome=?");
		query.setParameter(1, nome);
		return (Indicatore) query.getSingleResult();
	}

}
