package empresa;

public class Empleado extends Personal{

	private double sueldo;
	public Empleado(String nombre, String dni, Departamento departamento, double sueldo) {
		super(nombre, dni, departamento);
		// TODO Auto-generated constructor stub
		this.sueldo = sueldo;
	}
	
	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public double calcularSueldo() {
		// TODO Auto-generated method stub
		return sueldo;
	}

	
}
