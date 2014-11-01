package medics.negocio;

import java.util.Scanner;

import medics.dados.RepositorioMedico;
import medics.gui.TelaDesktop;
import medics.negocio.classes_basicas.Medico;

public class CadastroMedico{
	TelaDesktop tela = new TelaDesktop();
	Scanner input = new Scanner(System.in); 
	final static RepositorioMedico repositorio = new RepositorioMedico();
	public static boolean primeiraVez = true; 
	
    public void menu(){ 
    	  String opt;
    	  boolean condicao = true;
    	  while(condicao == true){
    		  opt = tela.menuMedico();
    		  
    		  switch(opt){
    		  case "1":
    	          Medico medico = tela.novoMedico();
    	          
    			  if (primeiraVez == true) {
    				  repositorio.criarLista();
                      repositorio.setContador(0);
                      repositorio.cadastrar(primeiraVez, medico);
                      primeiraVez= false;
                  }else{
                   if(repositorio.getContador() == repositorio.getLista().length){
                       repositorio.aumentarArray();
                   }
                   repositorio.cadastrar(primeiraVez,medico);       
                   }
    			  CadastroAgenda.setListaMedico(repositorio.getLista());
    			  CadastroAgenda.setContadorMedico(repositorio.getContador());
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
    
    public String entradaParaRepositorioMedico(int codigo){             //Repositorio passa um codigo e 
    	   return tela.entradaRepositorioMedico(codigo);  //esse codigo é passado para
    	                                                         //GUI para pegar dados.    	
    }
    
    public void saidaParaRepositorioMedico(int codigo){
    	tela.saidaParaRepositorioMedico(codigo);
    }
    
    public void exibirListaProcedimentoMedico(Medico[] lista, int contador){
 	    tela.exibirListaMedico(lista, contador);	 
  	 }
    
}
