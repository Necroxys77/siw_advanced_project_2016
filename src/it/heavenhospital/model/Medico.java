package it.heavenhospital.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@NamedQuery(name="allMedici", query="SELECT m FROM Medico m")
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"nome","cognome"}))
public class Medico {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	@Column(nullable=false)
	private String specializzazione;
	@OneToMany(mappedBy="medico")
	private List<Esame> esami;

	public Medico(){
		this.esami = new ArrayList<>();
	}

	public Medico(String password, String nome, String cognome,String specializzazione){
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.specializzazione = specializzazione;
		this.esami = new ArrayList<>();
	}

	public void addEsame(Esame esame){
		esami.add(esame);
	}
	
	//setter & getters
	public Long getId() {
		return id;
	}
	
	public List<Esame> getEsami() {
		return esami;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//metodi equals e hashcode

	@Override
	public boolean equals(Object obj) {
		Medico med = (Medico) obj;
		return med.getNome().equals(this.getNome()) &&
				med.getCognome().equals(this.getCognome());
	}

	@Override
	public int hashCode() {
		return this.getCognome().hashCode() + this.getNome().hashCode();
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Medico"); 
		sb.append("{id='").append(id); 
		sb.append(", nome='").append(nome);
		sb.append(", cognome='").append(cognome);
		sb.append(", specializzazione='").append(specializzazione);
		sb.append("}\n");
		return sb.toString();
	}
}
