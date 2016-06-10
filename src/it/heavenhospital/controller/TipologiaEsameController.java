package it.heavenhospital.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.heavenhospital.model.AmministratoreFacade;
import it.heavenhospital.model.Indicatore;
import it.heavenhospital.model.Prerequisito;
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
	@ManagedProperty(value="#{param.idindicatore}") 
	private Long idindicatore; 
	private String[] indicatoriArray;
	private Set<Indicatore> indicatori; 
	private String[] nomiPrerequisiti; 
	private String[] descrizioniPrerequisiti;
	private Set<Prerequisito> prerequisiti; 
	

	@EJB
	private AmministratoreFacade amministratoreFacade;

	@PostConstruct
	public void elencoTipologie(){
		this.tipologieEsame = amministratoreFacade.getAllTipologieEsame();
		indicatoriArray = new String[2];
		indicatori = new HashSet<>();
		nomiPrerequisiti = new String[2];
		descrizioniPrerequisiti = new String[2];
		prerequisiti = new HashSet<>();
	}

	public String createTipologiaEsame(){
		String nextPage = "successNewTipologiaEsame";
		try{
			for(String i : indicatoriArray){
				if(i==null || (i.equals("")));
				else{ 
					Indicatore nuovoIndicatore = new Indicatore(i);
					indicatori.add(nuovoIndicatore);
				}			
			}
			for(int i=0; i<nomiPrerequisiti.length; i++){
				if(nomiPrerequisiti[i].equals("") || descrizioniPrerequisiti[i].equals(""));
				else {
					Prerequisito nuovoPrerequisito = new Prerequisito(nomiPrerequisiti[i], descrizioniPrerequisiti[i]);
					prerequisiti.add(nuovoPrerequisito);
				}
			}
			this.tipologiaEsame = amministratoreFacade.createTipologiaEsame(nome, descrizione, costo, indicatori, prerequisiti);
		} catch (EJBTransactionRolledbackException e){ 
			nextPage = "errorNewTipologiaEsame";
			this.tipologiaEsame = new TipologiaEsame(nome, descrizione, costo); 

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

	public Long getIdindicatore() {
		return idindicatore;
	}

	public Set<Indicatore> getIndicatori() {
		return indicatori;
	}

	public String[] getIndicatoriArray() {
		return indicatoriArray;
	}

	public void setIndicatoriArray(String[] indicatoriArray) {
		this.indicatoriArray = indicatoriArray;
	}
	public void setIdindicatore(Long idindicatore) {
		this.idindicatore = idindicatore;
	}

	public void setIndicatori(Set<Indicatore> indicatori) {
		this.indicatori = indicatori;
	}
	
	public String[] getDescrizioniPrerequisiti() {
		return descrizioniPrerequisiti;
	}
	public String[] getNomiPrerequisiti() {
		return nomiPrerequisiti;
	}
	
	public Set<Prerequisito> getPrerequisiti() {
		return prerequisiti;
	}
	
	public void setDescrizioniPrerequisiti(String[] descrizioniPrerequisiti) {
		this.descrizioniPrerequisiti = descrizioniPrerequisiti;
	}
	
	public void setNomiPrerequisiti(String[] nomiPrerequisiti) {
		this.nomiPrerequisiti = nomiPrerequisiti;
	}
	
	public void setPrerequisiti(Set<Prerequisito> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}
} 
