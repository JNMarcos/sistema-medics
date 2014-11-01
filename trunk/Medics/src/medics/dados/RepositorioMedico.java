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

public class RepositorioMedico {
	  private int contador;
	  Medico[] lista = new Medico[10];
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
	  
	  public void aumentarArray(){
	        Medico[] auxiliar;
	        auxiliar = new Medico[lista.length];
	        
	        for(int i = 0 ; i<lista.length ; i++){
	            auxiliar[i] = lista[i];
	        }
	        lista = new Medico[auxiliar.length * 2];
	        
	        for(int i = 0; i<auxiliar.length ; i++){
	            lista[i] = auxiliar[i];
	        }
	    }
 
      
	  public void cadastrar(boolean primeiraVez, Medico medico) {    	

          if(primeiraVez == true){
              lista[0] = medico;
          }else{
             contador++;
             lista[contador] = medico;
          }
      }
	  
      public void modificar() {
    	  if(lista != null){
            boolean achou = false;
            String nomeProcurado = cadastroMedico.entradaParaRepositorioMedico(1);
            int indicePesquisa;
         
            for(indicePesquisa = 0 ; indicePesquisa <= contador && achou == false ; indicePesquisa++ ) {
                String nomeDoArray = lista[indicePesquisa].getNome();
                if (nomeProcurado.equals(nomeDoArray)){
                    achou = true; 
                }
            }
          
            if (achou == true) {
                String opt;
              
                opt = cadastroMedico.entradaParaRepositorioMedico(2);

                switch (opt) {
                    case "1":
                        String novoNome = cadastroMedico.entradaParaRepositorioMedico(3);
                        lista[indicePesquisa-1].setNome(novoNome);
                        break;
                    case "2":
                        String novoCpf = cadastroMedico.entradaParaRepositorioMedico(4);
                        lista[indicePesquisa-1].setCpf(novoCpf);
                        break;
                    case "3":
                        String novoBairro = cadastroMedico.entradaParaRepositorioMedico(5);
                        lista[indicePesquisa-1].setBairro(novoBairro);;
                        break;
                    case "4":
                        String novaCidade =cadastroMedico.entradaParaRepositorioMedico(6);
                        lista[indicePesquisa-1].setCidade(novaCidade);
                        break;
                    case "5":
                        String novaEspecialidade = cadastroMedico.entradaParaRepositorioMedico(7);
                        lista[indicePesquisa-1].setEspecialidade(novaEspecialidade);
                        break;
                }
            }else {
                cadastroMedico.saidaParaRepositorioMedico(8);
            }
    	    }else{
    	    	cadastroMedico.saidaParaRepositorioMedico(9);
    	  }
      }
     
      public void exibir(){
    	  if(lista[0] != null){
    		  cadastroMedico.exibirListaProcedimentoMedico(lista, contador); //GUI imprimi lista
    	  }else{
    		  cadastroMedico.saidaParaRepositorioMedico(10);
    	  }
      }
      
      public void remover(){
    	  if(lista != null){
          
            String nome = cadastroMedico.entradaParaRepositorioMedico(11);
            boolean achou = false;
            int i;
          
            for(i = 0 ; i <= contador && achou == false ; i++){
               String auxiliarNome = lista[i].getNome();
             
               if(nome.equals(auxiliarNome)){
                   achou = true;
               }
            }
          
            if(achou == true){
            	cadastroMedico.saidaParaRepositorioMedico(11);
                lista[i] = lista[contador];
                lista[contador] = null;
            }else{
            	cadastroMedico.saidaParaRepositorioMedico(12);
            }
    	  }
      }
}
