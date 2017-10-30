package fr.insee.bar.exception;

import fr.insee.bar.model.Agent;

@SuppressWarnings("serial")
public class BarDroitException extends BarHttpException {

	public BarDroitException(Agent agent) {
		super("L’employé ne possède pas les droits pour effectuer l’action");
	}
}
