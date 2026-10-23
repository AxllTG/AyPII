package figura;

public class Rectangulo extends Figura{
	private double base;
	private double altura;
	public Rectangulo(String nombre, double base, double altura) {
		super(nombre);
		// TODO Auto-generated constructor stub
		this.base = base;
		this.altura = altura;
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return base * altura;
	}
	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return (2 * base) + (2 * altura);
	}
	@Override
	public String toString() {
		return "Rectangulo [base=" + base + ", altura=" + altura + "]";
	}

	
	
}
