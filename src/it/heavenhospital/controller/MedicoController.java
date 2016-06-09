package it.heavenhospital.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.heavenhospital.model.AmministratoreFacade;
import it.heavenhospital.model.Medico;

@ManagedBean
public class MedicoController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String nome;
	private String cognome;
	private String specializzazione;
	private String password;
	private Medico medico;
	private List<Medico> medici;
	
	@EJB
	private AmministratoreFacade amministratoreFacade;
	
	@PostConstruct
	public void elencoMedici(){
		this.medici = this.amministratoreFacade.getAllMedici();
	}
	
	
	public String createMedico(){
		String nextPage = "successNewMedico";
		try{
			this.medico = amministratoreFacade.createMedico(nome, cognome, specializzazione, password); 
		} catch (EJBTransactionRolledbackException e){ // catturo l'eccezione sollevata in cui il DBMS ha già un paziente con la stessa email
			nextPage = "errorNewMedico";
			this.medico = new Medico(password, nome, cognome, specializzazione); //creo ugualmente il medico in modo tale da richiamarne i dati nella pagina di errore
		}
		return nextPage;
	}
	
	//metodi setters e getters
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSpecializzazione() {
		return specializzazione;
	}
	
	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}
	
	public Medico getMedico() {
		return medico;
	}
	
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	public List<Medico> getMedici() {
		return medici;
	}
	
	public void setMedici(List<Medico> medici) {
		this.medici = medici;
	}
	
}
