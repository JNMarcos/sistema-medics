package medics.negocio;

import java.util.Date;
import java.util.Scanner;

import medics.dados.IRepositorioConsulta;
import medics.dados.RepositorioConsulta;
import medics.gui.TelaTextual;

public class CadastroConsulta {

	TelaTextual tela = new TelaTextual();
	Scanner input = new Scanner(System.in);
	private IRepositorioConsulta repositorio;

	public CadastroConsulta() {
		this.repositorio = RepositorioConsulta.getInstance();
	}

	public void cadastrar(String primeiroNomePaciente,
			String segundoNomePaciente, String primeiroNomeMedico,
			String segundoNomeMedico, String procedimento, Date data,
			String hora, int minuto) {

		/*repositorio
				.cadastrar(primeiroNomePaciente, segundoNomePaciente,
						primeiroNomeMedico, segundoNomeMedico, procedimento,
						data, hora, minuto);
	*/
	}

	public void modificar(Date data, String hora, String primeiroNomeMedico,
			String segundoNomeMedico, String opt, String novo) {
		/*repositorio.modificar(data, hora, primeiroNomeMedico,
				segundoNomeMedico, opt, novo);
         */
	}

	public void remover(Date data, String hora) {
		repositorio.remover(data, hora);
	}

	public void salvar() {
		RepositorioConsulta.salvarArquivo();
	}

}
