package empresa;

public class Contratado extends Personal {
	private double valorHora;
	private double cantHoras;

	public Contratado(String nombre, String dni,Departamento departamento, double valorHora, double cantHoras) {
		super(nombre, dni, departamento);
		// TODO Auto-generated constructor stub
		this.valorHora = valorHora;
		this.cantHoras = cantHoras;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getCantHoras() {
		return cantHoras;
	}

	public void setCantHoras(double cantHoras) {
		this.cantHoras = cantHoras;
	}

	@Override
	public double calcularSueldo() {
		// TODO Auto-generated method stub
		return 0;
	}

}
