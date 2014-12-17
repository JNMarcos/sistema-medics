package medics.negocio;

import java.util.ArrayList;
import java.util.Date;

import medics.negocio.classes_basicas.Medico;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.CpfExistenteException;
import medics.negocio.exceptions.NaoEncontradoException;

public interface IFachada {

	public void cadastrarPaciente(Paciente paciente) throws CpfExistenteException;

	public abstract void editarPaciente(String primeiroNome,
			String segundoNome, String opt, String novo)
			throws ArrayVazioException, NaoEncontradoException;

	public abstract void removerPaciente(String primerioNome, String segundoNome)
			throws ArrayVazioException, NaoEncontradoException;
	
	public abstract void salvarPaciente();

	public ArrayList<Paciente> retornarListaPaciente();
	
	public abstract void cadastrarMedico(Medico medico);

	public abstract void editarMedico(String primerioNome, String segundoNome,
			String opt, String novo) throws ArrayVazioException,
			NaoEncontradoException;

	public abstract void removerMedico(String primeiroNome, String segundoNome)
			throws ArrayVazioException, NaoEncontradoException;

	public abstract void cadastrarProcedimento(String nome);

	public abstract void editarProcedimento(String nome, String novo)
			throws ArrayVazioException, NaoEncontradoException;

	public abstract void removerProcedimento(String nome)
			throws ArrayVazioException, NaoEncontradoException;

	public abstract void verificarLogin(String login, String senha) throws NaoEncontradoException;

	public void verificarLoginMedico(String login, String senha) throws NaoEncontradoException;

	public abstract void cadastrarConsuta(String primeiroNomePaciente,
			String segundoNomePaciente, String primeiroNomeMedico,
			String segundoNomeMedico, String procedimento, Date data,
			String hora);

	public abstract void editarConsulta(Date data, String hora,
			String primeiroNomeMedico, String segundoNomeMedico, String opt,
			String novo);

	public abstract void removerConsulta(Date data, String hora);
}
