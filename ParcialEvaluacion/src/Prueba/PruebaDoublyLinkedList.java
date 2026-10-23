package Prueba;

import net.datastructures.*;

public class PruebaDoublyLinkedList {
	
	public static void main(String[] args) {

		DoublyLinkedList<String> lista1 = new DoublyLinkedList<>();
		
		lista1.addFirst("Juan");
		lista1.addFirst("Mariela");
		lista1.addFirst("soule");
		lista1.addFirst("Ana");
		lista1.addFirst("siu");
		
		System.out.println(lista1);
		
		System.out.println(">> posicion: " + lista1.lastIndexOF("siu"));
		
	}

}
