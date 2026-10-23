package figura;

public abstract class Figura {
	private String nombre;

	public Figura(String nombre) {
		super();
		this.nombre = nombre;
	}
	public abstract double area();
	public abstract double perimetro();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Figura [nombre=" + nombre + "]";
	}	
	
}
