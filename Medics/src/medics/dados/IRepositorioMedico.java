package medics.dados;

import medics.negocio.classes_basicas.Medico;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.NaoEncontradoException;

import java.util.ArrayList;

public interface IRepositorioMedico {

	public abstract void criarLista();

	public abstract ArrayList<Medico> getLista();

	public abstract void setLista(ArrayList<Medico> lista);

	public abstract void cadastrar(Medico medico);

	public abstract void modificar(String primerioNome, String segundoNome,
			String opt, String novo) throws ArrayVazioException,
			NaoEncontradoException;

	public abstract void exibir();

	public abstract void remover(String primeiroNome, String segundoNome)
			throws ArrayVazioException, NaoEncontradoException;

	public abstract void verificarLogin(String login, String senha) throws NaoEncontradoException;

}
