package medics.dados;

import java.util.ArrayList;

import medics.negocio.classes_basicas.Procedimento;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.NaoEncontradoException;

public interface IRepositorioProcedimento {

	public void criarLista();
	
	public ArrayList<Procedimento> getLista();

	public void setLista(ArrayList<Procedimento> lista);

	public void cadastrar(Procedimento procedimento);

	public void modificar(String nomeProcurado, String novoNome) throws ArrayVazioException, NaoEncontradoException;
	
	public void exibir();

	public void remover(String nome) throws ArrayVazioException, NaoEncontradoException;
	
}
