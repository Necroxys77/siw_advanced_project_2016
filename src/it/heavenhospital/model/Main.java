package it.heavenhospital.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.heavenhospital.persistence.AmministratoreDaoJPA;
import it.heavenhospital.persistence.EsameDaoJPA;
import it.heavenhospital.persistence.MedicoDaoJPA;
import it.heavenhospital.persistence.PazienteDaoJPA;
import it.heavenhospital.persistence.TipologiaEsameDaoJPA;

public class Main {

	public static void main(String[] args) {
		//chiedo alla classe Persistence di creare un'oggetto che crea oggetti Entity Manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("heavenhospital-unit");
		//chiedo alla factory di creare un'istanza della classe EntityManager
		EntityManager em = emf.createEntityManager();

		//creo gli oggetti per il test 
		Amministratore amministratore = new Amministratore("prova@gmail.com","Prova123","Marco","Bianchi");
		Medico medico = new Medico("Password123", "Luca", "Bianchelli", "Chirurgo");

		Indicatore emoglobina = new Indicatore("Emoglobina");
		Indicatore linfociti = new Indicatore("Linfociti");

		TipologiaEsame tipologia = new TipologiaEsame();
		tipologia.setCosto(110);
		tipologia.setDescrizione("Controllo di routine del sangue");
		tipologia.setNome("Analisi del sangue");
		tipologia.addIndicatore(emoglobina);
		tipologia.addIndicatore(linfociti);

		Prerequisito digiuno12 = new Prerequisito("digiuno12", "Il paziente deve stare a digiuno per 12 ore");
		Prerequisito noPregnant = new Prerequisito("NoPregnant", "Il paziente non deve essere incinta");
		tipologia.addPrerequisito(noPregnant);
		tipologia.addPrerequisito(digiuno12);
		
		Esame esame = new Esame();
		Calendar cal = Calendar.getInstance();
		Date dataDiPrenotazione = new Date();
		esame.setDataDiPrenotazione(dataDiPrenotazione);
		cal.set(2016, 06, 02);
		Date dataDiEsecuzione = cal.getTime(); 
		esame.setDataDiEsecuzione(dataDiEsecuzione);
		esame.setMedico(medico);
		medico.addEsame(esame);

		esame.setTipologiaEsame(tipologia);
		esame.inserisciIndicatoriInRisultati();
		esame.addRisultato(linfociti, "10g/100ml");
		esame.addRisultato(emoglobina, "40g/100ml");

		Paziente paziente = new Paziente("paziente@yahoo.com", "pippo987", "Antonio", "Neri");
		paziente.addEsame(esame);
		esame.setPaziente(paziente);


		//rendo persistenti gli oggetti con gli oggettiDao. Notare come gli oggetti Indicatore e Prerequisito sono salvati in cascata grazie alle annotazioni in Tipologia
		AmministratoreDaoJPA amministratoreJPA = new AmministratoreDaoJPA(em);
		amministratoreJPA.save(amministratore);
		
		MedicoDaoJPA medicoJPA = new MedicoDaoJPA(em);
		medicoJPA.save(medico);
		
		PazienteDaoJPA pazienteJPA = new PazienteDaoJPA(em);
		pazienteJPA.save(paziente);
		
		// TipologiaEsame deve essere salvato prima dell'Esame, altrimenti c'è un errore a tempo di compilazione
		TipologiaEsameDaoJPA tipologiaEsameJPA = new TipologiaEsameDaoJPA(em);
		tipologiaEsameJPA.save(tipologia); // salvo in cascata anche gli Indicatori e i Prerequisiti
		
		EsameDaoJPA esameJPA = new EsameDaoJPA(em);
		esameJPA.save(esame);
		
		
		//chiudo la connessione agli oggetti EntityManager e EntityManagerFactory
		em.close();
		emf.close();
	}
}
