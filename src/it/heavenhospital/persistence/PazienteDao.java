package it.heavenhospital.persistence;

import java.util.List;

import it.heavenhospital.model.Paziente;

public interface PazienteDao {
	
	public void save(Paziente paziente); //Create
	public void delete(Paziente paziente); //Delete
	public void update(Paziente paziente); //Update
	public List<Paziente> findAll(); 
	public Paziente findByPrimaryKey(Long id); //Retrieve
	public Paziente findByEmail(String email); //Retrieve by email
	public Paziente findPaziente(String email,String password); //Retrieve by email and password
}
