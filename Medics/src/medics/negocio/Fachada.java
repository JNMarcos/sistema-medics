package medics.negocio;

import java.util.ArrayList;
import java.util.Date;

import medics.negocio.classes_basicas.Medico;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.classes_basicas.Secretario;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.CpfExistenteException;
import medics.negocio.exceptions.NaoEncontradoException;

public class Fachada implements IFachada {
	CadastroPaciente cadastroPaciente = new CadastroPaciente();
	CadastroMedico cadastroMedico = new CadastroMedico();
	CadastroProcedimento cadastroProcedimento = new CadastroProcedimento();
	CadastroConsulta cadastroConsulta = new CadastroConsulta();

	private static IFachada instance;
	
	private Fachada(){
		 // Construtor privado para evitar instanciação fora da classe
	}
	
	/**
	 * Implementando padrão Singleton
	 * 
	 * @return A instância da desta fachada
	 */
	public static IFachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

	public void cadastrarPaciente(Paciente paciente) throws CpfExistenteException {
		cadastroPaciente.cadastrar(paciente);
	}

	public void editarPaciente(String primeiroNome, String segundoNome,
			String opt, String novo) throws ArrayVazioException,
			NaoEncontradoException {

		cadastroPaciente.modificar(primeiroNome, segundoNome, opt, novo);

	}

	public void removerPaciente(String primeiroNome, String segundoNome)
			throws ArrayVazioException, NaoEncontradoException {
		cadastroPaciente.remover(primeiroNome, segundoNome);
	}
	
	public void salvarPaciente(){
		cadastroPaciente.salvar();
	}
	
	public ArrayList<Paciente> retornarListaPaciente(){
		return cadastroPaciente.getList();
	}

	public void cadastrarMedico(Medico medico) {
		cadastroMedico.cadastrar(medico);
	}

	public void editarMedico(String primeiroNome, String segundoNome,
			String opt, String novo) throws ArrayVazioException,
			NaoEncontradoException {
		cadastroMedico.modificar(primeiroNome, segundoNome, opt, novo);
	}

	public void removerMedico(String primeiroNome, String segundoNome)
			throws ArrayVazioException, NaoEncontradoException {
		cadastroPaciente.remover(primeiroNome, segundoNome);
	}
	
	public void salvarMedico(){
		cadastroMedico.salvar();
	}

	public void cadastrarProcedimento(String nome) {
		cadastroProcedimento.cadastrar(nome);
	}

	public void editarProcedimento(String nome, String novo)
			throws ArrayVazioException, NaoEncontradoException {
		cadastroProcedimento.modificar(nome, novo);
	}

	public void removerProcedimento(String nome) throws ArrayVazioException,
			NaoEncontradoException {
		cadastroProcedimento.remover(nome);
	}
	
	public void salvarProcedimento(){
		cadastroProcedimento.salvar();
	}

	public void verificarLogin(String login, String senha) throws NaoEncontradoException {
		Secretario secretario = new Secretario();
		secretario.verificarLogin(login, senha);

	}

	public void verificarLoginMedico(String login, String senha) throws NaoEncontradoException {
		cadastroMedico.verificarLogin(login, senha);
	}

	public void cadastrarConsuta(String primeiroNomePaciente,
			String segundoNomePaciente, String primeiroNomeMedico,
			String segundoNomeMedico, String procedimento, Date data,
			String hora) {
		/*cadastroConsulta
				.cadastrar(primeiroNomePaciente, segundoNomePaciente,
						primeiroNomeMedico, segundoNomeMedico, procedimento,
						data, hora);*/
	}

	public void editarConsulta(Date data, String hora,
			String primeiroNomeMedico, String segundoNomeMedico, String opt,
			String novo) {
		cadastroConsulta.modificar(data, hora, primeiroNomeMedico, segundoNomeMedico, opt, novo);
	}

	public void removerConsulta(Date data, String hora) {
		cadastroConsulta.remover(data, hora);
	}
	
	public void salvarConsulta(){
		cadastroConsulta.salvar();
	}

}
