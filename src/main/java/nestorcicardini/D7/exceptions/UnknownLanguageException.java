package nestorcicardini.D7.exceptions;

public class UnknownLanguageException extends RuntimeException {

	public UnknownLanguageException(String lang) {
		super(lang + " is not a supported language! Try '/ita' or '/eng' ");
	}
}
