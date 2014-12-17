package medics.negocio;

import java.util.ArrayList;
import java.util.Scanner;

import medics.dados.IRepositorioPaciente;
import medics.dados.RepositorioPaciente;
import medics.gui.TelaTextual;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.CpfExistenteException;
import medics.negocio.exceptions.NaoEncontradoException;

public class CadastroPaciente {
	Scanner input = new Scanner(System.in);
	private IRepositorioPaciente repositorio;

	public CadastroPaciente() {
		this.repositorio = RepositorioPaciente.getInstance();
	}

	public void cadastrar(Paciente paciente) throws CpfExistenteException{
		repositorio.cadastrar(paciente);

	}

	public void modificar(String primeiroNome, String segundoNome, String opt,
			String novo) throws ArrayVazioException, NaoEncontradoException {

		repositorio.modificar(primeiroNome, segundoNome, opt, novo);

	}

	public void remover(String primeiroNome, String segundoNome)
			throws ArrayVazioException, NaoEncontradoException {
		repositorio.remover(primeiroNome, segundoNome);

	}

	public void salvar() {
		RepositorioPaciente.salvarArquivo();
	}
	
	public ArrayList<Paciente> getList(){
		return repositorio.getLista();
	}

}
