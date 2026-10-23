package test;
import empresa.*;

public class PruebaEmpresa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empleado empleado = new Empleado("Juan Perez", "juanperez1@gmail.com",1500.0);
		Contratado contratado = new Contratado("Ana Lopez", "ana@gmail.com",2000.0);
		
		Proyecto proyecto = new Proyecto(101,"Sistema de Gestion");
		proyecto.setResponsble(empleado);
		
		OrdenTrabajo orden1 = new OrdenTrabajo("Analisis de requerimiento", "2022-02-12", 5);
		
		orden1.setPersonal(empleado);
		orden1.setProyecto(proyecto);
		
		
		OrdenTrabajo orden2 = new OrdenTrabajo("Diseño de base de datos", "2022-02-21",8);
		orden2.setPersonal(contratado);
		orden2.setProyecto(proyecto);
		
		System.out.println("===PROYECTO===");
		System.out.println(proyecto);
		
		System.out.println("\n===ORDEN 1===");
		System.out.println(orden1);	
		System.out.println("Costo: $" + orden1.calcularCosto());

		System.out.println("\n===ORDEN 2===");
		System.out.println(orden2);	
		System.out.println("Costo: $" + orden2.calcularCosto());
	}

}
