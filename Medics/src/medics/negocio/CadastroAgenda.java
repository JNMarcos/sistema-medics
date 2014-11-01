package medics.negocio;

import java.util.Scanner;

import medics.dados.RepositorioAgenda;
import medics.gui.TelaDesktop;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.classes_basicas.Procedimento;
import medics.negocio.classes_basicas.Agenda;


public class CadastroAgenda{
	public static Paciente[] listaPaciente;
	public static Medico[] listaMedico;
	public static Procedimento[] listaProcedimento;
	public static int contadorPaciente;
	public static int contadorMedico;
	public static int contadorProcedimento;
	
	TelaDesktop tela = new TelaDesktop();
	Scanner input = new Scanner(System.in); 
	public static boolean primeiraVez = true; 
	public static RepositorioAgenda repositorio = new RepositorioAgenda();
	
	public void setListaPaciente(Paciente[] lista) {
		listaPaciente = lista;
	}
    
	public static void setListaMedico(Medico[] listaMedico) {
		CadastroAgenda.listaMedico = listaMedico;
	}

	public static void setListaProcedimento(Procedimento[] listaProcedimento) {
		CadastroAgenda.listaProcedimento = listaProcedimento;
	}

	public static void setContadorPaciente(int contadorPaciente) {
		CadastroAgenda.contadorPaciente = contadorPaciente;
	}

	public static void setContadorMedico(int contadorMedico) {
		CadastroAgenda.contadorMedico = contadorMedico;
	}

	public static void setContadorProcedimento(int contadorProcedimento) {
		CadastroAgenda.contadorProcedimento = contadorProcedimento;
	}

	public void menu(){    	  
    	  
    	  String opt;
    	  boolean condicao = true;
    	  while(condicao == true){  
    		  opt = tela.menuAgenda();
    		  
    		  switch(opt){
    		  case "1":
    			  if (primeiraVez == true) {
    				  repositorio.criarLista();
                      repositorio.setContador(0);
                      repositorio.cadastrar(primeiraVez, listaPaciente, listaMedico, listaProcedimento,
                    		  contadorPaciente, contadorMedico, contadorProcedimento);
                      primeiraVez= false;
                  }else{
                       if(repositorio.getContador() == repositorio.getLista().length){
                           repositorio.aumentarArray();
                       }
                       repositorio.cadastrar(primeiraVez, listaPaciente, listaMedico, listaProcedimento,
                     		  contadorPaciente, contadorMedico, contadorProcedimento);      
                  }
    			 
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
	
    public String entradaParaRepositorioAgenda(int codigo){    //Repositorio passa um codigo e 
 	     return tela.entradaRepositorioAgenda(codigo);  //esse codigo é passado para      	
    }                                                  //GUI para pegar dados.
    
 
    public void saidaParaRepositorioAgenda(int codigo){
 	  tela.saidaParaRepositorioAgenda(codigo);
    }
 
    public void exibirListaProcedimentoAgenda(Agenda[] lista, int contador){
	     tela.exibirListaAgenda(lista, contador);	 
	 }
 
	
}
