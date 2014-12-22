/**
 * Essa classe representa um procedimento do consultório.
 */

package medics.negocio.classes_basicas;

import java.util.Collections;

public class Procedimento implements Comparable<Procedimento> {
    private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Procedimento other = (Procedimento) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
    public int compareTo(Procedimento procedimento) {
        return this.getNome().compareToIgnoreCase(procedimento.getNome());
        
    }
    
}
