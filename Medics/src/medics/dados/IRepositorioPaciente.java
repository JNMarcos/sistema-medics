package medics.dados;

import java.io.Serializable;
import java.util.ArrayList;

import medics.negocio.classes_basicas.Paciente;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.CpfExistenteException;
import medics.negocio.exceptions.NaoEncontradoException;

public interface IRepositorioPaciente {

	public abstract void criarLista();

	public abstract ArrayList<Paciente> getLista();

	public abstract void setLista(ArrayList<Paciente> lista);

	public abstract void cadastrar(Paciente paciente) throws CpfExistenteException;
	
	public abstract void remover(String cpf);
	
	public abstract Paciente exibir(String cpf);
	
	public abstract boolean procurarCpf(String cpf);

}
