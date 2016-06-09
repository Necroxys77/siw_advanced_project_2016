package it.heavenhospital.persistence;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import it.heavenhospital.model.Esame;
import it.heavenhospital.model.Indicatore;

public class EsameDaoJPA implements EsameDao {
	private EntityManager em;

	public EsameDaoJPA(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(Esame esame) {
		em.persist(esame);
	}

	@Override
	public void delete(Esame esame) {
		em.remove(esame);
	}

	@Override
	public void update(Esame esame) {
		em.merge(esame);
	}
	
	public List<Esame> findAllByMedicoId(Long medicoId){
		List<Esame> esami = null;
		Query query = em.createQuery("SELECT e FROM Esame e WHERE e.medico.id= :medicoId");
		try{
			query.setParameter("medicoId", medicoId);
			esami = query.getResultList();
		} catch(NoResultException e){}
		return esami;
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
	