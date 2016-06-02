package it.heavenhospital.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.heavenhospital.model.Paziente;
import it.heavenhospital.model.PazienteFacade;

@ManagedBean
public class PazienteController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private Paziente paziente;
	private List<Paziente> pazienti;
	
	@EJB
	private PazienteFacade pazienteFacade;
	
	//i metodi del controller hanno come risultato il nome della prossima pagina da visualizzare
	public String createPaziente(){
		this.paziente = pazienteFacade.createPaziente(nome, cognome, email, password);
		return "paziente";
	}
	
	public String listPazienti(){
		this.pazienti = pazienteFacade.getAllPazienti();
		return "pazienti";
	}
	
	public String findPaziente(){
		this.paziente = pazienteFacade.getPaziente(id);
		return "paziente";
	}
	
	//metodi getter e setter necessari al controller
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Paziente getPaziente() {
		return paziente;
	}
	
	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}
	
	public List<Paziente> getPazienti() {
		return pazienti;
	}
	
	public void setPazienti(List<Paziente> pazienti) {
		this.pazienti = pazienti;
	}
	
}