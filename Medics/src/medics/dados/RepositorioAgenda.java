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

import medics.negocio.classes_basicas.Agenda;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.classes_basicas.Procedimento;
import medics.negocio.CadastroAgenda;

public class RepositorioAgenda {
      private int contador = 0;
	  Agenda[] lista;
	  public static CadastroAgenda cadastroAgenda = new CadastroAgenda();
	  	 
	  public int getContador() {
		return contador;
	  }

	  public  void setContador(int contador) {
		this.contador = contador;
	  }

	  public void criarLista() {
	        lista = new Agenda[10];
	  }
	  
      public Agenda[] getLista() {
		return lista;
	  }

	  public void setLista(Agenda[] lista) {
		this.lista = lista;
	  }
	  
	  public void aumentarArray(){
	        Agenda[] auxiliar;
	        auxiliar = new Agenda[lista.length];
	        
	        for(int i = 0 ; i<lista.length ; i++){
	            auxiliar[i] = lista[i];
	        }
	        lista = new Agenda[auxiliar.length * 2];
	        
	        for(int i = 0; i<auxiliar.length ; i++){
	            lista[i] = auxiliar[i];
	        }
	    }
 
      
      public void cadastrar(boolean primeiraVez, Paciente[] listaPaciente, Medico[] listaMedico,
    		  Procedimento[] listaProcedimento, int contadorPaciente, int contadorMedico,
    		  int contadorProcedimento) {
    	  Agenda agenda = new Agenda();
   	      boolean achou = false;
   	      
   	      if(listaPaciente != null){
   	      String paciente = cadastroAgenda.entradaParaRepositorioAgenda(1);
   	  
            for (int i=0 ; i<=contadorPaciente && achou == false; i++){
        	   if(paciente.equals(listaPaciente[i].getNome())){
        			agenda.setPaciente(listaPaciente[i]);
          		    achou = true;
        	    }
            }
            if(achou == false){
        	    
        	    cadastroAgenda.saidaParaRepositorioAgenda(1);
             }
   	      }else{
   	    	  Paciente paciente = new Paciente();
   	    	  paciente.setNome("");               //para exibir o vazio em paciente na agenda
   	    	 agenda.setPaciente(paciente); 
   	      }
          
   	      if(listaMedico != null){
            String medico = cadastroAgenda.entradaParaRepositorioAgenda(2);
            achou = false;
            for (int i=0 ; i<=contadorMedico && achou == false; i++){
        	    if(medico.equals(listaMedico[i].getNome())){
        		   agenda.setMedico(listaMedico[i]);
        		   achou = true;
        	    }
             }
            if(achou == false){
            	cadastroAgenda.saidaParaRepositorioAgenda(2);
             }
   	      }else{
   	    	  Medico medico = new Medico();
   	    	  medico.setNome("");                //para exibir o vazio em medico na agenda
   	    	  agenda.setMedico(medico); 
   	      }
          
   	      if(listaProcedimento != null){
            String procedimento = cadastroAgenda.entradaParaRepositorioAgenda(3);
            achou = false;
            for (int i=0 ; i<=contadorProcedimento && achou == false; i++){
        	    if(procedimento.equals(listaProcedimento[i].getNome())){
        		    agenda.setProcedimento(listaProcedimento[i]);
        		    achou = true;
        	    }
            }
            if(achou == false){
            	 cadastroAgenda.saidaParaRepositorioAgenda(3);
            }
   	      }else{
   	    	  Procedimento procedimento = new Procedimento();
   	    	  procedimento.setNome("");                //para exibir o vazio em medico na agenda
   	    	  agenda.setProcedimento(procedimento); 
   	      }
          
          String data =  cadastroAgenda.entradaParaRepositorioAgenda(4);
          agenda.setData(data);
          String hora = cadastroAgenda.entradaParaRepositorioAgenda(5);
          agenda.setHora(hora);
          
          if(primeiraVez == true){
              lista[0] = agenda;
          }else{
             contador++;
             lista[contador] = agenda;
          }
      }
      
      public void modificar() {
          if(lista != null){
    	  boolean achou = false;
          int indicePesquisa;
          String hora = cadastroAgenda.entradaParaRepositorioAgenda(5);
          String data = cadastroAgenda.entradaParaRepositorioAgenda(4);
          String medico = cadastroAgenda.entradaParaRepositorioAgenda(2);
          
          for(indicePesquisa = 0 ; indicePesquisa <= contador && achou == false ; indicePesquisa++ ) {
              if (hora.equals(lista[indicePesquisa].getHora()) && 
            		  data.equals(lista[indicePesquisa].getData()) && medico.equals(lista[indicePesquisa].getMedico().getNome())){
                  achou = true; 
              }
          }
          
          if (achou == true) {
              String opt;
              opt = cadastroAgenda.entradaParaRepositorioAgenda(6);

              switch (opt) {
                  case "1":
                      String novaData = cadastroAgenda.entradaParaRepositorioAgenda(7);
                      lista[indicePesquisa-1].setData(novaData);
                      break;
                  case "2":
                      String novaHora = cadastroAgenda.entradaParaRepositorioAgenda(8);
                      lista[indicePesquisa-1].setHora(novaHora);
                      break;
                  case "3":
                	  RepositorioMedico repositorioMedico = new RepositorioMedico();
                      String nomeMedico = cadastroAgenda.entradaParaRepositorioAgenda(9);
                      Medico[] listaMedico = repositorioMedico.getLista();
                      achou = false;
                      for (int i=0 ; i<repositorioMedico.getLista().length && achou == false; i++){
                    	  if(nomeMedico.equals(listaMedico[i].getNome())){
                    		  lista[indicePesquisa-1].setMedico(listaMedico[i]);
                    		  achou = true;
                    	  }
                      }
                      if(achou == false){
                    	  cadastroAgenda.saidaParaRepositorioAgenda(9);
                      }
                      break;
                  case "4":
                	  RepositorioPaciente repositorioPaciente = new RepositorioPaciente();
                      System.out.println("Novo paciente:");
                      String nomePaciente = cadastroAgenda.entradaParaRepositorioAgenda(10);
                      Paciente[] listaPaciente = repositorioPaciente.getLista();
                      achou = false;
                      for (int i=0 ; i<repositorioPaciente.getLista().length && achou == false; i++){
                    	  if(nomePaciente.equals(listaPaciente[i].getNome())){
                    		  lista[indicePesquisa-1].setPaciente(listaPaciente[i]);
                    		  achou = true;
                    	  }
                      }
                      if(achou == false){
                    	  cadastroAgenda.saidaParaRepositorioAgenda(10);
                      }
                      break;
                  case "5":
                  	  RepositorioProcedimento repositorioProcedimento = new RepositorioProcedimento();
                      String nomeProcedimento = cadastroAgenda.entradaParaRepositorioAgenda(11);
                      Procedimento[] listaProcedimento = repositorioProcedimento.getLista();
                      achou = false;
                      for (int i=0 ; i<repositorioProcedimento.getLista().length && achou == false; i++){
                    	  if(nomeProcedimento.equals(listaProcedimento[i].getNome())){
                    		  lista[indicePesquisa-1].setProcedimento(listaProcedimento[i]);
                    		  achou = true;
                    	  }
                      }
                   
                      if(achou == false){
                    	  cadastroAgenda.saidaParaRepositorioAgenda(11);
                      }
                      break;
                     }
                    } 
          }else{
        	  cadastroAgenda.saidaParaRepositorioAgenda(12);
          }
      
      }
     
      public void exibir(){
    	  if(lista != null){
    	       cadastroAgenda.exibirListaProcedimentoAgenda(lista, contador);
    	  }else{
    		  cadastroAgenda.saidaParaRepositorioAgenda(12);
    	  }
    	 
      }
      
      public void remover(){
    	  if(lista != null){
          
            String data = cadastroAgenda.entradaParaRepositorioAgenda(4);
            String hora = cadastroAgenda.entradaParaRepositorioAgenda(5);
          
            boolean achou = false;
            int i;
          
            for(i = 0 ; i <= contador && achou == false ; i++){
               if(data.equals(lista[i].getData()) && hora.equals(lista[i].getHora())){
                   achou = true;
               }
            }
          
            if(achou == true){
            	cadastroAgenda.saidaParaRepositorioAgenda(14);
                lista[i] = lista[contador];
                lista[contador] = null;
            }else{
            	cadastroAgenda.saidaParaRepositorioAgenda(1);
            }
    	 }   
       }

}

