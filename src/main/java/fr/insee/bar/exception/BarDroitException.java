package fr.insee.bar.exception;

import fr.insee.bar.model.Employe;

@SuppressWarnings("serial")
public class BarDroitException extends BarHttpException {

	public BarDroitException(Employe employe) {
		super("L’employé ne possède pas les droits pour effectuer l’action");
	}
}
