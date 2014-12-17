/**
 * Essa classe representa o repositorio de procedimentos
 * 
 * As saídas e entradas são feitas na GUI e comunicacao 
 * é feita através da camada de dados, são passadas infomações
 * para camadas de dados que dá as repostas para a GUI. Para 
 * isso códigos de comunição são usados.
 * 
 * Tabela de códigos:
 * @codigo 1 - Digite o nome do procedimento-
 * @codigo 2 - Novo nome- 
 * @codigo 3 - "Procedimento não encontrado."
 * @codigo 4 - "Não existe procedimentos."
 * @codigo 5 - "Lista vazia"
 * @codigo 6 - "Nome para remoção".
 * @codigo 7 - "Removido com sucesso."
 * @codigo 8 - "Procedimento não encontrado !"
 */

package medics.dados;

import medics.negocio.classes_basicas.Procedimento;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.NaoEncontradoException;
import medics.negocio.CadastroProcedimento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RepositorioProcedimento implements IRepositorioProcedimento {
	ArrayList<Procedimento> lista;
	public static CadastroProcedimento cadastroProcedimento = new CadastroProcedimento();
	
	private static RepositorioProcedimento instance;

    public static IRepositorioProcedimento getInstance() {
        if (instance == null) {
            instance = lerDoArquivo();
        }
        return instance;
    }

    private static RepositorioProcedimento lerDoArquivo() {
        RepositorioProcedimento instanciaLocal = null;

        File in = new File("repositorioProcedimento.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioProcedimento) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioProcedimento();
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
        File out = new File("repositorioProcedimento.dat");
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
		lista = new ArrayList<Procedimento>();
	}

	public ArrayList<Procedimento> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Procedimento> lista) {
		this.lista = lista;
	}

	public void cadastrar(Procedimento procedimento) {
           lista.add(procedimento);
	}

	public void modificar(String nomeProcurado, String novoNome)
			throws ArrayVazioException, NaoEncontradoException {
		boolean achou = false;
		try {
			// codigo 1 é enviado para GUI
			int indicePesquisa;

			for (indicePesquisa = 0; indicePesquisa <= lista.size()
					&& achou == false; indicePesquisa++) {
				String nomeDoArray = lista.get(indicePesquisa).getNome();
				if (nomeProcurado.equals(nomeDoArray)) {
					achou = true;
				}
			}

			if (achou == true) {
				lista.get(indicePesquisa - 1).setNome(novoNome);
				salvarArquivo();
			} else {
			}
		} catch (NullPointerException e) {
			throw new ArrayVazioException();
		}
		if (achou == false) {
			throw new NaoEncontradoException();
		}
	}

	public void exibir() {
		if (lista != null && lista.get(0) != null) {
			// cadastroProcedimento.exibirListaProcedimento(lista, contador);
		} else {
			// cadastroProcedimento.saidaParaRepositorio(5);
		}
	}

	public void remover(String nome) throws ArrayVazioException, NaoEncontradoException {
       int i;
       boolean removeu = false;

		try {

			for (i = 0; i <= lista.size() && removeu == true; i++) {
				String auxiliarNome = lista.get(i).getNome();

				if (nome.equals(auxiliarNome)) {
				    lista.remove(i); 
					removeu = true;
					salvarArquivo();
				}
			}

		} catch (NullPointerException e) {
			throw new ArrayVazioException();
		}if(removeu == false){
			throw new NaoEncontradoException();
		}
	}

}
