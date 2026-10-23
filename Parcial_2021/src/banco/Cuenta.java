package banco;

public abstract class Cuenta {
	private int nroCuenta;
	protected double saldo;

	public Cuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
		this.saldo = 0.0;
	}

	public Cuenta(int nroCuenta, double saldoInicial) {
		this.nroCuenta = nroCuenta;
		this.saldo = saldoInicial;
	}

	public int getNroCuenta() {
		return nroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void depositar(double importe) {
		if (importe <= 0) {
			throw new IllegalArgumentException("El importe a depositar debe ser mayor a 0.");
		}
		saldo += importe;
	}

	public abstract void extraer(double importe);

	@Override
	public String toString() {
		return "Cuenta N°" + nroCuenta + " | Saldo: $" + String.format("%.2f", saldo);
	}
}