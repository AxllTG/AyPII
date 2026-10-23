package empresa;

public class Empleado {
	private String nombre;
	private String documento;
	public Empleado(String nombre, String documento) {
		super();
		this.nombre = nombre;
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", documento=" + documento + "]";
	}
	
	
}
