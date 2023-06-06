package nestorcicardini.D7.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nestorcicardini.D7.exceptions.UnknownLanguageException;

@RestController
@RequestMapping("/info")
public class PrenotazioniController {

	@GetMapping(" ")
	public String getWelcomeMsg() {
		return "Welcome to GestionePrenotazioni" + System.lineSeparator()
				+ "Go to /eng to get rules in englis" + System.lineSeparator()
				+ "Vai su /ita per ottenere le regole in italiano";

	}

	@GetMapping("/eng")
	public String getRulesInEnglish() {
		return "English:" + System.lineSeparator()
				+ "1. Select the desired type of workstation (PRIVATE, OPENSPACE, MEETING_ROOM)."
				+ System.lineSeparator()
				+ "2. Choose the city where you want to make the reservation."
				+ System.lineSeparator()
				+ "3. Check the availability of workstations for the desired date."
				+ System.lineSeparator()
				+ "4. If a workstation is available, provide your username, full name, and email to make the reservation."
				+ System.lineSeparator()
				+ "5. Each user can only reserve one workstation for a specific date.";
	}

	@GetMapping("/ita")
	public String getRulesInItalian() {
		return "Italiano:" + System.lineSeparator()
				+ "1. Seleziona il tipo di postazione desiderata (PRIVATA, OPENSPACE, SALA_RIUNIONI)."
				+ System.lineSeparator()
				+ "2. Scegli la città in cui desideri effettuare la prenotazione."
				+ System.lineSeparator()
				+ "3. Verifica la disponibilità delle postazioni per la data desiderata."
				+ System.lineSeparator()
				+ "4. Se una postazione è disponibile, fornisci il tuo username, nome completo ed email per effettuare la prenotazione."
				+ System.lineSeparator()
				+ "5. Ogni utente può prenotare solo una postazione per una data specifica.";
	}

	@GetMapping("/{lang}")
	public String handleUnknownLanguage(@PathVariable String lang) {
		throw new UnknownLanguageException(lang);
	}

}
