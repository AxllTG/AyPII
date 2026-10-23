package net.datastructures;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Deque<E> {
	private ArrayList<E> element;

	public Deque() {
		this.element = new ArrayList<>();
	}

	public void addFirst(E e) {
		element.add(0, e);
	}

	public void addLast(E e) {
		element.add(e);
	}

	public E removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException("Deque vacio");
		return element.remove(0);
	}

	public E removeLast() {
		if (isEmpty())
			throw new NoSuchElementException("Deque vacio");
		return element.remove(element.size() - 1);
	}

	public E first() {
		if (isEmpty())
			throw new NoSuchElementException("Deque vacio");
		return element.get(0);
	}

	public E last() {
		if (isEmpty())
			throw new NoSuchElementException("Deque vacio");
		return element.get(element.size() - 1);
	}

	public boolean isEmpty() {
		return element.isEmpty();
	}

	public int size() {
		return element.size();
	}
	
	public void clear() {
		element.clear();
	}
	 @Override
	    public String toString() {
	        return "Deque" + element.toString();
	    }
}
