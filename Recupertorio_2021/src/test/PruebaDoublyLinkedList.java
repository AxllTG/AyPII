package test;
import net.datastructures.*;


public class PruebaDoublyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList<String> lista1 = new DoublyLinkedList<String>();
		
		lista1.addFirst("verde");
		lista1.addFirst("amarillo");
		lista1.addFirst("azul");
		lista1.addFirst("azul");
		lista1.addFirst("blanco");
		lista1.addFirst("azul");
		lista1.addFirst("rojo");
		
		System.out.println(lista1);
		System.out.println(lista1.lastIndex("azul"));
	}

}
