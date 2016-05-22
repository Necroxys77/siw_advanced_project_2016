package it.heavenhospital.persistence;

import java.util.List;

import it.heavenhospital.model.Indicatore;

public interface IndicatoreDao {
	
	public void save(Indicatore indicatore); //Create
	public void delete(Indicatore indicatore); //Delete
	public void update(Indicatore indicatore); //Update
	public List<Indicatore> findAll(); 
	public Indicatore findByPrimaryKey(Long id); //Retrieve
}
