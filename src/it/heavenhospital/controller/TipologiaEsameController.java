package it.heavenhospital.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.heavenhospital.model.AmministratoreFacade;
import it.heavenhospital.model.TipologiaEsame;

@ManagedBean
public class TipologiaEsameController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String nome;
	private String descrizione;
	private Integer costo;
	private TipologiaEsame tipologiaEsame;
	private List<TipologiaEsame> tipologieEsame;
	
	@EJB
	private AmministratoreFacade amministratoreFacade;
	
	public String createTipologiaEsame(){
		String nextPage = "successNewTipologiaEsame";
		try{
			this.tipologiaEsame = amministratoreFacade.createTipologiaEsame(nome, descrizione, costo);
		} catch (EJBTransactionRolledbackException e){ //cattura l'eccezione sollevata nel caso in cui l'oggetto è già presente nel DBMS
			nextPage = "errorNewTipologiaEsame";
			this.tipologiaEsame = new TipologiaEsame(nome, descrizione, costo); // ??? in modo tale che se non riesco a creare l'oggetto, lo posso 
																				// richiamare nella pagina d'errore
		}
		return nextPage;
	}
	
	public String findTipologiaEsame() {
		this.tipologiaEsame = amministratoreFacade.getTipologiaEsame(id);
		return "dettaglioTipologiaEsame";
	}
	
	public String findTipologiaEsame(Long id) {
		this.tipologiaEsame = amministratoreFacade.getTipologiaEsame(id);
		return "dettaglioTipologiaEsame";
	}
	
	public String listTipologieEsame(){
		this.tipologieEsame = amministratoreFacade.getAllTipologieEsame();
		return "elencoTipologieEsame";
	}
	
	
	//metodi getters e setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getCosto() {
		return costo;
	}
	
	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}
	
	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}
	
	public List<TipologiaEsame> getTipologieEsame() {
		return tipologieEsame;
	}
	
	public void setTipologieEsame(List<TipologiaEsame> tipologieEsame) {
		this.tipologieEsame = tipologieEsame;
	}
	
}
