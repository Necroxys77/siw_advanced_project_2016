package it.heavenhospital.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.heavenhospital.model.Amministratore;
import it.heavenhospital.model.AmministratoreFacade;

@ManagedBean
public class AmministratoreController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private Amministratore amministratore;
	private List<Amministratore> amministratori;
	
	@EJB
	private AmministratoreFacade amministratoreFacade;
	
	public String createAmministratore(){
		String nextPage = "successNewAmministratore";
		try{
			this.amministratore = amministratoreFacade.createAmministratore(nome, cognome, email, password); 
		} catch (EJBTransactionRolledbackException e){ // catturo l'eccezione sollevata in cui il DBMS ha già un paziente con la stessa email
			nextPage = "errorNewAmministratore";
			this.amministratore = new Amministratore(email, password, nome, cognome); //creo ugualmente il paziente in modo tale da richiamarne i dati nella pagina di errore
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
	
	public Amministratore getAmministratore() {
		return amministratore;
	}
	
	public void setAmministratore(Amministratore amministratore) {
		this.amministratore = amministratore;
	}
	
	public List<Amministratore> getAmministratori() {
		return amministratori;
	}
	
	public void setAmministratori(List<Amministratore> amministratori) {
		this.amministratori = amministratori;
	}

}
