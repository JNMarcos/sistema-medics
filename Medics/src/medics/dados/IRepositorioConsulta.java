package medics.dados;

import java.util.ArrayList;
import java.util.Date;

import medics.negocio.classes_basicas.Consulta;

public interface IRepositorioConsulta {

	public abstract void criarLista();

	public abstract ArrayList<Consulta> getLista();

	public abstract void setLista(ArrayList<Consulta> lista);

	public abstract void cadastrar(String primeiroNomePaciente,
			String segundoNomePaciente, String primeiroNomeMedico,
			String segundoNomeMedico, String procedimento, Date data, int hora,
			int minuto);

	public abstract void modificarData(Date data, int hora, int minuto,
			String primeiroNomeMedico, String segundoNomeMedico, Date novaData);

	public abstract void modificarHora(Date data, int hora, int minuto,
			String primeiroNomeMedico, String segundoNomeMedico, int novaHora, int novoMinuto);

	public abstract void exibir();

	public abstract void remover(Date data, String hora);

}
