package cuenta;

public abstract class CuentaBancaria {
    protected int numeroCuenta;
    protected Cliente titular;
    protected double saldo;

    public CuentaBancaria(int numeroCuenta, Cliente titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        saldo += monto;
        System.out.println("Depósito realizado. Nuevo saldo: " + saldo);
    }

    public abstract void extraer(double monto);

    public void mostrarDatos() {
        System.out.println("Cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
    }
}

