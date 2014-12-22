package medics.dados;

import java.util.ArrayList;
import java.util.Date;

import medics.negocio.classes_basicas.Consulta;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.exceptions.CodigoExistenteException;
import medics.negocio.exceptions.MedicoOcupadoException;

public interface IRepositorioConsulta {

	public abstract void criarLista();

	public abstract ArrayList<Consulta> getLista();

	public abstract void setLista(ArrayList<Consulta> lista);

	public abstract void cadastrar(String cpfPaciente, String cpfMedico,
			String procedimento, String dia, String mes, String ano, String hora, String codigo) throws CodigoExistenteException, MedicoOcupadoException;
	
	public abstract void modificar(String dia, String mes, String ano, String codigo, String hora);

	public abstract void remover(String codigo);
	
	public abstract ArrayList<Consulta> agendaMedico(Medico medico);
	
	public abstract boolean pesquisarHoraOcupada( String cpfMedico,
			String procedimento, String dia, String mes, String ano,
			String hora);

}
