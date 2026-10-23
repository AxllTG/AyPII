package test;
import pilas.*;

public class PruebaEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedStack<Empleado> pila = new LinkedStack<>();
		
		pila.push(new Empleado("Ana", 40 ,5000));
		pila.push(new Empleado("Jose",35, 6200));
		pila.push(new Empleado("Maria",50,4500));
		
		
		while(!pila.isEmpty()) {
			Empleado e = pila.pop();
			
			System.out.println("Empleado: " + e.getNombre());
			System.out.println("Sueldo: " + e.calcularSueldo());
			System.out.println("----------------------------------");
			
			
		}
	}

}
