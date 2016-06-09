package it.heavenhospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="allPrerequisiti",query="SELECT p FROM Prerequisito p")
public class Prerequisito {
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(unique=true,nullable=false)
	private String nome;
	@Column(nullable=false,length=2000)
	private String descrizione;
	
	public Prerequisito(){}
	
	public Prerequisito(String nome, String descrizione){
		this.nome = nome;
		this.descrizione = descrizione;
	}
	
	//metodi getters e setters
	
	
	public Long getId(){
		return this.id;
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
	
	//metodi equals e hashcode
	
	@Override
	public boolean equals(Object obj) {
		Prerequisito ind = (Prerequisito) obj;
		return ind.getNome().equals(this.getNome());
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Prerequisito"); 
		sb.append("{id='").append(id); 
		sb.append(", nome='").append(nome);
		sb.append(", descrizione='").append(descrizione);
		sb.append("}\n");
		return sb.toString();
	}
}
