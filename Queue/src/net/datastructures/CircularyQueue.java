package net.datastructures;

public interface CircularyQueue<E> {
	int size();

	boolean isEmpty();

	void enqueue(E e);

	E first();

	E dequeue();

	void rotate();

}
