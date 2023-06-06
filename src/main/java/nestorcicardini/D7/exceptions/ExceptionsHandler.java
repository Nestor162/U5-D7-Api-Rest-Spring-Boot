package nestorcicardini.D7.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UnknownLanguageException.class)
	protected ResponseEntity<ErrorsPayload> handleLangErrors(
			UnknownLanguageException e) {

		ErrorsPayload payload = new ErrorsPayload(e.getMessage(), new Date(),
				400);
		return new ResponseEntity<>(payload, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorsPayload> handleNotFound(NotFoundException e) {
		ErrorsPayload payload = new ErrorsPayload(e.getMessage(), new Date(),
				404);
		return new ResponseEntity<ErrorsPayload>(payload, HttpStatus.NOT_FOUND);
	}
}
