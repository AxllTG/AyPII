package banco;

public class Cliente {
	private String nombre;
	private String dni;
	private static final int MAX_CUENTA = 5;
	private Cuenta[] cuentas;
	private int cantidadCuentas;

	public Cliente(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.cuentas = new Cuenta[MAX_CUENTA];
		this.cantidadCuentas = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getMAX_CUENTA() {
		return MAX_CUENTA;
	}

	public Cuenta[] getCuentas() {
		return cuentas;
	}

	public void setCuentas(Cuenta[] cuentas) {
		this.cuentas = cuentas;
	}

	public int getCantidadCuentas() {
		return cantidadCuentas;
	}

	public void setCantidadCuentas(int cantidadCuentas) {
		this.cantidadCuentas = cantidadCuentas;
	}

	public void agregarCuenta(Cuenta cuenta) {
		if (cantidadCuentas >= MAX_CUENTA) {
			throw new IllegalStateException("El cliente ya tiene el maximo de " + MAX_CUENTA + "cuentas permitidas");
		}
		cuentas[cantidadCuentas] = cuenta;
		cantidadCuentas++;
	}

	public double calcularSaldo() {
		double totalSaldo = 0;
		for (int i = 0; i < cantidadCuentas; i++) {
			totalSaldo += cuentas[i].getSaldo();
		}
		return totalSaldo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("=== Cliente ===\n");
		sb.append("Nombre: ").append(nombre).append("\n");
		sb.append("DNI: ").append(dni).append("\n");
		sb.append("Cuentas (").append(cantidadCuentas).append("/").append(MAX_CUENTA).append("):\n");
		for (int i = 0; i < cantidadCuentas; i++) {
			sb.append("  ").append(cuentas[i]).append("\n");
		}
		sb.append("Saldo Total: $").append(String.format("%.2f", calcularSaldo()));
		return sb.toString();
	}

}
