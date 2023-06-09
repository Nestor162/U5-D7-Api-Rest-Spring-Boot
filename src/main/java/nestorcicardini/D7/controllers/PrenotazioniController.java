package nestorcicardini.D7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nestorcicardini.D7.entities.Prenotazione;
import nestorcicardini.D7.exceptions.NotFoundException;
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
	public Prenotazione savePrenotazione(@RequestBody Prenotazione body) {
		Prenotazione prenotazioneCreata = gestionePrenotazioni
				.salvaPrenotazione(body);
		return prenotazioneCreata;
	}

	// READ (GET) - http://localhost:3001/prenotazioni
	@GetMapping("")
	public List<Prenotazione> getAllPrenotazioni() {
		return gestionePrenotazioni.getAllPrenotzioni();
	}

	// READ (GET) - http://localhost:3001/prenotazioni + req. body
	@GetMapping("/{PrenotazioneId}")
	public Prenotazione findById(@PathVariable String PrenotazioneId) {
		return gestionePrenotazioni.findById(PrenotazioneId)
				.orElseThrow(() -> new NotFoundException(PrenotazioneId));
	}

	// UPDATE (PUT) - http://localhost:3001/prenotazioni/:PrenotazioneId + req.
	// body

	@PutMapping("/{PrenotazioneId}")
	public Prenotazione findByIdAndUpdate(@PathVariable String PrenotazioneId,
			@RequestBody Prenotazione body) {
		return gestionePrenotazioni.findByIdAndUpdate(PrenotazioneId, body)
				.orElseThrow(() -> new NotFoundException(PrenotazioneId));
	}

	// 5. - DELETE http://localhost:3001/prenotazioni/:PrenotazioneId
	@DeleteMapping("/{PrenotazioneId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void findByIdAndDelete(@PathVariable String PrenotazioneId) {
		gestionePrenotazioni.findByIdAndDelete(PrenotazioneId)
				.orElseThrow(() -> new NotFoundException(PrenotazioneId));
	}
}
