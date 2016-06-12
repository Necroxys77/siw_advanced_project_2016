package it.heavenhospital.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.heavenhospital.model.Paziente;
import it.heavenhospital.model.PazienteFacade;

@ManagedBean
@SessionScoped
public class PazienteController {
	
	//@ManagedProperty(value="#{param.id}")
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private Paziente paziente;
	private List<Paziente> pazienti;
	private String loginErr;
	
	
	@EJB
	private PazienteFacade pazienteFacade;
	
	
	@PostConstruct
	public void elencoPazienti(){
		this.pazienti = this.pazienteFacade.getAllPazienti();
	}
	
	public String createPaziente(){
		String nextPage = "successNewPaziente";
		try{
			this.paziente = pazienteFacade.createPaziente(nome, cognome, email, password);
		} catch (EJBTransactionRolledbackException e){ 
			nextPage = "errorNewPaziente";
			this.paziente = new Paziente(email, password, nome, cognome); 
		}
		return nextPage;
	}
	
	public String validate(){
		try {
			this.paziente = pazienteFacade.validate(email, password);
		}catch (EJBException e) {
			this.loginErr = "Email o password errati";
			return "loginPaziente";
		} 
		return "paziente-home";
	}
	
	
	public String listPazienti(){
		this.pazienti = pazienteFacade.getAllPazienti();
		return "pazienti";
	}
	
	public String findPaziente(){
		this.paziente = pazienteFacade.getPaziente(id);
		return "paziente";
	}
	
	//metodi getter e setter 
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
	
	public String getLoginErr() {
		return loginErr;
	}
	
	public void setLoginErr(String loginErr) {
		this.loginErr = loginErr;
	}
	
}
