package it.heavenhospital.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.heavenhospital.model.AmministratoreFacade;
import it.heavenhospital.model.Esame;
import it.heavenhospital.model.Indicatore;
import it.heavenhospital.model.Medico;
import it.heavenhospital.model.Paziente;
import it.heavenhospital.model.TipologiaEsame;

@ManagedBean
public class EsameController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Date dataDiPrenotazione;
	private Date dataDiEsecuzione;
	@ManagedProperty(value="#{param.idpaziente}")
	private Long idpaziente;
	private Paziente paziente;
	@ManagedProperty(value="#{param.idtipologia}")
	private Long idtipologia;
	private TipologiaEsame tipologiaEsame;
	@ManagedProperty(value="#{param.idmedico}")
	private Long idmedico;
	private Medico medico;
	private Esame esame;
	private List<Esame> esami;
	private List<Esame> esamiMedico;
	private Set<Indicatore> indicatoriTipologiaAssociata;

	@EJB
	private AmministratoreFacade amministratoreFacade;


	public String createEsame(){
		this.dataDiPrenotazione = new Date();
		this.setMedico(amministratoreFacade.getMedico(idmedico));
		this.setTipologiaEsame(amministratoreFacade.getTipologiaEsame(idtipologia));
		this.setPaziente(amministratoreFacade.getPaziente(idpaziente));
		this.esame = amministratoreFacade.createEsame(dataDiPrenotazione,dataDiEsecuzione,paziente,tipologiaEsame,medico);
		return "successNewEsame";
	}
	
	public String findEsame(){
		this.esame = amministratoreFacade.getEsame(id);
		this.indicatoriTipologiaAssociata = this.esame.getTipologiaEsame().getIndicatori();
		return "dettaglioEsame"; //pagina non implementata perché non facente parte dei casi d'uso scelti
	}
	
	
	public String findEsamiPerMedico(){
		this.esamiMedico = amministratoreFacade.getEsamiMedico(idmedico);
		return "elencoEsamiMedico";
	}

	public void setDataDiEsecuzione(Date dataDiEsecuzione) {
		this.dataDiEsecuzione = dataDiEsecuzione;
	}
	public Date getDataDiEsecuzione() {
		return dataDiEsecuzione;
	}
	public void setDataDiPrenotazione(Date dataDiPrenotazione) {
		this.dataDiPrenotazione = dataDiPrenotazione;
	}

	public Date getDataDiPrenotazione() {
		return dataDiPrenotazione;
	}

	public void setEsame(Esame esame) {
		this.esame = esame;
	}

	public Esame getEsame() {
		return esame;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}

	public List<Esame> getEsami() {
		return esami;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setIdmedico(Long idmedico) {
		this.idmedico = idmedico;
	}

	public Long getIdmedico() {
		return idmedico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public Medico getMedico() {
		return medico;
	}
	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}

	public Paziente getPaziente() {
		return paziente;
	}
	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public Long getIdpaziente() {
		return idpaziente;
	}
	public Long getIdtipologia() {
		return idtipologia;
	}

	public void setIdpaziente(Long idpaziente) {
		this.idpaziente = idpaziente;
	}

	public void setIdtipologia(Long idtipologia) {
		this.idtipologia = idtipologia;
	}
	
	public List<Esame> getEsamiMedico() {
		return esamiMedico;
	}
	
	public void setEsamiMedico(List<Esame> esamiMedico) {
		this.esamiMedico = esamiMedico;
	}
	
	public Set<Indicatore> getIndicatoriTipologiaAssociata() {
		return indicatoriTipologiaAssociata;
	}
	
	public void setIndicatoriTipologiaAssociata(Set<Indicatore> indicatoriTipologiaAssociata) {
		this.indicatoriTipologiaAssociata = indicatoriTipologiaAssociata;
	}
}
