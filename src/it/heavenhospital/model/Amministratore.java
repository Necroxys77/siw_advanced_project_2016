package it.heavenhospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name="allAmministratori", query = "SELECT a FROM Amministratore a")
public class Amministratore {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false, name="password")
	private String password;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	@Column(unique=true,nullable=false)
	private String email;

	public Amministratore(){}

	public Amministratore(String email, String password, String nome, String cognome){
		this.nome = nome;
		this.email = email;
		this.cognome = cognome;
		this.password = password;
	}
	
	public boolean checkPassword(String password){
		return this.password.equals(password);
	}

	//setter & getters
	public Long getId() {
		return id;
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
		sb.append("Amministratore"); 
		sb.append("{id='").append(id); 
		sb.append(", nome='").append(nome);
		sb.append(", cognome='").append(cognome);
		sb.append(", email='").append(email);
		sb.append("}\n");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		Amministratore adm = (Amministratore) obj;
		return adm.getEmail().equals(this.getEmail());
	}
	
	@Override
	public int hashCode() {
		return this.getEmail().hashCode();
	}
}
