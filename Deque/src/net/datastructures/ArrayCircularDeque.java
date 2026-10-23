package net.datastructures;

/**
 * Implementación de un Deque (doble cola) usando un arreglo circular.
 *
 * @param <E> tipo de elementos almacenados
 */
public class ArrayCircularDeque<E> implements Deque<E> {

    private static final int DEFAULT_CAPACITY = 16;

    private E[] data;       // arreglo de almacenamiento
    private int front;      // índice del primer elemento
    private int size;       // cantidad de elementos actuales

    // ---- Constructores ----

    @SuppressWarnings("unchecked")
    public ArrayCircularDeque() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public ArrayCircularDeque(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("La capacidad debe ser positiva");
        data = (E[]) new Object[capacity];
        front = 0;
        size = 0;
    }

    // ---- Métodos de la interfaz Deque ----

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return data[front];
    }

    @Override
    public E last() {
        if (isEmpty()) return null;
        int lastIndex = (front + size - 1) % data.length;
        return data[lastIndex];
    }

    @Override
    public void addFirst(E e) {
        if (size == data.length) resize(data.length * 2);
        // Mover front hacia atrás de forma circular
        front = (front - 1 + data.length) % data.length;
        data[front] = e;
        size++;
    }

    @Override
    public void addLast(E e) {
        if (size == data.length) resize(data.length * 2);
        int lastIndex = (front + size) % data.length;
        data[lastIndex] = e;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        E element = data[front];
        data[front] = null;                     // ayuda al garbage collector
        front = (front + 1) % data.length;
        size--;
        return element;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        int lastIndex = (front + size - 1) % data.length;
        E element = data[lastIndex];
        data[lastIndex] = null;                 // ayuda al garbage collector
        size--;
        return element;
    }

    // ---- Métodos auxiliares ----

    /**
     * Redimensiona el arreglo interno a la nueva capacidad indicada.
     * Los elementos se reordenan de forma contigua desde el índice 0.
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
    }

    // ---- toString ----

    @Override
    public String toString() {
        if (isEmpty()) return "Deque[]";
        StringBuilder sb = new StringBuilder("Deque[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % data.length]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

/*package net.datastructures;

public class ArrayCircularDeque<E> implements Deque<E> {
	public static final int CAPACITY = 	; // default array capacity
	private E[] data;
	private int f = 0;
	private int sz = 0;

	public ArrayCircularDeque() {
		this(CAPACITY);
	}

	@SuppressWarnings({ "unchecked" })
	public ArrayCircularDeque(int capacity) {
		data = (E[]) new Object[capacity];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return sz;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (sz == 0);
	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
		if (isEmpty())
			return null;
		return data[f];

	}

	@Override
	public E last() {
		// TODO Auto-generated method stub
		if (isEmpty())
			return null;
		int lastIndex = (f + sz - 1) % data.length;
		return data[lastIndex];
	}

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
		if (sz == data.length)
			resize(data.length * 2);
		data[f] = e;
		sz++;
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		if (sz == data.length)
			resize(data.length * 2);
		int lastIndex = (f + sz - 1) % data.length;
		data[lastIndex] = e;
		sz++;
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		if (isEmpty())
			return null;
		E element = data[f];
		data[f] = null;
		f = (f + 1) % data.length;
		sz--;
		return element;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		if (isEmpty())
			return null;
		int lastIndex = (f + sz - 1) % data.length;
		E element = data[lastIndex];
		data[lastIndex] = null;
		sz--;
		return element;
	}

	@SuppressWarnings("unchecked")
	private void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity];
		for (int i = 0; i < sz; i++) {
			newData[i] = data[(f + i) % data.length];
		}
		data = newData;
		f = 0;
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "Deque[]";
		StringBuilder sb = new StringBuilder("Deque[");
		for (int i = 0; i < sz; i++) {
			sb.append(data[(f + i) % data.length]);
			if (i < sz - 1)
				sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
}
*/