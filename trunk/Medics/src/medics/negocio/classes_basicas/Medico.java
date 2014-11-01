/**
 * Essa classe representa um medico do consutorio.
 * 
 * Limitações: apresenta problemas para ter o nome
 * completo de um médico.
 */

package medics.negocio.classes_basicas;

public class Medico {
    private String nome;
    private String cpf;
    private String bairro;
    private String cidade;
    private String especialidade;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
     
}

