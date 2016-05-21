package it.heavenhospital.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
@NamedQuery(name="allPazienti", query="SELECT p FROM Paziente p")
public class Paziente{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	@Column(unique=true,nullable=false)
	private String email;
	@OneToMany(mappedBy="paziente",cascade={CascadeType.REMOVE})
	@OrderBy("dataDiEsecuzione ASC")
	private List<Esame> esami; //inserire una mappa? Intanto facciamo un progetto che sia funzionale, poi vedremo. Può essere che la ricerca la fa direttamente il database

	public Paziente(){
		this.esami = new ArrayList<>();
	}

	public Paziente(String email, String password, String nome, String cognome){
		this.nome = nome;
		this.email = email;
		this.cognome = cognome;
		this.password = password;
		this.esami = new ArrayList<>();
	}

	//setter & getters
	public Long getId() {
		return id;
	}
	
	public List<Esame> getEsami() {
		return esami;
	}
	
	public void addEsame(Esame esame){
		this.esami.add(esame);
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
	
	//metodi di supporto principali
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Paziente"); 
		sb.append("{id='").append(id); 
		sb.append(", nome='").append(nome);
		sb.append(", cognome='").append(cognome);
		sb.append(", email='").append(email);
		sb.append("}\n");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		Paziente adm = (Paziente) obj;
		return adm.getEmail().equals(this.getEmail()) &&
			   adm.getPassword().equals(this.getPassword());
	}
	
	@Override
	public int hashCode() {
		return this.getEmail().hashCode() + this.getPassword().hashCode();
	}
}
