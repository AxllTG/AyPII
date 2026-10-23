package factura;

public class TestFactuta  {

	public static void main(String[] args) {
		Factura f2 = new Factura("Fortin Republica",22222,"2017-05-05");
		
		f2.agregarItems("Tornillos", 50, 1.5);
		f2.agregarItems("Clavos", 100, 0.5);
		System.out.println(f2);
		
		// Juan no tiene supervisor
		Empleado e1 = new Empleado(1234, "Juan", null, 40, 25);
		// Juan es el supervisor de Ana
		Empleado e2 = new Empleado(1235, "Ana", e1, 40, 15);

		PorPagar[] pagos = new PorPagar[10];
		
		pagos [0] = e1;
		pagos[1] = f2;
		pagos[2] = e2;
		
		for(int i = 0; i < 3 ; i++) {
			System.out.println("Pago: " + pagos[i].obtenerPago());
		}
		
	}

}
