package medics.gui;

import java.util.Scanner;

import medics.negocio.classes_basicas.Paciente;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.classes_basicas.Procedimento;
import medics.negocio.classes_basicas.Agenda;

public class TelaDesktop {
	Scanner input = new Scanner(System.in);
	public String menuPrincipal(){
		String opt;
			System.out.println("<1>Paciente");
			System.out.println("<2>Medico");
			System.out.println("<3>Procedimento");
			System.out.println("<4>Agenda");
			System.out.println("<5>Sair");
			opt = input.next();
		return opt;	
	}
	
	public String menuProcedimento(){
		  String opt;
		  System.out.println("<1>Cadastrar Procedimento");
		  System.out.println("<2>Editar Procedimento");
		  System.out.println("<3>Remover Procedimento");
		  System.out.println("<4>Exibir lista de Procedimento");
		  System.out.println("<5>Voltar");
		  opt = input.next();
		  
		  return opt;
	}
	
	public String novoProcedimento(){
		 System.out.println("Nome:");
  	     String nome = input.next();
  	     
  	     return nome;
	}
	
	public String menuPaciente(){
		String opt;
 
  	    System.out.println("<1>Cadastrar Paciente");
  	    System.out.println("<2>Editar Paciente");
  	    System.out.println("<3>Remover Paciente");
  	    System.out.println("<4>Exibir lista de Pacientes");
  	    System.out.println("<5>Voltar");
  	    opt = input.next();
  	    
  	    return opt;
	}
	
	public Paciente novoPaciente(){
		  Paciente paciente = new Paciente();
	   	   
  	      System.out.println("Nome:");
  	      String nome = input.next();
  	      paciente.setNome(nome);
  	      System.out.println("CPF:");
  	      String cpf = input.next();
  	      paciente.setCpf(cpf);
  	      System.out.println("Data de nascimento ( xx/xx/xxx):");
  	      String dataNascimento = input.next();
  	      paciente.setDataNascimento(dataNascimento);
  	      System.out.println("Bairro:");
  	      String bairro = input.next();
  	      paciente.setBairro(bairro);
  	      System.out.println("Telefone (só numeros):");
  	      String telefone = input.next();
  	      paciente.setTelefone(telefone);
  	      System.out.println("Email:");
  	      String email = input.next();
  	      paciente.setEmail(email);
	      
  	      return paciente;
	}
	
	public String menuMedico(){
		String opt;
 
		System.out.println("<1>Cadastrar Medico");
	    System.out.println("<2>Editar Medico");
	    System.out.println("<3>Remover Medico");
	    System.out.println("<4>Exibir lista de Medicos");
	    System.out.println("<5>Voltar");
  	    opt = input.next();
  	    
  	    return opt;
	}
	
	public Medico novoMedico(){
		  Medico medico = new Medico();
	   	   
		  System.out.println("Nome:");
   	      String nome = input.next();
   	      medico.setNome(nome);
   	      System.out.println("CPF:");
   	      String cpf = input.next();
   	      medico.setCpf(cpf);
   	      System.out.println("Bairro:");
   	      String bairro =input.next();
   	      medico.setBairro(bairro);
   	      System.out.println("Cidade:");
   	      String cidade = input.next();
   	      medico.setCidade(cidade);
   	      System.out.println("Especialidade:");
   	      String especialidade = input.next();
   	      medico.setEspecialidade(especialidade);
	      
  	      return medico;
	}
	
	public String menuAgenda(){
		  String opt;
		  System.out.println("<1>Cadastrar consulta");
		  System.out.println("<2>Editar consulta");
		  System.out.println("<3>Remover consulta");
		  System.out.println("<4>Exibir lista de consultas");
		  System.out.println("<5>Voltar");
		  opt = input.next();
		  
		  return opt;
	}
	
	public String entradaRepositorioProcedimento(int codigo){
		String entrada = "";
		
		if(codigo == 1){
			System.out.println("Digite o nome do procedimento-");
            entrada = input.next();
		}else if(codigo == 2){
			System.out.println("Novo nome- ");
            entrada = input.next();
		}else if(codigo == 6){
			  System.out.println("Nome para remoção");
	          entrada = input.next();
		}
		
		return entrada;
	}
	
	 public void saidaParaRepositorio(int codigo){
	    	if(codigo == 3){
	    		System.out.println("Procedimento não encontrado.");
	    	}else if(codigo == 4){
	    		System.out.println("Não existe procedimentos.");
	    	}else if(codigo == 5){
	    		System.out.println("Lista vazia");
	    	}else if(codigo == 7){
	    		System.out.println("Removido com sucesso.");
	    	}else if(codigo == 8){
	    		System.out.println("Procedimento não encontrado !");
	    	}
	    }
	 
	 public void exibirListaProcedimento(Procedimento[] lista, int contador){
		 for(int i=0 ; i<=contador; i++){
   		  System.out.println("Nome: "+lista[i].getNome());
   		  System.out.println("");
   	  }
	 }
	 
	 public String entradaRepositorioPaciente(int codigo){
			String entrada = "";
			
			if(codigo == 1){
				System.out.println("Digite o nome do paciente-");
	            entrada = input.next();
			}else if(codigo == 2){
				  System.out.println("O que deseja editar ?");
	                System.out.println("<1>Nome  \n<2>CPF  \n<3>Data Nascimento \n<4>Bairro \n<5>Telefone"
	                      + " \n<6>Email \n");
	                entrada = input.next();
			}else if(codigo == 3){
				 System.out.println("Novo nome- ");
                 entrada = input.next();
			}else if(codigo == 4){
				System.out.println("Novo CPF- ");
                 entrada = input.next();
			}else if(codigo == 5){
                System.out.println("Novo data nascimento- ");
                entrada = input.next();
			}else if(codigo == 6){
				 System.out.println("Novo bairro- ");
                 entrada = input.next();
			}else if(codigo == 7){
				System.out.println("Novo telefone- ");
                 entrada = input.next();
			}else if(codigo == 8){
				 System.out.println("Novo email- ");
                 entrada = input.next();
			}else if(codigo == 12){
				System.out.println("Nome para remoção");
				entrada = input.next();
			}
			
			return entrada;
		}
		
		 public void saidaParaRepositorioPaciente(int codigo){
		    	if(codigo == 9){
		    		System.out.println("Paciente não encontrado.");
		    	}else if(codigo == 10){
		    		System.out.println("Não existe pacientes.");
		    	}else if(codigo == 11){
		    		 System.out.println("Lista vazia.");
		    	}else if(codigo == 13){
		    		System.out.println("Removido com sucesso.");
		    	}else if(codigo == 14){
		    		 System.out.println("Paciente não encontrado !");
		    	}
		    }
		 
		 public void exibirListaPaciente(Paciente[] lista, int contador){
			 for(int i=0 ; i<=contador; i++){
	    		  System.out.println("Nome: "+lista[i].getNome());
	    		  System.out.println("CPF: "+lista[i].getCpf());
	    		  System.out.println("Data nascimento: "+lista[i].getDataNascimento());
	    		  System.out.println("Bairro: "+lista[i].getBairro());
	    		  System.out.println("Telefone: "+lista[i].getTelefone());
	    		  System.out.println("Email: "+lista[i].getEmail());
	    		  System.out.println("");
	    	  }
		 }
		 
		 public String entradaRepositorioMedico(int codigo){
				String entrada = "";
				
				if(codigo == 1){
					System.out.println("Digite o nome do medico-");
		            entrada = input.next();
				}else if(codigo == 2){
					 System.out.println("O que deseja editar ?");
		                System.out.println("<1>Nome  \n<2>CPF  \n<3>Bairro \n<4>Cidade \n<5>Especialidade");
		                entrada = input.next();
				}else if(codigo == 3){
					System.out.println("Novo nome- ");
	                 entrada = input.next();
				}else if(codigo == 4){
					 System.out.println("Novo CPF- ");
	                 entrada = input.next();
				}else if(codigo == 5){
					System.out.println("Novo bairro- ");
	                entrada = input.next();
				}else if(codigo == 6){
					 System.out.println("Nova cidade- ");
	                 entrada = input.next();
				}else if(codigo == 7){
					System.out.println("Nova especialidade- ");
	                 entrada = input.next();
				}else if(codigo == 11){
					System.out.println("Nome para remoção");
					entrada = input.next();
				}
				
				return entrada;
			}
			
			 public void saidaParaRepositorioMedico(int codigo){
			    	if(codigo == 8){
			    		System.out.println("Medico não encontrado.");
			    	}else if(codigo == 9){
			    		System.out.println("Não existe medicos.");
			    	}else if(codigo == 10){
			    		 System.out.println("Lista vazia.");
			    	}else if(codigo == 12){
			    		System.out.println("Removido com sucesso.");
			    	}else if(codigo == 13){
			    		 System.out.println("Medico não encontrado !");
			    	}
			    }
			 
			 public void exibirListaMedico(Medico[] lista, int contador){
				 for(int i=0 ; i<=contador; i++){
					 System.out.println("Nome: "+lista[i].getNome());
		    		  System.out.println("CPF: "+lista[i].getCpf());
		    		  System.out.println("Bairro: "+lista[i].getBairro());
		    		  System.out.println("Cidade: "+lista[i].getCidade());
		    		  System.out.println("Especialidade: "+lista[i].getEspecialidade());
		    		  System.out.println("");
		    	  }
			 }
			 
			 public String entradaRepositorioAgenda(int codigo){
					String entrada = "";
					
					if(codigo == 1){
						System.out.println("Nome do paciente:");
			            entrada = input.next();
					}else if(codigo == 2){
						 System.out.println("Nome do medico:");
			             entrada = input.next();
					}else if(codigo == 3){
						 System.out.println("Nome do procedimento:");
		                 entrada = input.next();
					}else if(codigo == 4){
						 System.out.println("Data (xx/xx/xxxx)");
		                 entrada = input.next();
					}else if(codigo == 5){
						System.out.println("Hora (xx:xx)");
		                entrada = input.next();
					}else if(codigo == 6){
						System.out.println("O que deseja editar ?");
			            System.out.println("<1>Data  \n<2>Hora  \n<3>Medico \n<4>Paciente \n<5>Procedimento");
		                 entrada = input.next();
					}else if(codigo == 7){
						System.out.println("Nova data- ");
		                 entrada = input.next();
					}else if(codigo == 8){
						 System.out.println("Nova hora- ");
						entrada = input.next();
					}else if(codigo == 9){
					    System.out.println("Novo  medico:");
						entrada = input.next();
					}else if(codigo == 10){
					    System.out.println("Novo paciente:");
						entrada = input.next();
					}else if(codigo == 11){
						System.out.println("Novo procedimento:");
						entrada = input.next();
					}else if(codigo == 12){
						System.out.println("Nome para remoção");
						entrada = input.next();
					}else if(codigo == 11){
						System.out.println("Nome para remoção");
						entrada = input.next();
					}
					
					
					return entrada;
				}
				
				 public void saidaParaRepositorioAgenda(int codigo){
				    	if(codigo == 1){
				    		System.out.println("Paciente não encontrado.");
				    	}else if(codigo == 2){
				    		System.out.println("Medico não encontrado.");
				    	}else if(codigo == 3){
				    		System.out.println("Procedimento não encontrado.");
				    	}else if(codigo == 9){
				    		System.out.println("Medico não encontrado.");
				    	}else if(codigo == 10){
				    		System.out.println("Paciente não encontrado.");
				    	}
				    	else if(codigo == 11){
				    		System.out.println("Procedimento não encontrado.");
				    	}
				    	else if(codigo == 12){
				    		System.out.println("Agenda vazia");
				    	}
				    	else if(codigo == 13){
				    		 System.out.println("Medico não encontrado !");
				    	}
				    	else if(codigo == 13){
				    		 System.out.println("Medico não encontrado !");
				    	}else if(codigo == 14){
				    		 System.out.println("Removido com sucesso!");
				    	}
				    }
				 
				 public void exibirListaAgenda(Agenda[] lista, int contador){
						  System.out.println("------------------------------------------------------------------------------");
			    	      System.out.println("        DATA          HORA            PACIENTE             MEDICO       PROCEDIMENTO   ");
			    		for(int i=0 ; i<=contador; i++){
			    		   System.out.print(lista[i].getData() + "     |     ");
			    		   System.out.print(lista[i].getHora() + "     |     ");
			    	   	   System.out.print(lista[i].getPaciente().getNome() + "     |     ");
			    		   System.out.print(lista[i].getMedico().getNome() + "     |     ");
			    		   System.out.print(lista[i].getProcedimento().getNome());
			    		   System.out.println("");
			    	    }
			    		 System.out.println("--------------------------------------------------------------------------\n");
			    	  
				 }
}
