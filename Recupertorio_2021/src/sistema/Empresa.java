package sistema;

public class Empresa extends Cliente {
	private static double PORC_DESCUENTO;

	public Empresa(String nombre, String email) {
		super(nombre, email);
		// TODO Auto-generated constructor stub
	}


	@Override
	public double calcularVenta() {
		double total = calcularTotal();
		return total - total * PORC_DESCUENTO /100;
	}


}
