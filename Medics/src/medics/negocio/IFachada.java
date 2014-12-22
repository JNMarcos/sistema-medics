package medics.negocio;

import java.util.ArrayList;
import java.util.Date;

import medics.negocio.classes_basicas.Consulta;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.classes_basicas.Procedimento;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.CodigoExistenteException;
import medics.negocio.exceptions.CpfExistenteException;
import medics.negocio.exceptions.LoginExistenteException;
import medics.negocio.exceptions.MedicoOcupadoException;
import medics.negocio.exceptions.NaoEncontradoException;
import medics.negocio.exceptions.SenhaExistenteException;

public interface IFachada {

	public void cadastrarPaciente(Paciente paciente) throws CpfExistenteException;

	public abstract void removerPaciente(String cpf);
	
	public abstract void salvarPaciente();

	public ArrayList<Paciente> retornarListaPaciente();
	
	public Paciente exibirPaciente(String cpf);
	
	public abstract void cadastrarMedico(Medico medico) throws CpfExistenteException, LoginExistenteException, SenhaExistenteException;

	public abstract void removerMedico(String cpf);
	
	public abstract ArrayList<Medico> retornarListaMedico();
    
	public abstract Medico exibirMedico(String cpf);
	
	public abstract Medico exibirMedicoPorLogin(String senha, String login);
	
	public abstract ArrayList<Consulta> agendaMedico(Medico medico);
	
	public abstract void cadastrarProcedimento(Procedimento novo);

	public abstract void removerProcedimento(String nome);
	
	public abstract ArrayList<Procedimento> retornarListaProcedimento();

	public abstract void verificarLogin(String login, String senha) throws NaoEncontradoException;

	public abstract void verificarLoginMedico(String login, String senha) throws NaoEncontradoException;

	public abstract void cadastrarConsulta(String cpfPaciente, String cpfMedico,
 String procedimento, String dia, String mes,
			String ano, String hora, String codigo)
			throws CodigoExistenteException, MedicoOcupadoException;

	public abstract void editarConsulta(String dia, String mes, String ano, String codigo, String hora);

	public abstract void removerConsulta(String codigo);
	
	public abstract ArrayList<Consulta> retornarListaConsulta();
	
}
