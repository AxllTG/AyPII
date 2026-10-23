package cuenta;

public class CuentaCorriente extends CuentaBancaria {

    private double limiteDescubierto;

    public CuentaCorriente(int numeroCuenta, Cliente titular, double saldoInicial, double limite) {
        super(numeroCuenta, titular, saldoInicial);
        this.limiteDescubierto = limite;
    }

    @Override
    public void extraer(double monto) {
        if (saldo - monto >= -limiteDescubierto) {
            saldo -= monto;
            System.out.println("Extracción realizada. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Supera el límite de descubierto.");
        }
    }
}