/**
 * Essa classe representa o repositorio de medicos.
 * 
 * As saídas e entradas são feitas na GUI e comunicacao 
 * é feita através da camada de dados, são passadas infomações
 * para camadas de dados que dá as repostas para a GUI. Para 
 * isso códigos de comunição são usados.
 * 
 * Tabela de códigos:
 * @codigo 1 - "Digite o nome do paciente-"
 * @codigo 2 - "O que deseja editar ?"
 * @codigo 3 - "Novo nome- " 
 * @codigo 4 - "Novo CPF- "
 * @codigo 5 - "Novo bairro- "
 * @codigo 6 - "Nova especialidade- "
 * @codigo 7 - "Novo telefone- "
 * @codigo 8 - "Medico não encontrado."
 * @codigo 9 - "Não existe medicos."
 * @codigo 10 - "Lista vazia."
 * @codigo 11 - "Nome para remoção"
 * @codigo 12 - "Removido com sucesso."
 * @codigo 13 - "Medico não encontrado !"
 */

package medics.dados;

import medics.negocio.classes_basicas.Medico;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.NaoEncontradoException;
import medics.negocio.CadastroMedico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RepositorioMedico implements IRepositorioMedico {
	ArrayList<Medico> lista;
	public static CadastroMedico cadastroMedico = new CadastroMedico();
	
	private static RepositorioMedico instance;

    public static IRepositorioMedico getInstance() {
        if (instance == null) {
            instance = lerDoArquivo();
        }
        return instance;
    }

    private static RepositorioMedico lerDoArquivo() {
        RepositorioMedico instanciaLocal = null;

        File in = new File("repositorioMedico.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioMedico) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioMedico();
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
        File out = new File("repositorioMedico.dat");
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
                try { oos.close(); } catch (IOException e) {/*Silent*/}
            }
        }
    }

	public void criarLista() {
		lista = new ArrayList<Medico>();
	}

	public ArrayList<Medico> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Medico> lista) {
		this.lista = lista;
	}

	public void cadastrar(Medico medico) {
		lista.add(medico);
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

				case "2":
					lista.get(indicePesquisa - 1).setCpf(novo);
					break;
				case "3":
					lista.get(indicePesquisa - 1).setBairro(novo);
					break;
				case "4":
					lista.get(indicePesquisa - 1).setCidade(novo);
					break;
				case "5":
					lista.get(indicePesquisa - 1).setEspecialidade(novo);
					break;
				case "6":
					lista.get(indicePesquisa - 1).setSenha(novo);
					break;
				}
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
		 * cadastroMedico.exibirListaProcedimentoMedico(lista, contador); } else
		 * { cadastroMedico.saidaParaRepositorioMedico(10); }
		 */
	}

	public void remover(String primeiroNome, String segundoNome)
			throws ArrayVazioException, NaoEncontradoException {
		int i;
		boolean removeu = false;
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

	public void verificarLogin(String login, String senha) throws NaoEncontradoException {
        boolean achou = false;
        try{
		for (int i = 0; i < lista.size(); i++) {
			if (login.equals(lista.get(i).getLogin())
					&& senha.equals(lista.get(i).getSenha()))
				achou = true;
		}
		
		if(achou == false)
			 throw new NaoEncontradoException();
        }catch(NullPointerException e1){
			 throw new NaoEncontradoException();
        }
	}

}
