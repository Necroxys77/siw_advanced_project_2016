package it.heavenhospital.persistence;

import java.util.List;

import it.heavenhospital.model.Amministratore;

public interface AmministratoreDao {
	
	public void save(Amministratore amministratore); //Create
	public void delete(Amministratore amministratore); //Delete
	public void update(Amministratore amministratore); //Update
	public List<Amministratore> findAll(); 
	public Amministratore findByPrimaryKey(Long id); //Retrieve
}
