package nestorcicardini.D7.entities;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Prenotazione {
	private UUID id;
	private String descrizione;
	private Tipo tipo;
	private int maxOccupanti;
	private boolean disponibile;

	@Autowired
	private Edificio edificio;

	public enum Tipo {
		PRIVATO, OPENSCALE, SALA_RIUNIONI
	}

}
