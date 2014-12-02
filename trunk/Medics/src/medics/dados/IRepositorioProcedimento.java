package medics.dados;

import medics.negocio.classes_basicas.Procedimento;

public interface IRepositorioProcedimento {

	public int getContador();

	public void setContador(int contador);

	public void criarLista();
	
	public Procedimento[] getLista();

	public void setLista(Procedimento[] lista);

	public void aumentarArray();

	public void cadastrar(boolean primeiraVez, Procedimento procedimento);

	public void modificar(String nomeProcurado, String novoNome);
	
	public void exibir();

	public void remover(String nome);
	
}
