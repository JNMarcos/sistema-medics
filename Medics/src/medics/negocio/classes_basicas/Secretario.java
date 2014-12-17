package medics.negocio.classes_basicas;

import medics.negocio.Fachada;
import medics.negocio.IFachada;
import medics.negocio.exceptions.NaoEncontradoException;

public class Secretario {
	private String login = "admin";
	private String senha = "admin";
	
	/*private static IFachada instance;
	
	private Secretario(){
		 // Construtor privado para evitar instanciação fora da classe
	}
	
	/**
	 * Implementando padrão Singleton
	 * 
	 * @return A instância da desta fachada
	 
	public static IFachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }*/
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void verificarLogin(String login, String senha) throws NaoEncontradoException {
	    
        if(!login.equals(this.login) || !senha.equals(this.senha)) 
        	throw  new NaoEncontradoException();

	}

}
