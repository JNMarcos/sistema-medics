package medics.negocio;

import java.util.Scanner;

import medics.dados.RepositorioProcedimento;
import medics.gui.TelaDesktop;
import medics.negocio.classes_basicas.Procedimento;

public class CadastroProcedimento{
	TelaDesktop tela = new TelaDesktop();
	Scanner input = new Scanner(System.in); 
	final static RepositorioProcedimento repositorio = new RepositorioProcedimento();
	public static boolean primeiraVez = true; 
	
    public void menu(){

    	  String opt;
    	  boolean condicao = true;
    	  while(condicao == true){
    		
    		  opt = tela. menuProcedimento();
    		  
    		  switch(opt){
    		  case "1":  
    			  Procedimento procedimento = new Procedimento();
    	    	   
    	    	   String nome = tela.novoProcedimento();
    	    	   procedimento.setNome(nome);
    			  if (primeiraVez == true) {
    				  repositorio.criarLista();
                      repositorio.setContador(0);
                      repositorio.cadastrar(primeiraVez, procedimento);
                      primeiraVez= false;
                  }else{
                   if(repositorio.getContador() == repositorio.getLista().length){
                       repositorio.aumentarArray();
                   }
                   repositorio.cadastrar(primeiraVez, procedimento);              
                  }
    			  CadastroAgenda.setListaProcedimento(repositorio.getLista());
    			  CadastroAgenda.setContadorProcedimento(repositorio.getContador());
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
    
    public String entradaParaRepositorio(int codigo){             //Repositorio passa um codigo e 
    	   return tela.entradaRepositorioProcedimento(codigo);  //esse codigo é passado para
    	                                                         //GUI para pegar dados.    	
    }
    
    public void saidaParaRepositorio(int codigo){
    	tela.saidaParaRepositorio(codigo);
    }
    
    public void exibirListaProcedimento(Procedimento[] lista, int contador){
	    tela.exibirListaProcedimento(lista, contador);	 
  	 }
}
