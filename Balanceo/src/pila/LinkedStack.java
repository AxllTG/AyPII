package pila;
import net.datastructure.*;
public class LinkedStack<E> implements Stack <E>{
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

}
