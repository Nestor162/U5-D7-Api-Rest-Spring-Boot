package nestorcicardini.D7.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
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

	public List<Prenotazione> getAllPrenotzioni() {
		return this.prenotazioni;
	}

	public Optional<Prenotazione> findById(String id) {
		Prenotazione p = null;
		UUID uuid = UUID.fromString(id);
		for (Prenotazione prenotazione : prenotazioni) {
			if (prenotazione.getId().equals(uuid)) {
				return Optional.of(prenotazione);
			}
		}
		return Optional.ofNullable(p);
	}

	public Optional<Prenotazione> findByIdAndUpdate(String id,
			Prenotazione prenotazione) {
		Prenotazione found = null;
		UUID uuid = UUID.fromString(id);
		for (Prenotazione p : prenotazioni) {
			if (prenotazione.getId().equals(uuid)) {
				found = p;
				found.setDescrizione(prenotazione.getDescrizione());
				found.setEdificio(prenotazione.getEdificio());
				found.setMaxOccupanti(prenotazione.getMaxOccupanti());
				found.setTipo(prenotazione.getTipo());
			}
		}
		return Optional.ofNullable(found);
	}

	public Optional<Prenotazione> findByIdAndDelete(String id) {
		ListIterator<Prenotazione> iterator = this.prenotazioni.listIterator();

		Prenotazione found = null;
		while (iterator.hasNext()) {
			UUID uuid = UUID.fromString(id);
			Prenotazione currentP = iterator.next();
			if (currentP.getId().equals(uuid)) {
				found = currentP;
				iterator.remove();
			}
		}
		return Optional.ofNullable(found);
	}

}
