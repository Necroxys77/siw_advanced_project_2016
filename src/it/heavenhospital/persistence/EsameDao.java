package it.heavenhospital.persistence;

import java.util.List;

import it.heavenhospital.model.Esame;

public interface EsameDao {
	
	public void save(Esame esame); //Create
	public void delete(Esame esame); //Delete
	public void update(Esame esame); //Update
	public List<Esame> findAll(); 
	public Esame findByPrimaryKey(Long id); //Retrieve
}
