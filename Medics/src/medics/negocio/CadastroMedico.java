package medics.negocio;

import java.util.ArrayList;
import java.util.Scanner;

import medics.dados.IRepositorioMedico;
import medics.dados.RepositorioMedico;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.CpfExistenteException;
import medics.negocio.exceptions.LoginExistenteException;
import medics.negocio.exceptions.NaoEncontradoException;
import medics.negocio.exceptions.SenhaExistenteException;

public class CadastroMedico {
	Scanner input = new Scanner(System.in);
	private IRepositorioMedico repositorio;

	public CadastroMedico() {
		this.repositorio = RepositorioMedico.getInstance();
	}

	public void cadastrar(Medico medico) throws CpfExistenteException, LoginExistenteException, SenhaExistenteException {
		repositorio.cadastrar(medico);
	}

	public void remover(String cpf){
		repositorio.remover(cpf);

	}

	public void verificarLogin(String login, String senha)
			throws NaoEncontradoException {
		repositorio.verificarLogin(login, senha);
	}

	public void salvar() {
		RepositorioMedico.salvarArquivo();
	}
	
	public Medico exibir(String cpf){
		return repositorio.exibir(cpf);
	}
	
	public Medico exibirPorLogin(String senha, String login){
		return repositorio.exibirPorLogin(senha,login);
	}
	
	public ArrayList<Medico> getList(){
		return repositorio.getLista();
	}

}
