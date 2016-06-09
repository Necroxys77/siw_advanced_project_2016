package it.heavenhospital.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQuery(name="allEsami", query="SELECT e FROM Esame e")
public class Esame {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDiPrenotazione;
	@Temporal (TemporalType.DATE)
	private Date dataDiEsecuzione;
	//@Column(unique=true)
	//private String codice;
	@ManyToOne
	private Paziente paziente;
	@ManyToOne(fetch = FetchType.LAZY)
	private Medico medico;
	@ManyToOne
	@JoinColumn(name="tipologiaesame_id")
	private TipologiaEsame tipologiaEsame;
	@ElementCollection
	@MapKeyJoinColumn(name="indicatore_id")
	@Column(name="valore")
	private Map<Indicatore,String> risultati;

	public Esame() {
		this.risultati = new HashMap<>();
	}
	
	
	public Esame(Date dataDiPrenotazione, Date dataDiEsecuzione, Paziente paziente, TipologiaEsame tipologiaEsame, Medico medico){
		this.dataDiPrenotazione= dataDiPrenotazione;
		this.dataDiEsecuzione = dataDiEsecuzione;
		this.paziente = paziente;
		this.tipologiaEsame = tipologiaEsame;
		this.medico = medico;
		this.risultati = new HashMap<>();
	}

	/*
	 * metodo per prendere gli indicatori della tipologia a cui appartiene l'esame e inserirli come chiave nella mappa. SERVIRA'? Vedremo...
	 */
	public void inserisciIndicatoriInRisultati(){
		Set<Indicatore> indicatori = this.tipologiaEsame.getIndicatori();
		for(Indicatore indicatore : indicatori)
			//creo la mappa con valori nulli e chiave pari agli indicatori di quella tipologia
			this.risultati.put(indicatore, null);
	}

	/*
	 * Se nella tipologiaEsame associata a questo Esame esiste l'indicatore passato come parametro
	 *  inseriscilo e aggiorna il valore. Altrimenti non fare nulla. (?PER ORA?)
	 */
	public boolean addRisultato(Indicatore indicatore, String valore){
		boolean check = false;
		if(this.tipologiaEsame.getIndicatori().contains(indicatore)){
			this.risultati.put(indicatore, valore);
			check = true;
		}
		return check;
	}

	//metodi setter/getter
	public Long getId() {
		return id;
	}

	public Map<Indicatore, String> getRisultati() {
		return risultati;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}

	/*public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getCodice() {
		return codice;
	}*/

	public Date getDataDiEsecuzione() {
		return dataDiEsecuzione;
	}

	public void setDataDiEsecuzione(Date dataDiEsecuzione) {
		this.dataDiEsecuzione = dataDiEsecuzione;
	}

	public Date getDataDiPrenotazione() {
		return dataDiPrenotazione;
	}

	public void setDataDiPrenotazione(Date dataDiPrenotazione) {
		this.dataDiPrenotazione = dataDiPrenotazione;
	}


	//metodi equals e hashcode

	@Override
	public boolean equals(Object obj) {
		Esame esame = (Esame) obj;
		return esame.getDataDiPrenotazione().equals(this.getDataDiPrenotazione()) &&
				esame.getPaziente().equals(this.getPaziente());
	}

	@Override
	public int hashCode() {
		return this.getDataDiPrenotazione().hashCode() + this.getPaziente().hashCode();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Esame"); 
		sb.append("{id='").append(id); 
		sb.append(", dataDiPrenotazione='").append(dataDiPrenotazione);
		sb.append(", dataDiEsecuzione='").append(dataDiEsecuzione);
		sb.append("}\n");
		return sb.toString();
	}
}
