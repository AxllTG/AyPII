package net.datastructure;

public class SinglyLinkedList<E> implements Cloneable {
    
    // ---------------- nested Node class ----------------
    private static class Node<E> {

        /** El elemento almacenado en este nodo */
        private E element; // referencia al elemento almacenado en este nodo

        /** Una referencia al nodo siguiente en la lista */
        private Node<E> next; // referencia al nodo siguiente en la lista

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    } // ----------- end of nested Node class -----------

    private Node<E> head = null; // nodo cabeza de la lista (o null si está vacía)

    /** El último nodo de la lista */
    private Node<E> tail = null; // último nodo de la lista (o null si está vacía)

    /** Número de nodos en la lista */
    private int size = 0; // número de nodos en la lista

    /** Construye una lista inicialmente vacía. */
    public SinglyLinkedList() {
    } // construye una lista inicialmente vacía

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { // retorna (pero no elimina) el primer elemento
        if (isEmpty())
            return null;
        return head.getElement();
    }

    public E last() { // retorna (pero no elimina) el último elemento
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    public void addFirst(E e) { // agrega el elemento e al principio de la lista
        head = new Node<>(e, head); // crea y enlaza un nuevo nodo
        if (size == 0)
            tail = head; // caso especial: el nuevo nodo también se convierte en tail
        size++;
    }

    public void addLast(E e) { // agrega el elemento e al final de la lista
        Node<E> newest = new Node<>(e, null); // el nodo eventualmente será el tail
        if (isEmpty())
            head = newest; // caso especial: la lista estaba vacía
        else
            tail.setNext(newest); // nuevo nodo después del tail actual
        tail = newest; // el nuevo nodo se convierte en el tail
        size++;
    }

    public E removeFirst() { // elimina y retorna el primer elemento
        if (isEmpty())
            return null; // nada para eliminar
        E answer = head.getElement();
        head = head.getNext(); // será null si la lista solo tenía un nodo
        size--;
        if (size == 0)
            tail = null; // caso especial: la lista ahora está vacía
        return answer;
    }

    public void addPos(E e, int n) throws IndexOutOfBoundsException{
           // Validar que la posición esté dentro del rango [0, size]
        // n == size es válido: equivale a insertar al final
        if(n < 0 || n > size)
            throw new IndexOutOfBoundsException(" Indice Invalido: " + n);
        
        // Reutilizar addFirst que ya actualiza head, tail y size correctamente
        if(n == 0) {		// la primera posición de la lista
            addFirst(e);
            return;
        }
        
        // Reutilizar addLast que ya actualiza tail y size correctamente
        if(n == size) { // la última posición de la lista
            addLast(e);
            return;
        }
        
        // Avanzar hasta el nodo ANTERIOR a la posición deseada (n-1)
        // Necesitamos ese nodo para poder colocar el nuevo en el medio
        Node<E> actual = head;
        
        for (int i = 0 ; i < n-1; i++) // mueve el nodo actual a la posición (n-1)
            actual = actual.getNext();
            
        // Crear un nuevo nodo apuntando ya al nodo que ocupaba la posición n
        // Luego redirigir el nodo anterior hacia el nuevo
        // IMPORTANTE: primero asignar "getNext", luego "setNext"
        // Si se hace al revés perdemos la referencia al resto de la lista
        Node<E> newest = new Node<>(e,actual.getNext());
        actual.setNext(newest);
        size++;
            
    }
    
    public E removeElement(E e) {
        if(isEmpty())
            return null;
        
        if(head.getElement().equals(e))
            return removeFirst();
        
        Node<E> actual = head;
        while(actual.getNext() != null) {
            if(actual.getNext().getElement().equals(e)) {
                Node<E> toRemove = actual.getNext();
                actual.setNext(toRemove.getNext());
                if(toRemove == tail)
                    tail = actual;
                size--;
                return toRemove.getElement();
            }
            actual = actual.getNext();
        }
        return null;
    }
    
    public  E removePos(int n) throws IndexOutOfBoundsException{
        if ( n < 0 || n > size)
            throw new IndexOutOfBoundsException("Indice invalido: " + n );
        if(n == 0)
             return removeFirst();
        
        Node<E> actual = head;
        for(int i = 0; i < n - 1; i++)
            actual = actual.getNext();
        
        Node<E> toRemove = actual.getNext();
        actual.setNext(toRemove.getNext());
        
        if(toRemove == tail)
            tail = actual;
        size--;
        return toRemove.getElement();
            
    }
    
    public void concatenate (SinglyLinkedList<E> l) {
        if(l.isEmpty())
            return;
        
        if(isEmpty())
            head = l.head;
        else
            tail.setNext(l.head); // unir el tail actual con el head de l
        
        tail = l.tail;
        size += l.size;
        
        //dejar l vacia para evitar listas compartidas
        l.head = null;
        l.tail = null;
        l.size = 0;
    }
    
    public E search(E e) {
     Node<E> actual = head;
     while(actual != null) {
         if(actual.getElement().equals(e))
             return actual.getElement();
         actual = actual.getNext();
     }
        return null; // no encontrado.
    }

    
    
    @SuppressWarnings({ "unchecked" })
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        SinglyLinkedList other = (SinglyLinkedList) o; // usa tipo no parametrizado
        if (size != other.size)
            return false;
        Node walkA = head; // recorre la lista principal
        Node walkB = other.head; // recorre la lista secundaria
        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement()))
                return false; // no coinciden
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true; // si llegamos aquí, todo coincidió correctamente
    }

    @SuppressWarnings({ "unchecked" })
    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        // siempre usar Object.clone() heredado para crear la copia inicial
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // conversión segura
        if (size > 0) { // necesitamos una cadena de nodos independiente
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext(); // recorre el resto de la lista original
            Node<E> otherTail = other.head; // recuerda el nodo más recientemente creado
            while (walk != null) { // crea un nuevo nodo con el mismo elemento
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest); // enlaza el nodo anterior con este
                otherTail = newest;
                walk = walk.getNext();
            }
        }
        return other;
    }
    


    public int hashCode() {
        int h = 0;
        for (Node walk = head; walk != null; walk = walk.getNext()) {
            h ^= walk.getElement().hashCode(); // XOR bit a bit con el código del elemento
            h = (h << 5) | (h >>> 27); // desplazamiento cíclico de 5 bits
        }
        return h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
            walk = walk.getNext();
        }
        sb.append("}");
        return sb.toString();
    }
}