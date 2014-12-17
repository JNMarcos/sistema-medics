package medics.negocio;

import java.util.Scanner;

import medics.dados.IRepositorioMedico;
import medics.dados.RepositorioMedico;
import medics.gui.TelaTextual;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.NaoEncontradoException;

public class CadastroMedico {
	TelaTextual tela = new TelaTextual();
	Scanner input = new Scanner(System.in);
	private IRepositorioMedico repositorio;

	public CadastroMedico() {
		this.repositorio = RepositorioMedico.getInstance();
	}

	public void cadastrar(Medico medico) {
		repositorio.cadastrar(medico);
	}

	public void modificar(String primeiroNome, String segundoNome, String opt,
			String novo) throws ArrayVazioException, NaoEncontradoException {

		repositorio.modificar(primeiroNome, segundoNome, opt, novo);

	}

	public void remover(String primeiroNome, String segundoNome)
			throws ArrayVazioException, NaoEncontradoException {

		repositorio.remover(primeiroNome, segundoNome);

	}

	public void verificarLogin(String login, String senha)
			throws NaoEncontradoException {
		repositorio.verificarLogin(login, senha);
	}

	public void salvar() {
		RepositorioMedico.salvarArquivo();
	}

}
