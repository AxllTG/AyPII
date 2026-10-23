package banco;

public class CuentaCorriente extends Cuenta {
	private static final double DESCUBIERTO = 5000.00;

	public CuentaCorriente(int nroCuenta) {
		super(nroCuenta);
		// TODO Auto-generated constructor stub
	}
	  public CuentaCorriente(int nroCuenta, double saldoInicial) {
	        super(nroCuenta, saldoInicial);
	    }
	  @Override
	  public void extraer(double importe) {
		// TODO Auto-generated method stub
		if (importe <= 0) {
			throw new IllegalArgumentException("El importe a extraer debe ser mayor a 0.");
		}
		if(importe > saldo + DESCUBIERTO) {
			throw new IllegalArgumentException("Limite de descubierto alcanzado. No se puede extraer"
					+ String.format("%.2f", importe) + ". Disponible	"
							+ "(con descubierto): " 
					+ String.format("%.2f", saldo + DESCUBIERTO));
		}
		 saldo -= importe;
		  
	  }
	 public double getDESCUBIERTO() {
		 return DESCUBIERTO;
	 }

	 @Override
	 public String toString() {
		 return "[Cuenta Corriente]" + super.toString() 
		 + " | Descubierto disponible: " + String.format("%.2f", DESCUBIERTO);
		 
	 }
	
	

}
