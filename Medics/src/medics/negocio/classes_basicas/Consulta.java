/**
 * Esta classe representa uma agenda do consultorio medico.
 * 
 * Limitacoes: API calendar não está sendo usada, 
 * sendo usado uma string para determinar data.
 */

package medics.negocio.classes_basicas;

import java.util.Date;

public class Consulta {
	private Paciente paciente;
	private Medico medico;
	private Procedimento procedimento;
	private Date data;
	private int hora;
	private int minuto;

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

}