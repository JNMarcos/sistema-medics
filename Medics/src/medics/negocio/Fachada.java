package medics.negocio;

import java.util.ArrayList;
import java.util.Date;

import medics.negocio.classes_basicas.Consulta;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.classes_basicas.Procedimento;
import medics.negocio.classes_basicas.Secretario;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.CodigoExistenteException;
import medics.negocio.exceptions.CpfExistenteException;
import medics.negocio.exceptions.LoginExistenteException;
import medics.negocio.exceptions.MedicoOcupadoException;
import medics.negocio.exceptions.NaoEncontradoException;
import medics.negocio.exceptions.SenhaExistenteException;

public class Fachada implements IFachada {
	CadastroPaciente cadastroPaciente = new CadastroPaciente();
	CadastroMedico cadastroMedico = new CadastroMedico();
	CadastroProcedimento cadastroProcedimento = new CadastroProcedimento();
	CadastroConsulta cadastroConsulta = new CadastroConsulta();

	private static IFachada instance;

	private Fachada() {
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

	public void cadastrarPaciente(Paciente paciente)
			throws CpfExistenteException {
		cadastroPaciente.cadastrar(paciente);
	}

	public void removerPaciente(String cpf) {
		cadastroPaciente.remover(cpf);
	}

	public void salvarPaciente() {
		cadastroPaciente.salvar();
	}

	public ArrayList<Paciente> retornarListaPaciente() {
		return cadastroPaciente.getList();
	}

	public Paciente exibirPaciente(String cpf) {
		return cadastroPaciente.exibir(cpf);
	}

	public void cadastrarMedico(Medico medico) throws CpfExistenteException,
			LoginExistenteException, SenhaExistenteException {
		cadastroMedico.cadastrar(medico);
	}

	public void removerMedico(String cpf) {
		cadastroMedico.remover(cpf);
	}

	public void salvarMedico() {
		cadastroMedico.salvar();
	}

	public ArrayList<Medico> retornarListaMedico() {
		return cadastroMedico.getList();
	}

	public Medico exibirMedico(String cpf) {
		return cadastroMedico.exibir(cpf);
	}

	public Medico exibirMedicoPorLogin(String senha, String login) {
		return cadastroMedico.exibirPorLogin(senha, login);
	}

	public ArrayList<Consulta> agendaMedico(Medico medico) {
		return cadastroConsulta.agenda(medico);
	}

	public void cadastrarProcedimento(Procedimento novo) {
		cadastroProcedimento.cadastrar(novo);
	}

	public void removerProcedimento(String nome) {
		cadastroProcedimento.remover(nome);
	}

	public void salvarProcedimento() {
		cadastroProcedimento.salvar();
	}

	public ArrayList<Procedimento> retornarListaProcedimento() {
		return cadastroProcedimento.getList();
	}

	public void verificarLogin(String login, String senha)
			throws NaoEncontradoException {
		Secretario secretario = Secretario.getInstance();
		secretario.verificarLogin(login, senha);

	}

	public Medico verificarLoginMedico(String login, String senha)
			throws NaoEncontradoException {
		return cadastroMedico.verificarLogin(login, senha);
	}

	public void cadastrarConsulta(String cpfPaciente, String cpfMedico,
			String procedimento, String dia, String mes, String ano,
			String hora, String codigo) throws CodigoExistenteException, MedicoOcupadoException {
		cadastroConsulta.cadastrar(cpfPaciente, cpfMedico, procedimento, dia,
				mes, ano, hora, codigo);

	}

	public void editarConsulta(String dia, String mes, String ano,
			String codigo, String hora) {
		cadastroConsulta.modificar(dia, mes, ano, codigo, hora);
	}

	public void removerConsulta(String codigo) {
		cadastroConsulta.remover(codigo);
	}

	public void salvarConsulta() {
		cadastroConsulta.salvar();
	}

	public ArrayList<Consulta> retornarListaConsulta() {
		return cadastroConsulta.getList();
	}

}
