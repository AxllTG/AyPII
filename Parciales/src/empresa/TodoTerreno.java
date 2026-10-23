package empresa;

public class TodoTerreno extends Vehiculo {
	private double valorDia;
	private double valorKm;

	public TodoTerreno(String patente, String marca, int modelo, double valorDia, double valorKm) {
		super(patente, marca, modelo);
		this.valorDia = valorDia;
		this.valorKm = valorKm;
	}

	public double getValorDia() {
		return valorDia;
	}

	public void setValorDia(double valorDia) {
		this.valorDia = valorDia;
	}

	public double getValorKm() {
		return valorKm;
	}

	public void setValorKm(double valorKm) {
		this.valorKm = valorKm;
	}

	@Override
	public double CalcularAquiler(int dias, int kms) {
		return (valorDia * dias) + (valorKm * kms);
	}



	
	
}
