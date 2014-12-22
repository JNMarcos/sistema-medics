package medics.dados;

import medics.negocio.classes_basicas.Medico;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.CpfExistenteException;
import medics.negocio.exceptions.LoginExistenteException;
import medics.negocio.exceptions.NaoEncontradoException;
import medics.negocio.exceptions.SenhaExistenteException;

import java.util.ArrayList;

public interface IRepositorioMedico {

	public abstract void criarLista();

	public abstract ArrayList<Medico> getLista();

	public abstract void setLista(ArrayList<Medico> lista);

	public abstract void cadastrar(Medico medico) throws CpfExistenteException, LoginExistenteException, SenhaExistenteException;

	public abstract void remover(String cpf);
	
	public abstract Medico exibir(String cpf);
	
	public abstract Medico exibirPorLogin(String login, String senha);

	public abstract void verificarLogin(String login, String senha) throws NaoEncontradoException;

}
