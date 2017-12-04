package fr.insee.bar.exception;

import fr.insee.bar.model.Salarie;

@SuppressWarnings("serial")
public class BarDroitException extends BarHttpException {

	public BarDroitException(Salarie salarie) {
		super("L’employé ne possède pas les droits pour effectuer l’action");
	}
}
