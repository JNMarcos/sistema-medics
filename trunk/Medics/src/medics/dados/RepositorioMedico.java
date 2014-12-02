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
import medics.negocio.CadastroMedico;

public class RepositorioMedico implements IRepositorioMedico {
	private int contador;
	Medico[] lista;
	public static CadastroMedico cadastroMedico = new CadastroMedico();

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public void criarLista() {
		lista = new Medico[10];
	}

	public Medico[] getLista() {
		return lista;
	}

	public void setLista(Medico[] lista) {
		this.lista = lista;
	}

	public void aumentarArray() {
		Medico[] auxiliar;
		auxiliar = new Medico[lista.length];

		for (int i = 0; i < lista.length; i++) {
			auxiliar[i] = lista[i];
		}
		lista = new Medico[auxiliar.length * 2];

		for (int i = 0; i < auxiliar.length; i++) {
			lista[i] = auxiliar[i];
		}
	}

	public void cadastrar(boolean primeiraVez, Medico medico) {

		if (primeiraVez == true) {
			lista[0] = medico;
		} else {
			contador++;
			lista[contador] = medico;
		}
	}

	public void modificar(String nome, String opt, String novo) {
		if (lista != null && lista[0] != null) {
			boolean achou = false;
			int indicePesquisa;

			for (indicePesquisa = 0; indicePesquisa <= contador
					&& achou == false; indicePesquisa++) {
				String nomeDoArray = lista[indicePesquisa].getNome();
				if (nome.equals(nomeDoArray)) {
					achou = true;
				}
			}

			if (achou == true) {

				switch (opt) {
				case "1":
					lista[indicePesquisa - 1].setNome(novo);
					break;
				case "2":
					lista[indicePesquisa - 1].setCpf(novo);
					break;
				case "3":
					lista[indicePesquisa - 1].setBairro(novo);
					break;
				case "4":
					lista[indicePesquisa - 1].setCidade(novo);
					break;
				case "5":
					lista[indicePesquisa - 1].setEspecialidade(novo);
					break;
				case "6":
					lista[indicePesquisa - 1].setSenha(novo);
					break;
				}
			}
		}
	}

	public void exibir() {
		if (lista != null && lista[0] != null) {
		//	cadastroMedico.exibirListaProcedimentoMedico(lista, contador);
		} else {
			//cadastroMedico.saidaParaRepositorioMedico(10);
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
				lista[i] = lista[contador];
				lista[contador] = null;
			}
		}
	}

	public Medico verificarLogin(String login, String senha) {

		for (int i = 0; i < contador; i++) {
			if (login.equals(lista[i].getLogin())
					&& senha.equals(lista[i].getSenha()))
				return lista[i - 1];
		}

		return null;

	}

}
