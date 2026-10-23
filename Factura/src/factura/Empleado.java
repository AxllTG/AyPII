package factura;

public class Empleado implements PorPagar {
	private int legajo;
	private String nombre;
	private int horasTrabajada;
	private double valorHora;
	private Empleado supervisor;
	
	public Empleado(int legajo, String nombre,Empleado supervisor, int horasTrabajada, double valorHora) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.supervisor = supervisor;
		this.horasTrabajada = horasTrabajada;
		this.valorHora = valorHora;
	}

	@Override
	public double obtenerPago() {
		// TODO Auto-generated method stub
		return horasTrabajada * valorHora;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	
}
