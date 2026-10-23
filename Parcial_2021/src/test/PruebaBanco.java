package test;

import banco.*;

public class PruebaBanco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cliente cliente = new Cliente("Juan Perez", "31434932");

		CajaAhorro caja = new CajaAhorro(1001, 1000.00);
		CuentaCorriente cc = new CuentaCorriente(2001, 500.00);

		cliente.agregarCuenta(caja);
		cliente.agregarCuenta(cc);

		System.out.println(cliente);
		System.out.println();

		System.out.println(">> Depositar $200 en Caja de Ahorro");
		caja.depositar(200);
		System.out.println(caja);

		System.out.println(">> Extraer $500 de caja de Ahorro");

		caja.extraer(500);
		System.out.println(caja);

		try {
			System.out.println(">> Intenta extraer $2000 de caja de Ahorro (saldo insuficiente)");
			caja.extraer(2000);
		} catch (IllegalStateException e) {
			System.out.println(" ERROR: " + e.getLocalizedMessage());
		}

		System.out.println();
		
		System.out.println(">> Depositar $300 en Cuenta Corriente");
		caja.depositar(300);
		System.out.println(cc);
		
		System.out.println(">> Extraer $1000 de Cuenta Corriente (usa saldo propio)");
		cc.extraer(1000);
		
		System.out.println(">> Extraer  $4000 de Cuenta Corriente (usa descubierto)");
		cc.extraer(4000);
		System.out.println(cc);
		
		try {
			System.out.println(">> Intenta extraer $6000 de Cuenta Corriente (supera descubierto)");
			cc.extraer(6000);
		} catch (IllegalStateException e) {
			System.out.println(" ERROR: " + e.getMessage());
		}
		
		System.out.println();
		
		
		System.out.println("=== Resumen Final ===");
		System.out.println(cliente);
		
		System.out.println("\n >> Intenta agregar mas de 5 cuentas: ");
		try {
			for(int i = 3;i <= 6; i++) {
				cliente.agregarCuenta(new CajaAhorro(3000 + i));
				System.out.println(" Cuenta " + i + "agregada" );
				
			}
		} catch (IllegalStateException e) {
			System.out.println(" ERROR: " + e.getMessage());
		}
		
	}

}
