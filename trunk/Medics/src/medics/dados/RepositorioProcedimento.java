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
import medics.negocio.CadastroProcedimento;

public class RepositorioProcedimento implements IRepositorioProcedimento {
	private int contador = 0;
	Procedimento[] lista;
	public static CadastroProcedimento cadastroProcedimento = new CadastroProcedimento();

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public void criarLista() {
		lista = new Procedimento[10];
	}

	public Procedimento[] getLista() {
		return lista;
	}

	public void setLista(Procedimento[] lista) {
		this.lista = lista;
	}

	public void aumentarArray() {
		Procedimento[] auxiliar;
		auxiliar = new Procedimento[lista.length];

		for (int i = 0; i < lista.length; i++) {
			auxiliar[i] = lista[i];
		}
		lista = new Procedimento[auxiliar.length * 2];

		for (int i = 0; i < auxiliar.length; i++) {
			lista[i] = auxiliar[i];
		}
	}

	public void cadastrar(boolean primeiraVez, Procedimento procedimento) {

		if (primeiraVez == true) {
			lista[0] = procedimento;
		} else {
			contador++;
			lista[contador] = procedimento;
		}
	}

	public void modificar(String nomeProcurado, String novoNome) {

		if (lista != null && lista[0] != null) {
			boolean achou = false; // codigo 1 é enviado para GUI
			int indicePesquisa;

			for (indicePesquisa = 0; indicePesquisa <= contador
					&& achou == false; indicePesquisa++) {
				String nomeDoArray = lista[indicePesquisa].getNome();
				if (nomeProcurado.equals(nomeDoArray)) {
					achou = true;
				}
			}

			if (achou == true) {
				lista[indicePesquisa - 1].setNome(novoNome);

			} else {
			}
		} else {
		}
	}

	public void exibir() {
		if (lista != null && lista[0] != null) {
			//cadastroProcedimento.exibirListaProcedimento(lista, contador);
		} else {
			//cadastroProcedimento.saidaParaRepositorio(5);
		}
	}

	public void remover(String nome) {

		if (lista != null && lista[0] != null) {

			boolean achou = false;
			int i;

			for (i = 0; i <= contador && achou == false; i++) {
				String auxiliarNome = lista[i].getNome();

				if (nome.equals(auxiliarNome)) {
					achou = true;
				}
			}

			if (achou == true) {
			} else {
			}
		}
	}

}

