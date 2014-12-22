package medics.dados;

import medics.negocio.classes_basicas.Procedimento;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.CpfExistenteException;
import medics.negocio.exceptions.NaoEncontradoException;
import medics.negocio.CadastroProcedimento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioProcedimento implements IRepositorioProcedimento, Serializable {
	ArrayList<Procedimento> lista;
	public static CadastroProcedimento cadastroProcedimento = new CadastroProcedimento();

	private static RepositorioProcedimento instance;

	public static IRepositorioProcedimento getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	private static RepositorioProcedimento lerDoArquivo() {
		RepositorioProcedimento instanciaLocal = null;

		File in = new File("repositorioProcedimento.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioProcedimento) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioProcedimento();
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
		File out = new File("repositorioProcedimento.dat");
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
		lista = new ArrayList<Procedimento>();
	}

	public ArrayList<Procedimento> getLista() {
		if(lista != null)
			Collections.sort(lista);
		return lista;
	}

	public void setLista(ArrayList<Procedimento> lista) {
		this.lista = lista;
	}

	public void cadastrar(Procedimento procedimento) {

		if (lista == null)
			criarLista();

		lista.add(procedimento);
		salvarArquivo();

	}

	public void remover(String nome) {
		int i;
		boolean removeu = false;

		for (i = 0; i <= lista.size() && removeu == true; i++) {
			String auxiliarNome = lista.get(i).getNome();

			if (nome.equals(auxiliarNome)) {
				lista.remove(i);
				removeu = true;
				salvarArquivo();
			}
		}

	}

}
