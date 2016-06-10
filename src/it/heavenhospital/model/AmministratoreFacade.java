package it.heavenhospital.model;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.heavenhospital.persistence.AmministratoreDaoJPA;
import it.heavenhospital.persistence.EsameDaoJPA;
import it.heavenhospital.persistence.IndicatoreDaoJPA;
import it.heavenhospital.persistence.MedicoDaoJPA;
import it.heavenhospital.persistence.PazienteDaoJPA;
import it.heavenhospital.persistence.TipologiaEsameDaoJPA;

@Stateless
public class AmministratoreFacade {
	
	@PersistenceContext(unitName = "heavenhospital-unit")
	private EntityManager em;
	
	//metodi inerenti alla gestione delle Tipologie
	
	public TipologiaEsame createTipologiaEsame(String nome, String descrizione, Integer costo){
		TipologiaEsameDaoJPA tipologiaDao = new TipologiaEsameDaoJPA(em);
		TipologiaEsame tipologia = new TipologiaEsame(nome, descrizione, costo);
		tipologiaDao.save(tipologia);
		return tipologia;
	}
	
	/*public TipologiaEsame createTipologiaEsame(String nome, String descrizione, Integer costo, List<Indicatore> indicatori){
		TipologiaEsameDaoJPA tipologiaDao = new TipologiaEsameDaoJPA(em);
		TipologiaEsame tipologia = new TipologiaEsame(nome, descrizione, costo);
		tipologia.setIndicatori(indicatori);
		tipologiaDao.save(tipologia);
		return tipologia;
	}*/
	
	public TipologiaEsame getTipologiaEsame(Long id){
		TipologiaEsameDaoJPA tipologiaDao = new TipologiaEsameDaoJPA(em);
		TipologiaEsame tipologia = tipologiaDao.findByPrimaryKey(id);
		return tipologia;
	}
	
	public TipologiaEsame getTipologiaEsame(String nome){
		TipologiaEsameDaoJPA tipologiaDao = new TipologiaEsameDaoJPA(em);
		TipologiaEsame tipologia = tipologiaDao.findByNome(nome);
		return tipologia;
	}
	
	public List<TipologiaEsame> getAllTipologieEsame() {
		TipologiaEsameDaoJPA tipologiaDao = new TipologiaEsameDaoJPA(em);
		List<TipologiaEsame> tipologie = tipologiaDao.findAll();
		return tipologie;
	}
	
	//metodi inerenti alla gestione degli indicatori
	public Indicatore createIndicatore(String nome){
		IndicatoreDaoJPA indicatoreDao = new IndicatoreDaoJPA(em);
		Indicatore indicatore = new Indicatore(nome);
		indicatoreDao.save(indicatore);
		return indicatore;
	}
	
	public Indicatore getIndicatore(String nome){
		IndicatoreDaoJPA indicatoreDao = new IndicatoreDaoJPA(em);
		Indicatore indicatore = indicatoreDao.findByNome(nome);
		return indicatore;
	}
	
	public Indicatore getIndicatore(Long id){
		IndicatoreDaoJPA indicatoreDao = new IndicatoreDaoJPA(em);
		Indicatore indicatore = indicatoreDao.findByPrimaryKey(id);
		return indicatore;
	}
	
	public List<Indicatore> getAllIndicatori(){
		IndicatoreDaoJPA indicatoreDao = new IndicatoreDaoJPA(em);
		List<Indicatore> indicatori = indicatoreDao.findAll();
		return indicatori;
	}
	
	//metodi inerenti alla gestione dell'amministratore

	public Amministratore createAmministratore(String nome, String cognome, String email, String password){
		AmministratoreDaoJPA amministratoreDao = new AmministratoreDaoJPA(em);
		Amministratore amministratore =new Amministratore(email, password, nome, cognome);
		amministratoreDao.save(amministratore);
		return amministratore;
	}
	
	public Amministratore getAmministratore(String email){
		AmministratoreDaoJPA amministratoreDao = new AmministratoreDaoJPA(em);
		Amministratore amministratore = amministratoreDao.findByEmail(email);
		return amministratore;
	}
	
	//metodi inerenti alla gestione del medico
	
	public Medico createMedico(String nome, String cognome, String specializzazione, String password){
		MedicoDaoJPA medicoDao = new MedicoDaoJPA(em);
		Medico medico = new Medico(password, nome, cognome, specializzazione);
		medicoDao.save(medico);
		return medico;
	}
	
	public Medico getMedico(Long id){
		MedicoDaoJPA medicoDao = new MedicoDaoJPA(em);
		Medico medico = medicoDao.findByPrimaryKey(id);
		return medico;
	}
	
	public List<Medico> getAllMedici(){
		MedicoDaoJPA medicoDao = new MedicoDaoJPA(em);
		List<Medico> medici = medicoDao.findAll();
		return medici;
	}
	
	public List<Esame> getEsamiMedico(Long idmedico){
		EsameDaoJPA esameDao = new EsameDaoJPA(em);
		List<Esame> esamiMedico = esameDao.findAllByMedicoId(idmedico);
		return esamiMedico;
	}
		
	//metodi per l'esame
	public Esame createEsame(Date dataDiPrenotazione, Date dataDiEsecuzione, Paziente paziente, TipologiaEsame tipologiaEsame, Medico medico){
		EsameDaoJPA esameDao = new EsameDaoJPA(em);
		Esame esame = new Esame(dataDiPrenotazione, dataDiEsecuzione, paziente, tipologiaEsame, medico);
		esameDao.save(esame);
		return esame;
	}
	
	public Paziente getPaziente(Long id){
		PazienteDaoJPA pazienteDao = new PazienteDaoJPA(em);
		Paziente paziente = pazienteDao.findByPrimaryKey(id);
		return paziente;
	}
	

}
