package it.heavenhospital.persistence;

import java.util.List;

import it.heavenhospital.model.TipologiaEsame;

public interface TipologiaEsameDao {
	
	public void save(TipologiaEsame tipologiaEsame); //Create
	public void delete(TipologiaEsame tipologiaEsame); //Delete
	public void update(TipologiaEsame tipologiaEsame); //Update
	public List<TipologiaEsame> findAll(); 
	public TipologiaEsame findByPrimaryKey(Long id); //Retrieve
}
