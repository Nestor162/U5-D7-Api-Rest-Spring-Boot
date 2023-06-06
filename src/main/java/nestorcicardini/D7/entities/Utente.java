package nestorcicardini.D7.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Utente {
	private String username;
	private String email;
	private String nomeCompleto;
	private List<Prenotazione> listaPrenotazioniList;
}
