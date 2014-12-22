package medics.negocio.classes_basicas;

import medics.negocio.Fachada;
import medics.negocio.IFachada;
import medics.negocio.exceptions.NaoEncontradoException;

public class Secretario {
	private String login;
	private String senha;
	
	private static Secretario instance;
	
	private Secretario(){
		 this.login = "admin";
		 this.senha = "admin";
	}	
 
	public static Secretario getInstance() {
        if (instance == null) {
            instance = new Secretario();
        }
        return instance;
    }
	
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
