package medics.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import medics.negocio.classes_basicas.Paciente;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.CpfExistenteException;
import medics.negocio.exceptions.NaoEncontradoException;
import medics.negocio.CadastroPaciente;

public class RepositorioPaciente implements IRepositorioPaciente {
	ArrayList<Paciente> lista;

	private static RepositorioPaciente instance;

	public static RepositorioPaciente getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	private static RepositorioPaciente lerDoArquivo() {
		RepositorioPaciente instanciaLocal = null;

		File in = new File("repositorioPaciente.dat");  
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioPaciente) o; 
		} catch (Exception e) {
			instanciaLocal = new RepositorioPaciente();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {/* Silent exception */
				}
			}
		}

		return instanciaLocal;
	}

	public static void salvarArquivo() {
		if (instance == null) {
			return;
		}
		File out = new File("repositorioPaciente.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {/* Silent */
				}
			}
		}
	}

	public void criarLista() {
		lista = new ArrayList<Paciente>();
	}

	public ArrayList<Paciente> getLista() {
		if(lista != null)
		Collections.sort(lista);
		return lista;
	}

	public void setLista(ArrayList<Paciente> lista) {
		this.lista = lista;
	}

	public void cadastrar(Paciente paciente) throws CpfExistenteException {
        if(lista == null)
        	criarLista();
		if (!procurarCpf(paciente.getCpf())) {
			lista.add(paciente);
			//salvarArquivo();
		} else {
			throw new CpfExistenteException();
		}

	}

	public void remover(String cpf) {
		boolean removeu = false;
		int i;

			for (i = 0; i < lista.size() && removeu == false; i++) {
				if (cpf.equals(lista.get(i).getCpf())) {
					lista.remove(i); 
					removeu = true;
					//salvarArquivo();
				}
			}	
	}
	
	public Paciente exibir(String cpf){
		boolean achou = false;
		
		int i;
		for( i=0 ; i<lista.size() && achou == false; i++){
			if(lista.get(i).getCpf().equals(cpf)) 
				achou = true; 
		}
		
		return lista.get(i-1);
	}

	public boolean procurarCpf(String cpf) {
		boolean achou = false;
		if (lista != null) {
			for (int i = 0; i < lista.size() && achou == false; i++) {
				if (cpf.equals(lista.get(i).getCpf()))
					achou = true;
			}
		}
		return achou;
	}

}
