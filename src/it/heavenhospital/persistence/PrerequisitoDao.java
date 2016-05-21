package it.heavenhospital.persistence;

import java.util.List;

import it.heavenhospital.model.Prerequisito;

public interface PrerequisitoDao {
	
	public void save(Prerequisito prerequisito); //Create
	public void delete(Prerequisito prerequisito); //Delete
	public void update(Prerequisito prerequisito); //Update
	public List<Prerequisito> findAll(); 
	public Prerequisito findByPrimaryKey(String nome); //Retrieve
}
