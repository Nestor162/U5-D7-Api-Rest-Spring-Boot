package nestorcicardini.D7.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Utente {
	private String username;
	private String email;
	private String citta;
}
