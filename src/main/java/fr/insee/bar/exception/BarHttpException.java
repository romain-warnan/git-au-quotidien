package fr.insee.bar.exception;


@SuppressWarnings("serial")
public class BarHttpException extends BarException {

	public BarHttpException() {
		super();
	}

	public BarHttpException(String message) {
		super(message);
	}
}
