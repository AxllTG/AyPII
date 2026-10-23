package Test;
import empresa.*;


public class PruebaVehiculo {

	public static void main(String[] args) {	
	    
        // 1. Crear clientes
        Cliente cliente1 = new Cliente("Juan Pérez", "30123456");
        Cliente cliente2 = new Cliente("María López", "27876543");

        // 2. Crear instancias de distintos tipos de Vehiculo
        Moto moto = new Moto("ABC123", "Honda", 2022, 1800.0);
        Coche coche = new Coche("DEF456", "Toyota Corolla", 2023, 28.5);
        TodoTerreno todoterreno = new TodoTerreno("GHI789", "Jeep Renegade", 2024, 3200.0, 45.0);

        // 3. Crear array de Alquiler
        Alquiler[] alquileres = new Alquiler[3];

        // 4. Cargar los alquileres
        alquileres[0] = new Alquiler(5, 0, moto, cliente1);           // Moto: solo días
        alquileres[1] = new Alquiler(3, 450, coche, cliente2);        // Coche: solo km
        alquileres[2] = new Alquiler(4, 320, todoterreno, cliente1);  // TodoTerreno: días + km

        // 5. Recorrer el array y mostrar la información
        System.out.println("=== ALQUILERES REGISTRADOS ===\n");
        
        for (Alquiler alquiler : alquileres) {
            Vehiculo v = alquiler.getVehiculo();
            Cliente c = alquiler.getCliente();
            
            System.out.println("Cliente: " + c.getNombre() + " (" + c.getDni() + ")");
            System.out.println("Vehículo: " + v.getMarca() + " - " + v.getModelo() + 
                             " (" + v.getPatente() + ")");
            
            // Mostrar tipo de vehículo
            if (v instanceof Moto) {
                System.out.println("Tipo: Moto");
            } else if (v instanceof Coche) {
                System.out.println("Tipo: Coche");
            } else if (v instanceof TodoTerreno) {
                System.out.println("Tipo: Todo Terreno");
            }
            
            System.out.println("Días: " + alquiler.getCantDias() + 
                             " | Km: " + alquiler.getCantKms());
            System.out.println("Importe total: $" + String.format("%.2f", alquiler.calcularCostoTotal()));
            System.out.println("---------------------------------------------");
        }
    }

}
