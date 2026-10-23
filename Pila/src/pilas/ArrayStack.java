package pilas;

import java.util.Arrays;

import net.datastructure.*;

public class ArrayStack<E> implements Stack<E>, Cloneable {
	public static final int CAPACITY = 1000;
	private E[] data;
	private int t = -1;

	public ArrayStack() {
		this(CAPACITY);
	}

	public ArrayStack(int capacity) {
		data = (E[]) new Object[capacity];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return (t + 1);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (t == -1);
	}

	@Override
	public void push(E e) throws IllegalStateException {
		// TODO Auto-generated method stub
		if (size() == data.length)
			throw new IllegalStateException("Stack is full");
		data[++t] = e;
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		if (isEmpty())
			return null;
		return data[t];
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if (isEmpty())
			return null;
		E answer = data[t];
		data[t] = null;
		t--;
		return answer;
	}

	@Override
	public ArrayStack<E> clone() {
		ArrayStack<E> copia = new ArrayStack<>(data.length);
		copia.t = this.t;
		for (int i = 0; i <= t; i++) {
			copia.data[i] = this.data[i];
		}
		return copia;
	}

}
