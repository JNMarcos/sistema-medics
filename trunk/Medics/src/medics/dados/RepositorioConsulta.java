/**
 * Essa classe representa o repositorio de agenda,
 * sendo o principal repositorio.
 * 
 * As saídas e entradas são feitas na GUI e comunicacao 
 * é feita através da camada de dados, são passadas infomações
 * para camadas de dados que dá as repostas para a GUI. Para 
 * isso códigos de comunição são usados.
 * 
 */

package medics.dados;

import java.util.Date;

import medics.negocio.classes_basicas.Consulta;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.classes_basicas.Procedimento;
import medics.negocio.CadastroConsulta;

public class RepositorioConsulta implements IRepositorioConsulta {
	private int contador = 0;
	Consulta[] lista;
	public static CadastroConsulta cadastroConsulta = new CadastroConsulta();

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public void criarLista() {
		lista = new Consulta[10];
	}

	public Consulta[] getLista() {
		return lista;
	}

	public void setLista(Consulta[] lista) {
		this.lista = lista;
	}

	public void aumentarArray() {
		Consulta[] auxiliar;
		auxiliar = new Consulta[lista.length];

		for (int i = 0; i < lista.length; i++) {
			auxiliar[i] = lista[i];
		}
		lista = new Consulta[auxiliar.length * 2];

		for (int i = 0; i < auxiliar.length; i++) {
			lista[i] = auxiliar[i];
		}
	}

	public void cadastrar(boolean primeiraVez, Paciente[] listaPaciente,
			Medico[] listaMedico, Procedimento[] listaProcedimento,
			int contadorPaciente, int contadorMedico, int contadorProcedimento,
			String paciente, String medico, String procedimento, Date data,
			String hora) {

		Consulta consulta = new Consulta();
		boolean achou = false;

		if (listaPaciente != null && listaPaciente[0] != null) {

			for (int i = 0; i <= contadorPaciente && achou == false; i++) {
				if (paciente.equals(listaPaciente[i].getNome())) {
					consulta.setPaciente(listaPaciente[i]);
					achou = true;
				}
			}
			if (achou == false) {

			}
		} else {
			Paciente auxPaciente = new Paciente();
			auxPaciente.setNome(""); // para exibir o vazio em paciente na
										// agenda
			consulta.setPaciente(auxPaciente);
		}

		if (listaMedico != null && listaMedico[0] != null) {
			achou = false;
			for (int i = 0; i <= contadorMedico && achou == false; i++) {
				if (medico.equals(listaMedico[i].getNome())) {
					consulta.setMedico(listaMedico[i]);
					achou = true;
				}
			}
			if (achou == false) {

			}
		} else {
			Medico auxMedico = new Medico();
			auxMedico.setNome(""); // para exibir o vazio em medico na agenda
			consulta.setMedico(auxMedico);
		}

		if (listaProcedimento != null && listaProcedimento[0] != null) {

			achou = false;
			for (int i = 0; i <= contadorProcedimento && achou == false; i++) {
				if (procedimento.equals(listaProcedimento[i].getNome())) {
					consulta.setProcedimento(listaProcedimento[i]);
					achou = true;
				}
			}
			if (achou == false) {

			}
		} else {
			Procedimento auxProcedimento = new Procedimento();
			auxProcedimento.setNome(""); // para exibir o vazio em medico na
											// agenda
			consulta.setProcedimento(auxProcedimento);
		}

		consulta.setData(data);
		consulta.setHora(hora);

		if (primeiraVez == true) {
			lista[0] = consulta;
		} else {
			contador++;
			lista[contador] = consulta;
		}
	}

	public void modificar(Date data, String hora, String medico, String opt,
			String novo) {
		if (lista != null && lista[0] != null) {
			boolean achou = false;
			int indicePesquisa;

			for (indicePesquisa = 0; indicePesquisa <= contador
					&& achou == false; indicePesquisa++) {
				if (hora.equals(lista[indicePesquisa].getHora())
						&& data.equals(lista[indicePesquisa].getData())
						&& medico.equals(lista[indicePesquisa].getMedico()
								.getNome())) {
					achou = true;
				}
			}

			if (achou == true) {

				switch (opt) {

				case "2":
					lista[indicePesquisa - 1].setHora(novo);
					break;
				case "3":
					RepositorioMedico repositorioMedico = new RepositorioMedico();
					Medico[] listaMedico = repositorioMedico.getLista();
					achou = false;
					for (int i = 0; i < repositorioMedico.getLista().length
							&& achou == false; i++) {
						if (medico.equals(listaMedico[i].getNome())) {
							lista[indicePesquisa - 1].setMedico(listaMedico[i]);
							achou = true;
						}
					}
					if (achou == false) {

					}
					break;
				case "4":
					RepositorioPaciente repositorioPaciente = new RepositorioPaciente();
					Paciente[] listaPaciente = repositorioPaciente.getLista();
					achou = false;
					for (int i = 0; i < repositorioPaciente.getLista().length
							&& achou == false; i++) {
						if (novo.equals(listaPaciente[i].getNome())) {
							lista[indicePesquisa - 1]
									.setPaciente(listaPaciente[i]);
							achou = true;
						}
					}
					if (achou == false) {

					}
					break;
				case "5":
					RepositorioProcedimento repositorioProcedimento = new RepositorioProcedimento();
					Procedimento[] listaProcedimento = repositorioProcedimento
							.getLista();
					achou = false;
					for (int i = 0; i < repositorioProcedimento.getLista().length
							&& achou == false; i++) {
						if (novo.equals(listaProcedimento[i].getNome())) {
							lista[indicePesquisa - 1]
									.setProcedimento(listaProcedimento[i]);
							achou = true;
						}
					}

					if (achou == false) {

					}
					break;
				}
			}
		} else {

		}

	}

	public void exibir() {
		if (lista != null && lista[0] != null) {
		//	cadastroConsulta.exibirListaProcedimentoAgenda(lista, contador);
		} else {
			//cadastroConsulta.saidaParaRepositorioAgenda(12);
		}

	}

	public void remover(Date data, String hora) {
		if (lista != null && lista[0] != null) {

			boolean achou = false;
			int i;

			for (i = 0; i <= contador && achou == false; i++) {
				if (data.equals(lista[i].getData())
						&& hora.equals(lista[i].getHora())) {
					achou = true;
				}
			}

			if (achou == true) {
				lista[i] = lista[contador];
				lista[contador] = null;
			} else {

			}
		}
	}
}
