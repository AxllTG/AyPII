package test;
import net.datastructures.*;

public class PruebaLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularlyLinkedList<Empleado> lista1 = new CircularlyLinkedList<Empleado>();
		
		lista1.addFirst(new Empleado(10, "Luis"));
		lista1.addFirst(new Empleado(20,"Ana"));
		lista1.addLast(new Empleado(30,"Maria"));
	
		System.out.println(lista1);
		System.out.println("TAMAÑO de la Lista1: ");
		System.out.println(">> " + lista1.size());
		
		
		System.out.println("\n     === BUSQUEDA ===");
		Empleado a = new Empleado(10,"Juan");
		
		System.out.println(lista1.search(a));
		System.out.println(lista1.search(new Empleado(20,null)));
		
		System.out.println("================================\n");
		
		System.out.println("--- Lista1 Modificada ---");
		System.out.println("Remove: " + lista1.first());
		lista1.removeFirst();
		System.out.println(lista1);
		
	}

}
