package hospital;

public class Enfermero extends Personal {

	public Enfermero(int legajo, String nombre, int antiguedad) {
		super(legajo, nombre, antiguedad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularSueldo() {
		// TODO Auto-generated method stub
		return  getBasico() + (getBasico() * 0.10 * getAntiguedad());
	}

	@Override
	public String toString() {
		return "Enfermero: " + super.toString();
	}


	
}
