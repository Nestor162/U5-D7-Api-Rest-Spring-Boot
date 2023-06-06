package nestorcicardini.D7.exceptions;

public class NotFoundException extends RuntimeException {

	public NotFoundException(String id) {
		super("Item with id " + id + " not found!");
	}

}