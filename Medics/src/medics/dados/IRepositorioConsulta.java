package medics.dados;

import java.util.Date;
import medics.negocio.classes_basicas.Consulta;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.classes_basicas.Procedimento;

public interface IRepositorioConsulta {

	public abstract int getContador();

	public abstract void setContador(int contador);

	public abstract void criarLista();

	public abstract Consulta[] getLista();

	public abstract void setLista(Consulta[] lista);

	public abstract void aumentarArray();

	public abstract void cadastrar(boolean primeiraVez, Paciente[] listaPaciente,
			Medico[] listaMedico, Procedimento[] listaProcedimento,
			int contadorPaciente, int contadorMedico, int contadorProcedimento,
			String paciente, String medico, String procedimento, Date data,
			String hora);

	public abstract void modificar(Date data, String hora, String medico, String opt,
			String novo);

	public abstract void exibir();

	public abstract void remover(Date data, String hora);
}
