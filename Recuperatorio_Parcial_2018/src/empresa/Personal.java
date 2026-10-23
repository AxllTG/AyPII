package empresa;
public abstract class Personal {
	private String nombre;
	private String email;
	private double valorHora;
	public Personal(String nombre, String email, double valorHora) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.valorHora = valorHora;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getValorHora() {
		return valorHora;
	}
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	@Override
	public String toString() {
		return "Personal [nombre=" + nombre + ", email=" + email + ", valorHora=" + valorHora + "]";
	}
	
	
	
	
}
