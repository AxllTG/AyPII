package banco;

public class CajaAhorro extends Cuenta {

    public CajaAhorro(int nroCuenta) {
        super(nroCuenta);
    }

    public CajaAhorro(int nroCuenta, double saldoInicial) {
        super(nroCuenta, saldoInicial);
    }

    @Override
    public void extraer(double importe) {
        if (importe <= 0) {
            throw new IllegalArgumentException("El importe a extraer debe ser mayor a 0.");
        }
        if (importe > saldo) {
            throw new IllegalStateException("Saldo insuficiente. No se puede extraer $" 
                + String.format("%.2f", importe) + ". Saldo disponible: $" 
                + String.format("%.2f", saldo));
        }
        saldo -= importe;
    }

    @Override
    public String toString() {
        return "[Caja de Ahorro] " + super.toString();
    }
}