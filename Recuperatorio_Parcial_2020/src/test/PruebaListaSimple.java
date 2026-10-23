package test;

import net.datastructures.*;

public class PruebaListaSimple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		conjuntoVacio();
		primerConjuntoVacio();
		segundoConjuntoVacio();
		unionConjuntos();
	}

	public static void conjuntoVacio() {
		SinglyLinkedList<String> lista1 = new SinglyLinkedList<String>();
		SinglyLinkedList<String> lista2 = new SinglyLinkedList<String>();

		System.out.println(lista1.union(lista2));
	}

	public static void primerConjuntoVacio() {
		SinglyLinkedList<String> lista1 = new SinglyLinkedList<String>();
		SinglyLinkedList<String> lista2 = new SinglyLinkedList<String>();

		lista2.addLast("W");
		lista2.addLast("S");
		lista2.addLast("X");

		System.out.println(lista1.union(lista2));
	}

	public static void segundoConjuntoVacio() {
		SinglyLinkedList<String> lista1 = new SinglyLinkedList<String>();
		SinglyLinkedList<String> lista2 = new SinglyLinkedList<String>();

		lista1.addLast("A");
		lista1.addLast("S");
		lista1.addLast("D");

		System.out.println(lista1.union(lista2));

	}

	public static void unionConjuntos() {
		SinglyLinkedList<String> lista1 = new SinglyLinkedList<String>();
		SinglyLinkedList<String> lista2 = new SinglyLinkedList<String>();

		lista1.addLast("A");
		lista1.addLast("S");
		lista1.addLast("D");

		lista2.addLast("W");
		lista2.addLast("S");
		lista2.addLast("X");

		System.out.println(lista1.union(lista2));

	}

}
