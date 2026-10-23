package pilas;

import net.datastructure.*;

public class LinkedStack<E> implements Stack<E>, Cloneable {
	SinglyLinkedList<E> list = new SinglyLinkedList<>();

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public void push(E element) {
		// TODO Auto-generated method stub
		list.addFirst(element);
		return;
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		return list.first();
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}

	@Override
	public LinkedStack<E> clone() {

		LinkedStack<E> copia = new LinkedStack<>();
		LinkedStack<E> auxiliar = new LinkedStack<>();

		/*
		 * Copiamos los elementos de la pila original a una pila auxiliar
		 */
		while (!this.isEmpty()) {
			E elem = this.pop();
			auxiliar.push(elem);
		}

		/*
		 * Restauramos la pila original y armamos la copia
		 */
		while (!auxiliar.isEmpty()) {

			E elem = auxiliar.pop();

			this.push(elem);
			copia.push(elem);
		}

		return copia;
	}

}
