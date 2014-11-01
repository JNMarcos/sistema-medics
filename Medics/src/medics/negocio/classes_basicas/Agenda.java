/**
 * Esta classe representa uma agenda do consultorio medico.
 * 
 * Limitacoes: API calendar não está sendo usada, 
 * sendo usado uma string para determinar data.
 */

package medics.negocio.classes_basicas;

public class Agenda {
    private Paciente paciente;
    private Medico medico;
    private Procedimento procedimento;
    private String data;
    private String hora;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
}

