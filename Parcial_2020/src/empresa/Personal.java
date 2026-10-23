package empresa;

import java.util.Objects;

public abstract class Personal {
	private String nombre;
	private String dni;
	private Departamento departamento;

	public Personal(String nombre, String dni, Departamento departamento) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.departamento = departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public abstract double calcularSueldo();

	@Override
	public String toString() {
		return "Personal [nombre=" + nombre + ", dni=" + dni + ", departamento=" + departamento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personal other = (Personal) obj;
		return Objects.equals(dni, other.dni);
	}

}
