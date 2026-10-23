package cuenta;

public class CajaDeAhorro extends CuentaBancaria {

    public CajaDeAhorro(int numeroCuenta, Cliente titular, double saldoInicial) {
        super(numeroCuenta, titular, saldoInicial);
    }

    @Override
    public void extraer(double monto) {
        if (saldo - monto >= 0) {
            saldo -= monto;
            System.out.println("Extracción realizada. Nuevo saldo: " + saldo);
        } else {
            System.out.println("No se puede extraer. Saldo insuficiente.");
        }
    }
}
