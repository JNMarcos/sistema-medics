package medics.dados;

import java.util.ArrayList;

import medics.negocio.classes_basicas.Procedimento;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.NaoEncontradoException;

public interface IRepositorioProcedimento {

	public abstract void criarLista();
	
	public abstract ArrayList<Procedimento> getLista();

	public abstract void setLista(ArrayList<Procedimento> lista);

	public abstract void cadastrar(Procedimento procedimento);

	public abstract void remover(String nome);
	
	
}
