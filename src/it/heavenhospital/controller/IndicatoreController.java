package it.heavenhospital.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.heavenhospital.model.AmministratoreFacade;
import it.heavenhospital.model.Indicatore;

@ManagedBean
public class IndicatoreController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String nome;
	private Indicatore indicatore;
	private List<Indicatore> indicatori;

	@EJB
	private AmministratoreFacade amministratoreFacade;

	// questo metodo viene invocato appena si chiama l'indicatore Controller. In questo modo, carico direttamente tutti gli indicatori dal 
	// database per interrogarli
	@PostConstruct
	public void elencoIndicatori(){
		this.indicatori = amministratoreFacade.getAllIndicatori();
	}
	
	
	public String createIndicatore(){
		String nextPage = "successNewIndicatore";
		try{
			this.indicatore = amministratoreFacade.createIndicatore(nome);
		} catch (EJBTransactionRolledbackException e){
			nextPage = "errorNewIndicatore";
			this.indicatore = new Indicatore(nome);
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
	
	public Indicatore getIndicatore() {
		return indicatore;
	}
	
	public void setIndicatore(Indicatore indicatore) {
		this.indicatore = indicatore;
	}
	
	public List<Indicatore> getIndicatori() {
		return indicatori;
	}
	
	public void setIndicatori(List<Indicatore> indicatori) {
		this.indicatori = indicatori;
	}
}

