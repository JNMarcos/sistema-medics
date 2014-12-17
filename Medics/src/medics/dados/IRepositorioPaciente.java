package medics.dados;

import java.util.ArrayList;

import medics.negocio.classes_basicas.Paciente;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.CpfExistenteException;
import medics.negocio.exceptions.NaoEncontradoException;

public interface IRepositorioPaciente {

	public abstract void criarLista();

	public abstract ArrayList<Paciente> getLista();

	public abstract void setLista(ArrayList<Paciente> lista);

	public void cadastrar(Paciente paciente) throws CpfExistenteException;

	public abstract void modificar(String primeiroNome, String segundoNome,
			String opt, String novo) throws ArrayVazioException,
			NaoEncontradoException;

	public abstract void exibir();

	public abstract void remover(String primeiroNome, String segundoNome)
			throws ArrayVazioException, NaoEncontradoException;

}
