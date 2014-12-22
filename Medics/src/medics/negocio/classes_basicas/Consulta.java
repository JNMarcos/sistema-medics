/**
 * Esta classe representa uma agenda do consultorio medico.
 * 
 * Limitacoes: API calendar não está sendo usada, 
 * sendo usado uma string para determinar data.
 */

package medics.negocio.classes_basicas;

import java.io.Serializable;
import java.util.Date;

public class Consulta implements Comparable<Consulta>, Serializable {
	private Paciente paciente;
	private Medico medico;
	private Procedimento procedimento;
	private String dia;
	private String mes;
	private String ano;
	private String hora;
	private String codigo;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public int compareTo(Consulta consulta) {
		if (Integer.parseInt(this.getAno()) < Integer.parseInt(consulta
				.getAno())) {
			return -1;
		} else if (Integer.parseInt(this.getAno()) > Integer.parseInt(consulta
				.getAno())) {
			return 1;
		}

		int mesThese = 0;
		int mesComp = 0;
		switch (this.getMes()) {
		case "Jan":
			mesThese = 1;
			break;
		case "Fev":
			mesThese = 2;
			break;
		case "Mar":
			mesThese = 3;
			break;
		case "Abr":
			mesThese = 4;
			break;
		case "Mai":
			mesThese = 5;
			break;
		case "Jun":
			mesThese = 6;
			break;
		case "Jul":
			mesThese = 7;
			break;
		case "Ago":
			mesThese = 8;
			break;
		case "Set":
			mesThese = 9;
			break;
		case "Out":
			mesThese = 10;
			break;
		case "Nov":
			mesThese = 11;
			break;
		case "Dez":
			mesThese = 12;
			break;
		}

		switch (consulta.getMes()) {
		case "Jan":
			mesComp = 1;
			break;
		case "Fev":
			mesComp = 2;
			break;
		case "Mar":
			mesComp = 3;
			break;
		case "Abr":
			mesComp = 4;
			break;
		case "Mai":
			mesComp = 5;
			break;
		case "Jun":
			mesComp = 6;
			break;
		case "Jul":
			mesComp = 7;
			break;
		case "Ago":
			mesComp = 8;
			break;
		case "Set":
			mesComp = 9;
			break;
		case "Out":
			mesComp = 10;
			break;
		case "Nov":
			mesComp = 11;
			break;
		case "Dez":
			mesComp = 12;
			break;
		}

		if (mesThese < mesComp) {
			return -1;
		} else if (mesThese > mesComp) {
			return 1;
		}
		
		if (Integer.parseInt(this.getDia()) < Integer.parseInt(consulta
				.getDia())) {
			return -1;
		} else if (Integer.parseInt(this.getDia()) > Integer.parseInt(consulta
				.getDia())) {
			return 1;
		}
		
		if (Integer.parseInt(this.getHora()) < Integer.parseInt(consulta
				.getHora())) {
			return -1;
		} else if (Integer.parseInt(this.getHora()) > Integer.parseInt(consulta
				.getHora())) {
			return 1;
		}
		
		return 0;

	}
}