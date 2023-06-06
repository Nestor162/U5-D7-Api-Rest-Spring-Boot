package nestorcicardini.D7.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import nestorcicardini.D7.entities.Prenotazione;

@Service
public class GestionePrenotazioniService {

	private List<Prenotazione> prenotazioni = new ArrayList<>();

	public Prenotazione salvaPrenotazione(Prenotazione payload) {
		payload.setId(UUID.randomUUID());
		prenotazioni.add(payload);
		return payload;
	}
}
