package medics.negocio;

import java.util.Scanner;

import medics.dados.RepositorioPaciente;
import medics.gui.TelaDesktop;
import medics.negocio.classes_basicas.Paciente;

public class CadastroPaciente {
	TelaDesktop tela = new TelaDesktop();
	Scanner input = new Scanner(System.in); 
	public static boolean primeiraVez = true; 
	final static RepositorioPaciente repositorio = new RepositorioPaciente();
    
	public void menu(){    	  
    	  
    	  String opt;
    	  boolean condicao = true;
    	  while(condicao == true){
    		  opt = tela.menuPaciente();
    		  
    		  switch(opt){
    		  case "1":
    			  Paciente paciente = tela.novoPaciente();
    			  
    			  if (primeiraVez == true) {
    				  repositorio.criarLista();
                      repositorio.setContador(0);
                      repositorio.cadastrar(primeiraVez, paciente);
                      primeiraVez= false;
                  }else{
                       if(repositorio.getContador() == repositorio.getLista().length){
                           repositorio.aumentarArray();
                       }
                      repositorio.cadastrar(primeiraVez, paciente);         
                  }
    			  CadastroAgenda auxiliar = new CadastroAgenda();
    			  auxiliar.setListaPaciente(repositorio.getLista());
    			  CadastroAgenda.setContadorPaciente(repositorio.getContador());
    			  break;
	          case "2":
    			  repositorio.modificar();
    			  break;
	          case "3":
    			  repositorio.remover();
    			  break;
	          case "4":
		          repositorio.exibir();
		          break;
	          case "5":
	        	  medics.main.MenuPrincipal.main(null);
		          break;
    		  default:
    			  
    		  }
    	  }
      }
	
   public String entradaParaRepositorioPaciente(int codigo){             //Repositorio passa um codigo e 
   	   return tela.entradaRepositorioPaciente(codigo);  //esse codigo é passado para
   	                                                         //GUI para pegar dados.    	
   }
   
   public void saidaParaRepositorioPaciente(int codigo){
   	tela.saidaParaRepositorioPaciente(codigo);
   }
   
   public void exibirListaProcedimentoPaciente(Paciente[] lista, int contador){
	    tela.exibirListaPaciente(lista, contador);	 
 	 }
    
}
