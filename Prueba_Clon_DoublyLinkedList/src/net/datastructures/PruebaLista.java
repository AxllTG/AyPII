package net.datastructures;

public class PruebaLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList<Empleado> lista2 = new DoublyLinkedList<Empleado>();
		
		lista2.addFirst(new Empleado(10, "Juan"));
		lista2.addFirst(new Empleado(20,"Ana"));
		lista2.addLast(new Empleado(30,"Pedro"));
		
        System.out.println("Lista2 = [" + lista2 + "]");

		DoublyLinkedList<Empleado> lista3 = null;
		try {
			lista3 = lista2.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Lista3 (Clon) = [" + lista3 + "]");
	
	}

}
