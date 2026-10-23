package test;

import net.datastructure.*;

public class PruebaDoublyLinkedList {
	
	public static void main(String[] args) {

		DoublyLinkedList<String> lista1 = new DoublyLinkedList<>();
		
		lista1.addFirst("Juan");
		lista1.addFirst("Mariela");
		lista1.addFirst("Juan");
		lista1.addFirst("Ana");
		lista1.addFirst("Juan");
		
		System.out.println(lista1);
		
		System.out.println("searchOccurrence (Juan, 1) >> " + lista1.searchOccurrence("Juan", 1));
		System.out.println("searchOccurrence (Juan, 3) >> " + lista1.searchOccurrence("Juan", 3));
		System.out.println("searchOccurrence (Juan, 4) >> " + lista1.searchOccurrence("Juan", 4));
	}

}
