package test;
import net.datastructures.*;

public class PruebaDoublyLinkedList {

	public static void main(String[] args) {
		DoublyLinkedList<Empleado> lista1 = new DoublyLinkedList<Empleado>();
		DoublyLinkedList<String> lista2 = new DoublyLinkedList<String>();
		DoublyLinkedList<Empleado> lista3 = new DoublyLinkedList<Empleado>();
		
		lista1.addFirst(new Empleado(100,"Maria"));
		lista1.addFirst(new Empleado(20,"Roberto"));
		lista1.addLast(new Empleado(300, "Luis"));
		
		lista2.addFirst("lucia");
		lista2.addFirst("luis");
		lista2.addFirst("matias");
		
		lista3.addFirst(new Empleado(100,"Maria"));
		lista3.addFirst(new Empleado(20,"Roberto"));
		lista3.addLast(new Empleado(300, "Luis"));
		
		
		System.out.println("LISTA 1:");
		System.out.println(lista1);
	/*	
		System.out.println("---BUSQUEDA---");
		System.out.println(lista1.search(new Empleado(300,null)));
		*/
		
		System.out.println("lista2 (" + lista2 + ")");
		
		System.out.println(lista2.right(2));
		
/*		
		if(lista1.equals(lista2)) {
			System.out.println("son igules");
		} else {
			System.out.println("Son distintos");
		}
		
		if(lista1.equals(lista3)) {
			System.out.println("son igules");
		} else {
			System.out.println("Son distintos");
		}
	*/	
		
		
			
		
		
	}

}
