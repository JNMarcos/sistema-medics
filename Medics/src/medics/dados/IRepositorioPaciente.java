package medics.dados;

import medics.negocio.classes_basicas.Paciente;

public interface IRepositorioPaciente {
	

	public abstract int getContador();

	public abstract void setContador(int contador);
	
	public abstract void criarLista();

	public abstract Paciente[] getLista();

	public abstract void setLista(Paciente[] lista);

	public abstract void aumentarArray();

	public abstract void cadastrar(boolean primeiraVez, Paciente paciente);

	public abstract void modificar(String nome, String opt, String novo) ;
	
	public abstract void exibir();
	 
	public abstract void remover(String nome);

}
