/**
 * Essa classe representa o repositorio de pacientes
 * 
 * As saídas e entradas são feitas na GUI e comunicacao 
 * é feita através da camada de dados, são passadas infomações
 * para camadas de dados que dá as repostas para a GUI. Para 
 * isso códigos de comunição são usados.
 * 
 * Tabela de códigos:
 * @codigo 1 - "Digite o nome do medico-"
 * @codigo 2 - "O que deseja editar ?"
 * @codigo 3 - "Novo nome- " 
 * @codigo 4 - "Novo CPF- "
 * @codigo 5 - "Novo data nascimento- "
 * @codigo 6 - "Novo bairro- "
 * @codigo 7 - "Novo telefone- "
 * @codigo 8 - "Novo email- "
 * @codigo 9 - "Paciente não encontrado."
 * @codigo 10 - "Não existe pacientes."
 * @codigo 11 - "Lista vazia."
 * @codigo 12 - "Nome para remoção"
 * @codigo 13 - "Removido com sucesso."
 * @codigo 14 - "Paciente não encontrado !"
 */

package medics.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import medics.negocio.classes_basicas.Paciente;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.CpfExistenteException;
import medics.negocio.exceptions.NaoEncontradoException;
import medics.negocio.CadastroPaciente;

public class RepositorioPaciente implements IRepositorioPaciente {
	ArrayList<Paciente> lista;
	public static CadastroPaciente cadastroPaciente = new CadastroPaciente();

	private static RepositorioPaciente instance;

	public static IRepositorioPaciente getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	private static RepositorioPaciente lerDoArquivo() {
		RepositorioPaciente instanciaLocal = null;

		File in = new File("repositorioPaciente.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioPaciente) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioPaciente();
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
		File out = new File("repositorioPaciente.dat");
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
		lista = new ArrayList<Paciente>();
	}

	public ArrayList<Paciente> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Paciente> lista) {
		this.lista = lista;
	}

	public void cadastrar(Paciente paciente) throws CpfExistenteException {
        if(lista == null)
        	criarLista();
		if (!procurarCpf(paciente.getCpf())) {
			lista.add(paciente);
		} else {
			throw new CpfExistenteException();
		}

	}

	public void modificar(String primeiroNome, String segundoNome, String opt,
			String novo) throws ArrayVazioException, NaoEncontradoException {
		boolean achou = false;
		try {

			int indicePesquisa;

			for (indicePesquisa = 0; indicePesquisa <= lista.size()
					&& achou == false; indicePesquisa++) {

				if (primeiroNome.equals(lista.get(indicePesquisa)
						.getPrimeiroNome())
						&& segundoNome.equals(lista.get(indicePesquisa)
								.getSegundoNome())) {
					achou = true;
				}
			}

			if (achou == true) {

				switch (opt) {

				case "1":
					lista.get(indicePesquisa - 1).setRua(novo);

					break;
				case "2":
					lista.get(indicePesquisa - 1).setBairro(novo);
					break;
				case "3":
					lista.get(indicePesquisa - 1).setCidade(novo);
					break;
				case "4":
					lista.get(indicePesquisa - 1).setTelefone(novo);
					break;
				case "5":
					lista.get(indicePesquisa - 1).setEmail(novo);
					break;
				}
				salvarArquivo();
			}
		} catch (NullPointerException e) {
			throw new ArrayVazioException();

		}
		if (achou == false) {
			throw new NaoEncontradoException();
		}

	}

	public void exibir() {
		/*
		 * if (lista != null && lista[0] != null) {
		 * cadastroPaciente.exibirListaProcedimentoPaciente(lista, contador); }
		 * else { cadastroPaciente.saidaParaRepositorioPaciente(11); }
		 */
	}

	public void remover(String primeiroNome, String segundoNome)
			throws ArrayVazioException, NaoEncontradoException {
		boolean removeu = false;
		int i;
		try {

			for (i = 0; i <= lista.size() && removeu == true; i++) {

				if (primeiroNome.equals(lista.get(i).getPrimeiroNome())
						&& segundoNome.equals(lista.get(i).getSegundoNome())) {
					lista.remove(i);
					removeu = true;
					salvarArquivo();
				}
			}

		} catch (NullPointerException e) {
			throw new ArrayVazioException();
		}
		if (i == lista.size()) {
			throw new NaoEncontradoException();
		}
	}

	public boolean procurarCpf(String cpf) {
		boolean achou = false;
		if (lista != null) {
			for (int i = 0; i < lista.size() && achou == true; i++) {
				if (cpf.equals(lista.get(i).getCpf()))
					achou = true;
			}
		}
		return achou;
	}

}
