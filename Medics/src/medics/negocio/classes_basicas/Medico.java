/**
 * Essa classe representa um medico do consutorio.
 * 
 * Limitações: apresenta problemas para ter o nome
 * completo de um médico.
 */

package medics.negocio.classes_basicas;

public class Medico extends Pessoa{
    private String especialidade;
    private String login;
    private String senha;
	
	public String getEspecialidade() {
		return especialidade;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
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
	   
}