//estou tentando organizar a GUI de forma que todos os dados sejam pegos aqui, e levado até o repositorio quando
//necessario, trabalhos terei que mudar toda estrutura do programa, estudarei sobre camadas e qual o real papel da GUI

package medics.gui;

import java.util.Scanner;

import medics.negocio.Fachada;
import medics.negocio.IFachada;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.NaoEncontradoException;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TelaTextual {
/*	static Scanner input = new Scanner(System.in);
	public static IFachada fachada = Fachada.getInstance();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String opt;
		boolean condicao = true;

		while (condicao == true) {

			System.out.print("<1>Medico\n" + "<2>Secretário\n" + "<3>Sair\n");
			opt = input.nextLine();

			switch (opt) {
			case "1":
				opcaoMedico();
				break;
			case "2":
				opcaoSecretario();
				break;
			case "3":
				System.exit(0);
				break;
			default:

			}
		}
		input.close();
	}

	public static void opcaoMedico() {
		String login, senha, opt;

		System.out.println("Login: ");
		login = input.next();
		System.out.println("Senha: ");
		senha = input.next();

		System.out.println("<1>Entrar <2>Voltar");
		opt = input.next();

		switch (opt) {

		case "1":
			//Medico medico = fachada.verificarLoginMedico(login, senha);

			if (medico != null) {
				String opcao;

				System.out.println("<1>Editar Dador");
				System.out.println("<2>Agenda");
				System.out.println("<3>Sair");
				opcao = input.next();

				switch (opcao) {
				case "1":
					String escolha = opcaoEditarMedico();
					try {
						fachada.editarMedico(medico.getPrimeiroNome(),
								medico.getSegundoNome(), escolha,
								editarMedico(opcao));
					} catch (ArrayVazioException e) {
						System.out.println(e);
						opcaoMedico();
					} catch (NaoEncontradoException n) {
						System.out.println(n);
						opcaoMedico();
					}
					break;
				case "2":
					// exibir agenda;
					break;
				case "3":
					main(null);
					break;
				default:

				}

			} else {
				System.out.println("Usuário ou senha inválidos.");
				opcaoSecretario();
			}
			break;
		case "2":
			main(null);
			break;
		default:
		}
	}

	public static void opcaoSecretario() {
		String login, senha, opt;

		System.out.println("Login: ");
		login = input.next();
		System.out.println("Senha: ");
		senha = input.next();

		System.out.println("<1>Entrar <2>Voltar");
		opt = input.next();

		switch (opt) {

		case "1":
			/*if (fachada.verificarLogin(login, senha)) {
				opcoesSecretario();
			} else {
				System.out.println("Usuário ou senha inválidos.");
				opcaoSecretario();
			}
			break;
		case "2":
			main(null);
			break;
		default:
		}

	}

	public static void opcoesSecretario() {
		String opt = menuPrincipal(), opt2;

		switch (opt) {
		case "1":
			while (true) {
				opt2 = menuPaciente();

				switch (opt2) {
				case "1":
					fachada.cadastrarPaciente(novoPaciente());
					break;
				case "2":
					String opcao = opcaoEditar();

					try {
						fachada.editarPaciente(primeiroNome(), segundoNome(),
								opcao, editarPaciente(opcao));

					} catch (ArrayVazioException e) {
						System.out.println(e);
						opcoesSecretario();
					} catch (NaoEncontradoException n) {
						System.out.println(n);
						opcoesSecretario();
					}
					System.out.println("Operação Realizada com sucesso");

					break;
				case "3":
					try {
						fachada.removerPaciente(primeiroNome(), segundoNome());
					} catch (ArrayVazioException e) {
						System.out.println(e);
						opcoesSecretario();
					} catch (NaoEncontradoException n) {
						System.out.println(n);
						opcoesSecretario();
					}

					break;
				case "4":
					// Exibir- fazer retornar lista no repositório e mostrar na
					// GUI
					break;
				case "5":
					opcoesSecretario();
					break;
				default:

				}
				opcoesSecretario();
				break;
			}
		case "2":
			while (true) {
				opt2 = menuMedico();

				switch (opt2) {
				case "1":
					fachada.cadastrarMedico(novoMedico());
					break;
				case "2":
					String nome = nomeMedico();
					editarMedico(nome);
					String opcao = opcaoEditarMedico();
					try {
						fachada.editarMedico(primeiroNome(), segundoNome(),
								opcao, editarMedico(opcao));
					} catch (ArrayVazioException e) {
						System.out.println(e);
						opcoesSecretario();
					} catch (NaoEncontradoException n) {
						System.out.println(n);
						opcoesSecretario();
					}
					break;
				case "3":
					try {
						fachada.removerMedico(primeiroNome(), segundoNome());
					} catch (ArrayVazioException e) {
						System.out.println(e);
						opcoesSecretario();
					} catch (NaoEncontradoException n) {
						System.out.println(n);
						opcoesSecretario();
					}
					break;
				case "4":
					// Exibir- fazer retornar lista no repositório e mostrar na
					// GUI
					break;
				case "5":
					opcoesSecretario();
					break;
				default:

				}

				break;
			}
			opcoesSecretario();
		case "3":
			while (true) {
				opt2 = menuProcedimento();
				switch (opt2) {
				case "1":
					fachada.cadastrarProcedimento(nomeProcedimento());
					break;
				case "2":
					try {
						fachada.editarProcedimento(nomeProcedimento(),
								novoProcedimento());
					} catch (ArrayVazioException e) {
						System.out.println(e);
						opcoesSecretario();
					} catch (NaoEncontradoException n) {
						System.out.println(n);
						opcoesSecretario();
					}
					break;
				case "3":
					try {
						fachada.removerProcedimento(nomeProcedimento());
					} catch (ArrayVazioException e) {
						System.out.println(e);
						opcoesSecretario();
					} catch (NaoEncontradoException n) {
						System.out.println(n);
						opcoesSecretario();
					}
					break;
				case "4":
					// Exibir- fazer retornar lista no repositório e mostrar na
					// GUI
					break;
				case "5":
					opcoesSecretario();
					break;
				default:

				}

				break;
			}
			opcoesSecretario();
		case "4":

			while (true) {
				opt2 = menuConsulta();

				switch (opt2) {
				case "1":
					fachada.cadastrarConsuta(primeiroNome(), segundoNome(),
							primeiroNome(), segundoNome(), nomeProcedimento(),
							data(), hora());
					break;
				case "2":
					String opcao = opcaoEditarConsulta();
					fachada.editarConsulta(data(), hora(), primeiroNome(), segundoNome(), opcao,
							editarConsulta(opcao));
					break;
				case "3":
					fachada.removerConsulta(data(), hora());
					break;
				case "4":

					break;
				case "5":
					opcoesSecretario();
					break;
				default:

				}

				break;
			}
		case "5":
			main(null);
			break;
		default:
		}
		opcoesSecretario();

		// fachada.intermediario(opt);
	}

	public static String menuPrincipal() {
		String opt;
		System.out.println("<1>Paciente");
		System.out.println("<2>Medico");
		System.out.println("<3>Procedimento");
		System.out.println("<4>Consulta");
		System.out.println("<5>Sair da conta");
		opt = input.next();
		return opt;
	}

	public static String menuPaciente() {
		String opt;

		System.out.println("<1>Cadastrar Paciente");
		System.out.println("<2>Editar Paciente");
		System.out.println("<3>Remover Paciente");
		System.out.println("<4>Exibir lista de Pacientes");
		System.out.println("<5>Voltar");
		opt = input.next();

		return opt;
	}

	public static String menuMedico() {
		String opt;

		System.out.println("<1>Cadastrar Medico");
		System.out.println("<2>Editar Medico");
		System.out.println("<3>Remover Medico");
		System.out.println("<4>Exibir lista de Medicos");
		System.out.println("<5>Voltar");
		opt = input.next();

		return opt;
	}

	public static String menuProcedimento() {
		String opt;
		System.out.println("<1>Cadastrar Procedimento");
		System.out.println("<2>Editar Procedimento");
		System.out.println("<3>Remover Procedimento");
		System.out.println("<4>Exibir lista de Procedimento");
		System.out.println("<5>Voltar");
		opt = input.next();

		return opt;
	}

	public static String menuConsulta() {
		String opt;
		System.out.println("<1>Cadastrar consulta");
		System.out.println("<2>Editar consulta");
		System.out.println("<3>Remover consulta");
		System.out.println("<4>Agenda");
		System.out.println("<5>Voltar");
		opt = input.next();

		return opt;
	}

	public static Paciente novoPaciente() {
		Paciente paciente = new Paciente();

		System.out.println("Primeiro nome:");
		String primeiroNome = input.next();
		paciente.setPrimeiroNome(primeiroNome);
		System.out.println("Segundo nome:");
		String segundoNome = input.next();
		paciente.setSegundoNome(segundoNome);
		System.out.println("CPF:");
		String cpf = input.next();
		paciente.setCpf(cpf);
		try {
			System.out.println("Data de nascimento ( xx/xx/xxx):");
			String dataNascimento = input.next();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date dt = df.parse(dataNascimento);
			paciente.setDataNascimento(dt);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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

	public static String opcaoEditar() {
		String opt;

		System.out.println("O que deseja editar ?");
		System.out
				.println("<1>Rua  \n<2>Bairro  \n<3>Cidade \n<4>Telefone \n<5>Email");
		opt = input.next();
		return opt;
	}

	public static String editarPaciente(String opt) {
		String entrada = "";
		
		switch (opt) {

		case "1":
			System.out.println("Nova rua- ");
			entrada = input.next();
			break;
		case "2":
			System.out.println("Novo bairro- ");
			entrada = input.next();
			break;
		case "3":
			System.out.println("Nova cidade- ");
			entrada = input.next();
			break;
		case "4":
			System.out.println("Novo telefone- ");
			entrada = input.next();
			break;
		case "5":
			System.out.println("Novo email- ");
			entrada = input.next();
			break;
		default:
		}

		return entrada;
	}

	public static String primeiroNome() {

		System.out.println("Digite o primeiro nome-");
		String nome = input.next();
		return nome;

	}

	public static String segundoNome() {

		System.out.println("Digite o segundo nome-");
		String nome = input.next();
		return nome;

	}

	public static Medico novoMedico() {
		Medico medico = new Medico();

		System.out.println("Primeiro nome:");
		String primeiroNome = input.next();
		medico.setPrimeiroNome(primeiroNome);
		System.out.println("Segundo nome:");
		String segundoNome = input.next();
		medico.setPrimeiroNome(segundoNome);
		System.out.println("CPF:");
		String cpf = input.next();
		medico.setCpf(cpf);
		System.out.println("Bairro:");
		String bairro = input.next();
		medico.setBairro(bairro);
		System.out.println("Cidade:");
		String cidade = input.next();
		medico.setCidade(cidade);
		System.out.println("Especialidade:");
		String especialidade = input.next();
		medico.setEspecialidade(especialidade);
		System.out.println("Login:");
		String login = input.next();
		medico.setLogin(login);
		System.out.println("Senha:");
		String senha = input.next();
		medico.setLogin(senha);

		return medico;
	}

	public static String opcaoEditarMedico() {

		System.out.println("O que deseja editar ?");
		System.out
				.println("<1>Nome  \n<2>CPF  \n<3>Bairro \n<4>Cidade \n<5>Especialidade\n <6>Senha");
		String opt = input.next();

		return opt;
	}

	public static String editarMedico(String opt) {

		String entrada = "";
		switch (opt) {
		case "1":
			System.out.println("Novo nome- ");
			entrada = input.next();
			break;
		case "2":
			System.out.println("Novo CPF- ");
			entrada = input.next();
			break;
		case "3":
			System.out.println("Nova data nascimento- ");
			entrada = input.next();
			break;
		case "4":
			System.out.println("Nova cidade- ");
			entrada = input.next();
			break;
		case "5":
			System.out.println("Nova Especialidade- ");
			entrada = input.next();
			break;
		case "6":
			System.out.println("Nova senha- ");
			entrada = input.next();
			break;
		default:
		}

		return entrada;

	}

	public static String nomeMedico() {

		System.out.println("Digite o nome-");
		String nome = input.next();
		return nome;

	}

	public static String nomeProcedimento() {
		System.out.println("Nome:");
		String nome = input.next();

		return nome;
	}

	public static String novoProcedimento() {
		System.out.println("Novo ome:");
		String nome = input.next();

		return nome;
	}

	public static Date data() {
		Date data = new Date();
		return data;
	}

	public static String hora() {
		System.out.println("Hora (xx:xx)");
		String hora = input.next();

		return hora;
	}

	public static String opcaoEditarConsulta() {
		System.out.println("O que deseja editar ?");
		System.out
				.println("<1>Data  \n<2>Hora  \n<3>Medico \n<4>Paciente \n<5>Procedimento");
		String opt = input.next();

		return opt;
	}

	public static String editarConsulta(String opt) {

		String entrada = "";
		switch (opt) {

		case "2":
			System.out.println("Nova hora- ");
			entrada = input.next();
			break;
		case "3":
			System.out.println("Nova medico- ");
			entrada = input.next();
			break;
		case "4":
			System.out.println("Novo paciente- ");
			entrada = input.next();
			break;
		case "5":
			System.out.println("Novo procedimento- ");
			entrada = input.next();
			break;
		default:

		}

		return entrada;

	}

	public String entradaRepositorioAgenda(int codigo) {
		String entrada = "";

		if (codigo == 1) {
			System.out.println("Nome do paciente:");
			entrada = input.next();
		} else if (codigo == 2) {
			System.out.println("Nome do medico:");
			entrada = input.next();
		} else if (codigo == 3) {
			System.out.println("Nome do procedimento:");
			entrada = input.next();
		} else if (codigo == 4) {
			System.out.println("Data (xx/xx/xxxx)");
			entrada = input.next();
		} else if (codigo == 5) {
			System.out.println("Hora (xx:xx)");
			entrada = input.next();
		} else if (codigo == 6) {
			System.out.println("O que deseja editar ?");
			System.out
					.println("<1>Data  \n<2>Hora  \n<3>Medico \n<4>Paciente \n<5>Procedimento");
			entrada = input.next();
		} else if (codigo == 7) {
			System.out.println("Nova data- ");
			entrada = input.next();
		} else if (codigo == 8) {
			System.out.println("Nova hora- ");
			entrada = input.next();
		} else if (codigo == 9) {
			System.out.println("Novo  medico:");
			entrada = input.next();
		} else if (codigo == 10) {
			System.out.println("Novo paciente:");
			entrada = input.next();
		} else if (codigo == 11) {
			System.out.println("Novo procedimento:");
			entrada = input.next();
		} else if (codigo == 12) {
			System.out.println("Nome para remoção");
			entrada = input.next();
		} else if (codigo == 11) {
			System.out.println("Nome para remoção");
			entrada = input.next();
		}

		return entrada;
	}
   */
}
