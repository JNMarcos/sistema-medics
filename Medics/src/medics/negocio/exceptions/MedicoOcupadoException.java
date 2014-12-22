package medics.negocio.exceptions;

public class MedicoOcupadoException extends Exception {
	
	public String toString() {
		return "Hora já marcada para este médico !";
	}

}
