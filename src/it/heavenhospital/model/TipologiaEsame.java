package it.heavenhospital.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class TipologiaEsame {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Integer costo;
	@Column(nullable=false,unique=true)
	private String nome;
	@Column(length=2000)
	private String descrizione;
	@ManyToMany (cascade={CascadeType.PERSIST})
	@JoinTable(name="tipologiaesame_indicatore", joinColumns=@JoinColumn(name="tipologiaesame_id"), inverseJoinColumns=@JoinColumn(name="indicatore_id"))  
	//metto un Set perch� voglio essere sicuro che non esistono doppi indicatori E in modo tale da creare una chiave composita nel database
	private Set<Indicatore> indicatori;	
	@ManyToMany(fetch = FetchType.EAGER,cascade={CascadeType.PERSIST})
	@JoinTable(name="tipologiaesame_prerequisito", joinColumns=@JoinColumn(name="tipologiaesame_prerequisito"), inverseJoinColumns=@JoinColumn(name="prerequisito_nome"))
	private Set<Prerequisito> prerequisiti;
	
	
	public TipologiaEsame() {
		this.indicatori = new HashSet<>();
		this.prerequisiti = new HashSet<>();
	}
	
	public TipologiaEsame(String nome, String descrizione, Integer costo){
		this.nome = nome;
		this.costo = costo;
		this.descrizione = descrizione;
		this.indicatori = new HashSet<>();
		this.prerequisiti = new HashSet<>();
	}
	
	//metodi setter e getter
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<Indicatore> getIndicatori() {
		return indicatori;
	}
	
	public void addIndicatore(Indicatore indicatore){
		this.indicatori.add(indicatore);
	}
	
	public Set<Prerequisito> getPrerequisiti() {
		return prerequisiti;
	}
	
	public void addPrerequisito(Prerequisito prerequisito){
		this.prerequisiti.add(prerequisito);
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
	
	public void setIndicatori(Set<Indicatore> indicatori) {
		this.indicatori = indicatori;
	}
	public void setPrerequisiti(Set<Prerequisito> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}
	
	//metodi equals e hashcode
	@Override
	public boolean equals(Object obj) {
		TipologiaEsame tipologiaEsame = (TipologiaEsame)obj;
		return tipologiaEsame.getNome().equals(this.getNome())&&
				tipologiaEsame.getCosto().equals(this.getCosto());
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode() + this.getCosto().hashCode();
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("TipologiaEsame"); 
		sb.append("{id='").append(id); 
		sb.append(", nome='").append(nome);
		sb.append(", costo='").append(costo);
		sb.append(", descrizione='").append(descrizione);
		sb.append("}\n");
		return sb.toString();
	}
}
