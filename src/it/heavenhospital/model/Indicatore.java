package it.heavenhospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="allIndicatori",query="SELECT i FROM Indicatore i")
public class Indicatore {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(unique=false,nullable=false) //In realtà, sarebbe meglio UNIQUE=TRUE
	private String nome;
	//@ManyToOne //prova 09-06-2016
	//@JoinColumn(name="tipologiaesame_id") //prova 09-06-2016
	//private TipologiaEsame tipologiaEsame; //prova 09-06-2016
	
	public Indicatore() {}
	
	public Indicatore(String nome){
		this.nome = nome;
	}
	
	//metodi getters e setters
	public Long getId() {
		return id;
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
		Indicatore ind = (Indicatore) obj;
		return ind.getNome().equals(this.getNome());
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Indicatore"); 
		sb.append("{id='").append(id); 
		sb.append(", nome='").append(nome);
		sb.append("}\n");
		return sb.toString();
	}
}
