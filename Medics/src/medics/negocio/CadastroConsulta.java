package medics.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import medics.dados.IRepositorioConsulta;
import medics.dados.RepositorioConsulta;
import medics.negocio.classes_basicas.Consulta;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.exceptions.CodigoExistenteException;
import medics.negocio.exceptions.MedicoOcupadoException;

public class CadastroConsulta {

	Scanner input = new Scanner(System.in);
	private IRepositorioConsulta repositorio;

	public CadastroConsulta() {
		this.repositorio = RepositorioConsulta.getInstance();
	}

	public void cadastrar(String cpfPaciente, String cpfMedico,
			String procedimento, String dia, String mes, String ano,
			String hora, String codigo) throws CodigoExistenteException, MedicoOcupadoException {

		repositorio.cadastrar(cpfPaciente, cpfMedico, procedimento, dia, mes,
				ano, hora, codigo);

	}

	public void modificar(String dia, String mes, String ano, String codigo,
			String hora) {
		repositorio.modificar(dia, mes, ano, codigo, hora);

	}

	public void remover(String codigo) {
		repositorio.remover(codigo);
	}

	public void salvar() {
		RepositorioConsulta.salvarArquivo();
	}

	public ArrayList<Consulta> getList() {
		return repositorio.getLista();
	}

	public ArrayList<Consulta> agenda(Medico medico) {
		return repositorio.agendaMedico(medico);
	}

}
