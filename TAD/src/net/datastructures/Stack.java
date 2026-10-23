package net.datastructures;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<E> {

	private ArrayList<E> element;

	public Stack() {
		this.element = new ArrayList<>();
	}

	public void push(E e) {
		element.add(e);	
		
	}

	public E pop() {
		if (isEmpty())
			throw new EmptyStackException();
		return element.remove(element.size() - 1);
	}

	public E top() {
		if (isEmpty())
			throw new EmptyStackException();
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
	
	
	public String toString() {
		return "Stack"+ element.toString();
	}
}
