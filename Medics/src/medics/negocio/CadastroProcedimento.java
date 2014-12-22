package medics.negocio;

import java.util.ArrayList;
import java.util.Scanner;

import medics.dados.IRepositorioProcedimento;
import medics.dados.RepositorioProcedimento;
import medics.negocio.classes_basicas.Procedimento;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.NaoEncontradoException;

public class CadastroProcedimento {
	Scanner input = new Scanner(System.in);
	private IRepositorioProcedimento repositorio;

	public CadastroProcedimento() {
		this.repositorio = RepositorioProcedimento.getInstance();
	}

	public void cadastrar(Procedimento novo) {
		repositorio.cadastrar(novo);
	}

	public void remover(String nome)  {
		repositorio.remover(nome);
		
	}
	
	public void salvar(){
		RepositorioProcedimento.salvarArquivo();
	}
	
	public ArrayList<Procedimento> getList(){
	     return repositorio.getLista();	
	}
}
