package medics.negocio.exceptions;

public class CpfExistenteException extends Exception {
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "Cpf existente !";
	}
}
