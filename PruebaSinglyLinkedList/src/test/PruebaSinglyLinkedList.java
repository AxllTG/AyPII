package test;
import net.datastructure.*;

public class PruebaSinglyLinkedList {
	public static void main(String[] args) {
		SinglyLinkedList<String> lista1 = new SinglyLinkedList<String>();
		
		lista1.addFirst("Juan");
		lista1.addLast("Ana");
		lista1.addFirst("Maria");
		
		
		System.out.println(lista1);
		System.out.println(lista1.search("Juan"));
		
		System.out.println(lista1.search("Omar"));
		
		SinglyLinkedList<Integer> lista2 = new SinglyLinkedList<Integer>();
		
		lista2.addFirst(10);
		lista2.addFirst(20);
		lista2.addFirst(30);
		
		System.out.println(lista2);
		
		lista2.removeFirst();
		
		System.out.println(lista2);
	}
	
	
}
