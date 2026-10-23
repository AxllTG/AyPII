package empresa;

import java.util.Objects;

public class Empleado {
	private String nombre;
	private int legajo;
	private Empleado supervisor;
	private Departamento departamento;
	

	public Empleado(int legajo, String nombre, Empleado supervisor, Departamento departamento) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
		this.supervisor = supervisor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public Empleado getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Empleado supervisor) {
		this.supervisor = supervisor;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}	
	
	@Override
	public int hashCode() {
		return Objects.hash(legajo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return legajo == other.legajo;
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", legajo=" + legajo + ", supervisor=" + supervisor + ", departamento="
				+ departamento + "]";
	}

	
}

