package medics.dados;

import medics.negocio.classes_basicas.Medico;

public interface IRepositorioMedico {

	public abstract int getContador();

	public abstract void setContador(int contador);

	public abstract void criarLista();

	public abstract Medico[] getLista() ;

	public abstract void setLista(Medico[] lista);

	public abstract void aumentarArray();

	public abstract void cadastrar(boolean primeiraVez, Medico medico);

	public abstract void modificar(String nome, String opt, String novo);
	
    public abstract void exibir();

	public abstract void remover(String nome);
	
	public abstract Medico verificarLogin(String login, String senha);
}
