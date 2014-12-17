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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import medics.negocio.classes_basicas.Consulta;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.classes_basicas.Procedimento;
import medics.negocio.CadastroConsulta;

import java.util.ArrayList;

public class RepositorioConsulta implements IRepositorioConsulta {
	ArrayList<Consulta> lista;
	public static CadastroConsulta cadastroConsulta = new CadastroConsulta();

	private static RepositorioConsulta instance;

	public static IRepositorioConsulta getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	private static RepositorioConsulta lerDoArquivo() {
		RepositorioConsulta instanciaLocal = null;

		File in = new File("repositorioConsulta.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioConsulta) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioConsulta();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {/* Silent exception */
				}
			}
		}

		return instanciaLocal;
	}

	public static void salvarArquivo() {
		if (instance == null) {
			return;
		}
		File out = new File("repositorioConsulta.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {/* Silent */
				}
			}
		}
	}

	public void criarLista() {
		lista = new ArrayList<Consulta>();
	}

	public ArrayList<Consulta> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Consulta> lista) {
		this.lista = lista;
	}

	public void cadastrar(String primeiroNomePaciente,
			String segundoNomePaciente, String primeiroNomeMedico,
			String segundoNomeMedico, String procedimento, Date data, int hora,
			int minuto) {

		IRepositorioPaciente repositorioPaciente = RepositorioPaciente
				.getInstance();
		IRepositorioMedico repositorioMedico = new RepositorioMedico();
		IRepositorioProcedimento repositorioProcedimento = new RepositorioProcedimento();
		ArrayList<Paciente> listaPaciente = repositorioPaciente.getLista();
		ArrayList<Medico> listaMedico = repositorioMedico.getLista();
		ArrayList<Procedimento> listaProcedimento = repositorioProcedimento
				.getLista();

		Consulta consulta = new Consulta();
		boolean achou = false;

		if (listaPaciente != null && listaPaciente.get(0) != null) {

			for (int i = 0; i <= listaPaciente.size() && achou == false; i++) {
				if (primeiroNomePaciente.equals(listaPaciente.get(i)
						.getPrimeiroNome())
						&& segundoNomePaciente.equals(listaPaciente.get(i)
								.getSegundoNome())) {
					consulta.setPaciente(listaPaciente.get(i));
					achou = true;
				}
			}
			if (achou == false) {

			}
		} else {
			Paciente auxPaciente = new Paciente();
			auxPaciente.setPrimeiroNome("");
			auxPaciente.setSegundoNome("");// para exibir o vazio em paciente
											// na
			// agenda
			consulta.setPaciente(auxPaciente);
		}

		if (listaMedico != null && listaMedico.get(0) != null) {
			achou = false;
			for (int i = 0; i <= listaMedico.size() && achou == false; i++) {
				if (primeiroNomeMedico.equals(listaMedico.get(i)
						.getPrimeiroNome())
						&& segundoNomeMedico.equals(listaMedico.get(i)
								.getSegundoNome())) {
					consulta.setMedico(listaMedico.get(i));
					achou = true;
				}
			}
			if (achou == false) {

			}
		} else {
			Medico auxMedico = new Medico();
			auxMedico.setPrimeiroNome(""); // para exibir o vazio em medico na
											// agenda
			auxMedico.setSegundoNome("");
			consulta.setMedico(auxMedico);
		}

		if (listaProcedimento != null && listaProcedimento.get(0) != null) {

			achou = false;
			for (int i = 0; i <= listaProcedimento.size() && achou == false; i++) {
				if (procedimento.equals(listaProcedimento.get(i).getNome())) {
					consulta.setProcedimento(listaProcedimento.get(i));
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
		consulta.setMinuto(minuto);

		lista.add(consulta);
	}

	public void modificar(Date data, int hora, int minuto,
			String primeiroNomeMedico, String segundoNomeMedico, String opt,
			String novo) {
		if (lista != null && lista.get(0) != null) {
			boolean achou = false;
			int indicePesquisa;

			for (indicePesquisa = 0; indicePesquisa <= lista.size()
					&& achou == false; indicePesquisa++) {
				if (hora == lista.get(indicePesquisa).getHora()
						&& minuto == lista.get(indicePesquisa).getMinuto()
						&& data.equals(lista.get(indicePesquisa).getData())
						&& primeiroNomeMedico.equals(lista.get(indicePesquisa)
								.getMedico().getPrimeiroNome())
						&& segundoNomeMedico.equals(lista.get(indicePesquisa)
								.getMedico().getSegundoNome())) {
					achou = true;
				}
			}

			if (achou == true) {

				switch (opt) {

				case "3":
					RepositorioMedico repositorioMedico = new RepositorioMedico();
					ArrayList<Medico> listaMedico = repositorioMedico
							.getLista();
					achou = false;
					for (int i = 0; i < repositorioMedico.getLista().size()
							&& achou == false; i++) {
						if (primeiroNomeMedico.equals(listaMedico.get(i)
								.getPrimeiroNome())
								&& segundoNomeMedico.equals(listaMedico.get(i)
										.getSegundoNome())) {
							lista.get(indicePesquisa - 1).setMedico(
									listaMedico.get(i));
							achou = true;
						}
					}
					if (achou == false) {

					}
					break;
				case "4":
					RepositorioPaciente repositorioPaciente = new RepositorioPaciente();
					ArrayList<Paciente> listaPaciente = repositorioPaciente
							.getLista();
					achou = false;
					for (int i = 0; i < repositorioPaciente.getLista().size()
							&& achou == false; i++) {
						if (novo.equals(listaPaciente.get(i).getPrimeiroNome())) {
							lista.get(indicePesquisa - 1).setPaciente(
									listaPaciente.get(i));
							achou = true;
						}
					}
					if (achou == false) {

					}
					break;
				case "5":
					RepositorioProcedimento repositorioProcedimento = new RepositorioProcedimento();
					ArrayList<Procedimento> listaProcedimento = repositorioProcedimento
							.getLista();
					achou = false;
					for (int i = 0; i < repositorioProcedimento.getLista()
							.size() && achou == false; i++) {
						if (novo.equals(listaProcedimento.get(i).getNome())) {
							lista.get(indicePesquisa - 1).setProcedimento(
									listaProcedimento.get(i));
							achou = true;
						}
					}

					if (achou == false) {

					}
					break;
				}
			}
			salvarArquivo();
		} else {

		}

	}

	public void modificarData(Date data, int hora, int minuto, String primeiroNomeMedico,
			String segundoNomeMedico, Date novaData) {
		int indicePesquisa;
		boolean achou = false;
		for (indicePesquisa = 0; indicePesquisa <= lista.size()
				&& achou == true; indicePesquisa++) {
			if (hora == lista.get(indicePesquisa).getHora()
					&& minuto == lista.get(indicePesquisa).getMinuto()
					&& data.equals(lista.get(indicePesquisa).getData())
					&& primeiroNomeMedico.equals(lista.get(indicePesquisa)
							.getMedico().getPrimeiroNome())
					&& segundoNomeMedico.equals(lista.get(indicePesquisa)
							.getMedico().getSegundoNome())) {
				achou = true;
			}
		}

		if (achou == true) {
			lista.get(indicePesquisa - 1).setData(novaData);
		}
	}

	public void modificaHora(Date data, int hora, int minuto,
			String primeiroNomeMedico, String segundoNomeMedico, int novaHora, int novoMinuto){
		int indicePesquisa;
		boolean achou = false;
		for (indicePesquisa = 0; indicePesquisa <= lista.size()
				&& achou == true; indicePesquisa++) {
			if (hora == lista.get(indicePesquisa).getHora()
					&& minuto == lista.get(indicePesquisa).getMinuto()
					&& data.equals(lista.get(indicePesquisa).getData())
					&& primeiroNomeMedico.equals(lista.get(indicePesquisa)
							.getMedico().getPrimeiroNome())
					&& segundoNomeMedico.equals(lista.get(indicePesquisa)
							.getMedico().getSegundoNome())) {
				achou = true;
			}
		}

		if (achou == true) {
			lista.get(indicePesquisa - 1).setHora(novaHora);
			lista.get(indicePesquisa - 1).setMinuto(novoMinuto);
		}
	}

	public void exibir() {
		if (lista != null && lista.get(0) != null) {
			// cadastroConsulta.exibirListaProcedimentoAgenda(lista, contador);
		} else {
			// cadastroConsulta.saidaParaRepositorioAgenda(12);
		}

	}

	public void remover(Date data, String hora) {
		if (lista != null && lista.get(0) != null) {

			boolean removeu = false;
			int i;

			for (i = 0; i <= lista.size() && removeu == true; i++) {
				if (data.equals(lista.get(i).getData())
						&& hora.equals(lista.get(i).getHora())) {
					lista.remove(i);
					removeu = true;
					salvarArquivo();
				}
			}

		}
	}

	@Override
	public void modificarHora(Date data, int hora, int minuto,
			String primeiroNomeMedico, String segundoNomeMedico, int novaHora,
			int novoMinuto) {
		// TODO Auto-generated method stub
		
	}

}
