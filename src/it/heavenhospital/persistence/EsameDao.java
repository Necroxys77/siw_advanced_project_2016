package it.heavenhospital.persistence;

import java.util.List;
import java.util.Map;

import it.heavenhospital.model.Esame;
import it.heavenhospital.model.Indicatore;

public interface EsameDao {
	
	public void save(Esame esame); //Create
	public void delete(Esame esame); //Delete
	public void update(Esame esame); //Update
	public List<Esame> findAll(); 
	public Esame findByPrimaryKey(Long id); //Retrieve
	public Map<Indicatore,String> findRisultatiEsame(Long id); //Retrieve dei risultati associati all'esame
}
