package hospital;

public class Medico extends Personal{

	public Medico(int legajo, String nombre, int antiguedad) {
		super(legajo, nombre, antiguedad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularSueldo() {
		// TODO Auto-generated method stub
		return (getBasico() * 1.5) + (getBasico() * 0.20 * getAntiguedad());
	}

	@Override
	public String toString() {
		return "Medico: " + super.toString() ;
	}

	
	
}
