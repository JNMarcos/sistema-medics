package medics.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;

import medics.negocio.classes_basicas.Consulta;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.classes_basicas.Procedimento;
import medics.negocio.exceptions.CodigoExistenteException;
import medics.negocio.exceptions.MedicoOcupadoException;
import medics.negocio.CadastroConsulta;

import java.util.ArrayList;

public class RepositorioConsulta implements IRepositorioConsulta, Serializable {
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
		if (lista != null)
			Collections.sort(lista);
		return lista;
	}

	public void setLista(ArrayList<Consulta> lista) {
		this.lista = lista;
	}

	public void cadastrar(String cpfPaciente, String cpfMedico,
			String procedimento, String dia, String mes, String ano,
			String hora, String codigo) throws CodigoExistenteException,
			MedicoOcupadoException {

		if (!pesquisarHoraOcupada(cpfMedico, procedimento, dia, mes, ano, hora)) {

			IRepositorioPaciente repositorioPaciente = RepositorioPaciente
					.getInstance();
			IRepositorioMedico repositorioMedico = RepositorioMedico
					.getInstance();

			IRepositorioProcedimento repositorioProcedimento = RepositorioProcedimento
					.getInstance();

			ArrayList<Paciente> listaPaciente = repositorioPaciente.getLista();
			ArrayList<Medico> listaMedico = repositorioMedico.getLista();
			ArrayList<Procedimento> listaProcedimento = repositorioProcedimento
					.getLista();

			Consulta consulta = new Consulta();
			boolean achou = false;

			if (!procurarCodigo(codigo)) {

				for (int i = 0; i < listaPaciente.size() && achou == false; i++) {
					if (cpfPaciente.equals(listaPaciente.get(i).getCpf())) {
						consulta.setPaciente(listaPaciente.get(i));
						achou = true;
					}
				}

				achou = false;
				for (int i = 0; i < listaMedico.size() && achou == false; i++) {
					if (cpfMedico.equals(listaMedico.get(i).getCpf())) {
						consulta.setMedico(listaMedico.get(i));
						achou = true;
					}
				}

				achou = false;
				for (int i = 0; i < listaProcedimento.size() && achou == false; i++) {
					if (procedimento.equals(listaProcedimento.get(i).getNome())) {
						consulta.setProcedimento(listaProcedimento.get(i));
						achou = true;
					}
				}

				consulta.setDia(dia);
				consulta.setMes(mes);
				consulta.setAno(ano);
				consulta.setHora(hora);
				consulta.setCodigo(codigo);

				if (lista == null)
					criarLista();
				lista.add(consulta);
				salvarArquivo();
				
			} else {
				throw new CodigoExistenteException();
			}
		} else {
			throw new MedicoOcupadoException();
		}
	}

	public void modificar(String dia, String mes, String ano, String codigo,
			String hora) {
		boolean achou = false;
		int indicePesquisa;

		for (indicePesquisa = 0; indicePesquisa < lista.size()
				&& achou == false; indicePesquisa++) {
			if (codigo.equals(lista.get(indicePesquisa).getCodigo())) {
				lista.get(indicePesquisa).setDia(dia);
				lista.get(indicePesquisa).setDia(mes);
				lista.get(indicePesquisa).setDia(ano);
				lista.get(indicePesquisa).setDia(hora);
				achou = true;
			}
		}

		// salvarArquivo();

	}

	public void remover(String codigo) {
		if (lista != null && lista.get(0) != null) {

			boolean removeu = false;
			int i;

			for (i = 0; i <= lista.size() && removeu == false; i++) {
				if (codigo.equals(lista.get(i).getCodigo())) {
					lista.remove(i);
					removeu = true;
					// salvarArquivo();
				}
			}

		}
	}

	public ArrayList<Consulta> agendaMedico(Medico medico) {
		ArrayList<Consulta> agenda = new ArrayList<Consulta>();

		for (int i = 0; i < lista.size(); i++) {
			if (medico.equals(lista.get(i).getMedico()))
				agenda.add(lista.get(i));
		}

		return agenda;
	}

	public boolean procurarCodigo(String codigo) {
		boolean achou = false;
		if (lista != null) {
			for (int i = 0; i < lista.size() && achou == false; i++) {
				if (codigo.equals(lista.get(i).getCodigo()))
					achou = true;
			}
		}
		return achou;
	}

	public boolean pesquisarHoraOcupada(String cpfMedico, String procedimento,
			String dia, String mes, String ano, String hora) {
		boolean horaOcupada = false;

		if (lista != null) {
			for (int i = 0; i < lista.size() && horaOcupada == false; i++) {
				if (cpfMedico.equals(lista.get(i).getMedico().getCpf())) {
					if (ano.equals(lista.get(i).getAno())
							&& mes.equals(lista.get(i).getMes())
							&& dia.equals(lista.get(i).getDia())
							&& hora.equals(lista.get(i).getHora())) {
						horaOcupada = true;
					}
				}
			}
		}
		return horaOcupada;
	}

}
