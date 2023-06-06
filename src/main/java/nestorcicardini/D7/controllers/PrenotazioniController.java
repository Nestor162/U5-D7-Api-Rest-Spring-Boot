package nestorcicardini.D7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nestorcicardini.D7.entities.Prenotazione;
import nestorcicardini.D7.services.GestionePrenotazioniService;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

	@Autowired
	GestionePrenotazioniService gestionePrenotazioni;

	// CRUD:
	// CREATE (POST) - http://localhost:3001/prenotazioni

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED) // Status code 201
	public Prenotazione saveUser(@RequestBody Prenotazione body) {
		Prenotazione prenotazioneCreata = gestionePrenotazioni
				.salvaPrenotazione(body);
		return prenotazioneCreata;
	}

	// READ (GET) - http://localhost:3001/prenotazioni
}
