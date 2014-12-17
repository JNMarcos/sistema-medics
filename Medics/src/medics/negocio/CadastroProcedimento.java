package medics.negocio;

import java.util.Scanner;

import medics.dados.IRepositorioProcedimento;
import medics.dados.RepositorioProcedimento;
import medics.gui.TelaTextual;
import medics.negocio.classes_basicas.Procedimento;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.NaoEncontradoException;

public class CadastroProcedimento {
	TelaTextual tela = new TelaTextual();
	Scanner input = new Scanner(System.in);
	private IRepositorioProcedimento repositorio;

	public CadastroProcedimento() {
		this.repositorio = RepositorioProcedimento.getInstance();
	}

	public void cadastrar(String nome) {

		Procedimento procedimento = new Procedimento();
		procedimento.setNome(nome);

		repositorio.cadastrar(procedimento);
	}

	public void modificar(String nome, String novo) throws ArrayVazioException,
			NaoEncontradoException {
			repositorio.modificar(nome, novo);

	}

	public void remover(String nome) throws ArrayVazioException, NaoEncontradoException {
		try {
			repositorio.remover(nome);
		} catch (ArrayVazioException e) {
			throw e;
		} catch(NaoEncontradoException n){
			throw n;
		}
	}
	
	public void salvar(){
		RepositorioProcedimento.salvarArquivo();
	}
}
