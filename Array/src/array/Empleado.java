package array;
public class Empleado implements Comparable<Empleado> {

	private int legajo;
	private String nombre;

	public Empleado(int legajo, String nombre) {
		this.legajo = legajo;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Empleado [legajo=" + legajo + ", nombre=" + nombre + "]";
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
		if (legajo != other.legajo)
			return false;
		return true;
	}

	@Override
	public int compareTo(Empleado o) {
		return legajo - o.legajo;
		// return nombre.compareTo(o.nombre);
	}

}
