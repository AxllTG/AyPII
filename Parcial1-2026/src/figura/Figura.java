package figura;

public abstract class Figura {
	private String nombre;
	private Punto origen;

	public Figura(String nombre, Punto origen) {
		super();
		this.nombre = nombre;
		this.origen = origen;
	}

	public abstract double area();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public Punto getOrigen() {
		return origen;
	}

	public void setOrigen(Punto origen) {
		this.origen = origen;
	}

	@Override
	public String toString() {
		return "Figura [nombre=" + nombre + "]";
	}

}
