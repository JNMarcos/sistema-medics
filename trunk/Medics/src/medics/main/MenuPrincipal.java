package medics.main;

import medics.negocio.CadastroAgenda;
import medics.negocio.CadastroPaciente;
import medics.negocio.CadastroMedico;
import medics.negocio.CadastroProcedimento;
import java.util.Scanner;
import medics.gui.TelaDesktop;

public class MenuPrincipal {
	
	public static void main(String[] args){
		TelaDesktop tela = new TelaDesktop(); 
		Scanner input = new Scanner(System.in);
		CadastroPaciente paciente = new CadastroPaciente();
		CadastroMedico medico = new CadastroMedico();
		CadastroProcedimento procedimento = new CadastroProcedimento();
		CadastroAgenda agenda = new CadastroAgenda();
		String opt;
		boolean condicao = true;
		
		while(condicao == true){
		    
			opt = tela.menuPrincipal();
		 
			 switch(opt){
			 case "1":
				 paciente.menu();
				 break;
	         case "2":
				 medico.menu();
				 break;
         	 case "3":
		         procedimento.menu();
	        	 break;
        	 case "4":
		         agenda.menu();
        		 break;
	         case "5":
	        	 System.exit(0);
		         break;
			default: 	
			 
		   }
	   }
		input.close();
   }
   
}
