package medics.dados;

import medics.negocio.classes_basicas.Medico;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.exceptions.ArrayVazioException;
import medics.negocio.exceptions.CpfExistenteException;
import medics.negocio.exceptions.LoginExistenteException;
import medics.negocio.exceptions.NaoEncontradoException;
import medics.negocio.exceptions.SenhaExistenteException;
import medics.negocio.CadastroMedico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class RepositorioMedico implements IRepositorioMedico {
	ArrayList<Medico> lista;
	public static CadastroMedico cadastroMedico = new CadastroMedico();

	private static RepositorioMedico instance;

	public static IRepositorioMedico getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	private static RepositorioMedico lerDoArquivo() {
		RepositorioMedico instanciaLocal = null;

		File in = new File("repositorioMedico.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioMedico) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioMedico();
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
		File out = new File("repositorioMedico.dat");
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
		lista = new ArrayList<Medico>();
	}

	public ArrayList<Medico> getLista() {
		if(lista != null)
		Collections.sort(lista);
		return lista;
	}

	public void setLista(ArrayList<Medico> lista) {
		this.lista = lista;
	}
	
	public void cadastrar(Medico medico) throws CpfExistenteException, LoginExistenteException, SenhaExistenteException {
        if(lista == null)
        	criarLista();
        boolean cpf = procurarCpf(medico.getCpf());
        boolean login = procurarLogin(medico.getLogin());
        boolean senha = procurarSenha(medico.getSenha());
		if (!cpf && !login && !senha ) {
			lista.add(medico); 

			//salvarArquivo();
		} else if(cpf){
			throw new CpfExistenteException();
		} else if(login){
			throw new LoginExistenteException();
		}else if(senha){
			throw new SenhaExistenteException();
		}
	}

	public void remover(String cpf){
		int i;
		boolean removeu = false;
		
			for (i = 0; i < lista.size() && removeu == true; i++) {

				if (cpf.equals(lista.get(i).getCpf())) {
					lista.remove(i);
					removeu = true;
					//salvarArquivo();
				}
			}

		
	}

	public void verificarLogin(String login, String senha)
			throws NaoEncontradoException {
		boolean achou = false;
		try {
			for (int i = 0; i < lista.size(); i++) {
				if (login.equals(lista.get(i).getLogin())
						&& senha.equals(lista.get(i).getSenha()))
					achou = true;
			}

			if (achou == false)
				throw new NaoEncontradoException();
			
		} catch (NullPointerException e1) {
			throw new NaoEncontradoException();

		}
	
	}
	
	
	public Medico exibir(String cpf){
		boolean achou = false;
		
		int i;
		for( i=0 ; i<lista.size() && achou == false; i++){
			if(lista.get(i).getCpf().equals(cpf))
				achou = true;
		}
		
		return lista.get(i-1);
	}
	
	public Medico exibirPorLogin(String login, String senha){
		for(int i=0; i<lista.size(); i++){
			if(lista.get(i).getLogin().equals(login) && lista.get(i).getSenha().equals(senha)){
				return lista.get(i);
			}
		}
		
		return new Medico();
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
	
	public boolean procurarLogin(String login) {
		boolean achou = false;
		if (lista != null) {
			for (int i = 0; i < lista.size() && achou == false; i++) {
				if (login.equals(lista.get(i).getLogin()))
					achou = true;
			}
		}
		return achou;
	}
	
	public boolean procurarSenha(String senha) {
		boolean achou = false;
		if (lista != null) {
			for (int i = 0; i < lista.size() && achou == false; i++) {
				if (senha.equals(lista.get(i).getSenha()))
					achou = true;
			}
		}
		return achou;
	}

}
