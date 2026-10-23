package figura;

public class Circulo extends Figura{
	private double radio;
	public Circulo(String nombre, double radio) {
		super(nombre);
		// TODO Auto-generated constructor stub
		this.radio = radio;
	}
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(radio, 2);
	}
	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * radio;
	}
	@Override
	public String toString() {
		return "Circulo [radio=" + radio + "]";
	}


	
}
