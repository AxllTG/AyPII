package hospital;

public abstract class Personal {
	private int legajo;
	private String nombre;
	private double basico = 10000;
	private int antiguedad;

	public Personal(int legajo, String nombre, int antiguedad) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.antiguedad = antiguedad;
	}

		public abstract double calcularSueldo();
	
	
	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getBasico() {
		return basico;
	}

	public void setBasico(double basico) {
		this.basico = basico;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	@Override
	public String toString() {
		return nombre + "(Legajo: " + legajo + ")";
	}



}
