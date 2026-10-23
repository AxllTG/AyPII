package pilas;

public class Empleado {
	private String nombre;
	private double horasTrabajadas;
	private double valorHora;
	public Empleado(String nombre, double horasTrabajadas, double valorHora) {
		super();
		this.nombre = nombre;
		this.horasTrabajadas = horasTrabajadas;
		this.valorHora = valorHora;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getHorasTrabajadas() {
		return horasTrabajadas;
	}
	public void setHorasTrabajadas(double horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	public double getValorHora() {
		return valorHora;
	}
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	
	public double calcularSueldo() {
		return horasTrabajadas * valorHora;
	}
	
	
	
}
