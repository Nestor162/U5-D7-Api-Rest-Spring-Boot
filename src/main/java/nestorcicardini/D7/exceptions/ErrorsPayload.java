package nestorcicardini.D7.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorsPayload {
	private String msg;
	private Date timestamp;
	private int internalCode;

}
