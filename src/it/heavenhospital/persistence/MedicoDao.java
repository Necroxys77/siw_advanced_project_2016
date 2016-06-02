package it.heavenhospital.persistence;

import java.util.List;

import it.heavenhospital.model.Medico;


public interface MedicoDao {
	
	public void save(Medico medico); //Create
	public void delete(Medico medico); //Delete
	public void update(Medico medico); //Update
	public List<Medico> findAll(); 
	public Medico findByPrimaryKey(Long id); //Retrieve
	public Medico findByNomeCognome(String nome, String cognome); //Retrieve from name and surname
}
