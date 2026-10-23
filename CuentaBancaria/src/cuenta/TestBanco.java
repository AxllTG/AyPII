package cuenta;

public class TestBanco {

	    public static void main(String[] args) {

	        Cliente cliente1 = new Cliente("Axel", "20-12345678-9", "Calle 123", "axel@mail.com");

	        CajaDeAhorro caja = new CajaDeAhorro(1, cliente1, 1000);
	        CuentaCorriente corriente = new CuentaCorriente(2, cliente1, 500, 1000);

	        System.out.println("=== Caja de Ahorro ===");
	        caja.mostrarDatos();
	        caja.depositar(500);
	        caja.extraer(2000); // debería fallar
	        caja.extraer(300);

	        System.out.println("\n=== Cuenta Corriente ===");
	        corriente.mostrarDatos();
	        corriente.depositar(200);
	        corriente.extraer(1200); // permite descubierto
	        corriente.extraer(1000); // supera límite
	    }
	}
