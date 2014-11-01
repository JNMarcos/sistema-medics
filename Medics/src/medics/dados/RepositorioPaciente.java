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

import medics.negocio.classes_basicas.Paciente;
import medics.negocio.CadastroPaciente;

public class RepositorioPaciente {
	  private int contador = 0;
	  Paciente[] lista;
	  public static CadastroPaciente cadastroPaciente = new CadastroPaciente();
	  	 
	  public int getContador() {
		return contador;
	  }

	  public  void setContador(int contador) {
		this.contador = contador;
	  }

	  public void criarLista() {
	        lista = new Paciente[10];
	  }
	  
      public Paciente[] getLista() {
		return lista;
	  }

	  public void setLista(Paciente[] lista) {
		this.lista = lista;
	  }
	  
	  public void aumentarArray(){
	        Paciente[] auxiliar;
	        auxiliar = new Paciente[lista.length];
	        
	        for(int i = 0 ; i<lista.length ; i++){
	            auxiliar[i] = lista[i];
	        }
	        lista = new Paciente[auxiliar.length * 2];
	        
	        for(int i = 0; i<auxiliar.length ; i++){
	            lista[i] = auxiliar[i];
	        }
	    }
      
      public void cadastrar(boolean primeiraVez, Paciente paciente) {

          if(primeiraVez == true){
              lista[0] = paciente;
          }else{
             contador++;
             lista[contador] = paciente;
          }
      }
      
      public void modificar() {
    	  if(lista != null){
            boolean achou = false;
            String nomeProcurado = cadastroPaciente.entradaParaRepositorioPaciente(1);
            int indicePesquisa;
         
            for(indicePesquisa = 0 ; indicePesquisa <= contador && achou == false ; indicePesquisa++ ) {
                String nomeDoArray = lista[indicePesquisa].getNome();
                if (nomeProcurado.equals(nomeDoArray)){
                    achou = true; 
                }
            }
          
              if (achou == true) {
                String opt;
                
                opt = cadastroPaciente.entradaParaRepositorioPaciente(2);
                switch (opt) {
                    case "1":
                        String novoNome = cadastroPaciente.entradaParaRepositorioPaciente(3);
                        lista[indicePesquisa-1].setNome(novoNome);
                        break;
                    case "2":
                        String novoCpf = cadastroPaciente.entradaParaRepositorioPaciente(4);
                        lista[indicePesquisa-1].setCpf(novoCpf);
                        break;
                    case "3":
                        String novoData = cadastroPaciente.entradaParaRepositorioPaciente(5);
                        lista[indicePesquisa-1].setDataNascimento(novoData);;
                        break;
                    case "4":
                        String novoBairro = cadastroPaciente.entradaParaRepositorioPaciente(6);
                        lista[indicePesquisa-1].setBairro(novoBairro);
                        break;
                    case "5":
                        String novoTelefone = cadastroPaciente.entradaParaRepositorioPaciente(7);
                        lista[indicePesquisa-1].setTelefone(novoTelefone);
                        break;
                    case "6":
                        String novoEmail = cadastroPaciente.entradaParaRepositorioPaciente(8);
                        lista[indicePesquisa-1].setEmail(novoEmail);
                        break;
                }
            } else {
                cadastroPaciente.saidaParaRepositorioPaciente(9);
            }
    	  }else{
    		  cadastroPaciente.saidaParaRepositorioPaciente(10);
    	  }
      }
     
      public void exibir(){
    	  if(lista[0] != null){
    	     cadastroPaciente.exibirListaProcedimentoPaciente(lista, contador); //GUI imprimi lista
    	  }else{
    		  cadastroPaciente.saidaParaRepositorioPaciente(11);
    	  }
      }
      
      public void remover(){
         
    	  if(lista != null){
            String nome = cadastroPaciente.entradaParaRepositorioPaciente(12);
            boolean achou = false;
            int i;
          
            for(i = 0 ; i <= contador && achou == false ; i++){
               String auxiliarNome = lista[i].getNome();
              
               if(nome.equals(auxiliarNome)){
                   achou = true;
               }
            }
          
            if(achou == true){
        	    cadastroPaciente.saidaParaRepositorioPaciente(13);
                lista[i] = lista[contador];
                lista[contador] = null;
            }else{
        	    cadastroPaciente.saidaParaRepositorioPaciente(14);
            }
    	  }
      }
}

