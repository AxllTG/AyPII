package test;
import net.datastructure.*;


public class PruebaSinglyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList<String> lista1 = new SinglyLinkedList<>();
		SinglyLinkedList<String> lista2 = new SinglyLinkedList<>();
		
		
		lista1.addFirst("Juan");
		lista1.addFirst("Mariela");
		lista1.addFirst("Juan");
		lista1.addFirst("Ana");
		lista1.addFirst("Juan");
		
		System.out.println("Lista 1: " + lista1);
		System.out.println(lista1.addBefore("Omar", "Juan"));
		System.out.println("La lista 1 con los elementos insertado es:\n" + lista1);
		
		System.out.println("------------------------------------------");
		
		lista2.addFirst("Juan");
		lista2.addFirst("Mariela");
		lista2.addFirst("Juan");
		lista2.addFirst("Ana");
		lista2.addFirst("Juan");
		
		System.out.println("lista 2" + lista2);
		System.out.println(lista2.addBefore("Omar", "Pablo"));
		System.out.println("La lista 2 queda sin cambios: " + lista2);
	}

}
