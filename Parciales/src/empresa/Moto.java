package empresa;

public class Moto extends Vehiculo {
	private double valorDia;

	public Moto(String patente, String marca, int modelo, double valorDia) {
		super(patente, marca, modelo);
		this.valorDia = valorDia;
	}



	public double getValorDia() {
		return valorDia;
	}



	public void setValorDia(double valorDia) {
		this.valorDia = valorDia;
	}



	@Override
	public double CalcularAquiler(int dias, int kms) {
		// TODO Auto-generated method stub
		return  valorDia * dias;
	}


	
}
