package hospital;

public class Turno {
	private String fecha;
	private String hora;
	private Paciente paciente;
	private Medico medico;
	public Turno(String fecha, String hora,Paciente paciente, Medico medico) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.paciente = paciente;
		this.medico = medico;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
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
	
	@Override
	public String toString() {
        return "Turno: " + fecha + " " + hora +
               " | Paciente: " + paciente.getNombre() +
               " | Médico: " + medico.getNombre();
    }
	
}
