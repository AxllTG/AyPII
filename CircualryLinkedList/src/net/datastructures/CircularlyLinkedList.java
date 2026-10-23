	/*
	 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
	 *
	 * Developed for use with the book:
	 *
	 *    Data Structures and Algorithms in Java, Sixth Edition
	 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
	 *    John Wiley & Sons, 2014
	 *
	 * This program is free software: you can redistribute it and/or modify
	 * it under the terms of the GNU General Public License as published by
	 * the Free Software Foundation, either version 3 of the License, or
	 * (at your option) any later version.
	 *
	 * This program is distributed in the hope that it will be useful,
	 * but WITHOUT ANY WARRANTY; without even the implied warranty of
	 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	 * GNU General Public License for more details.
	 *
	 * You should have received a copy of the GNU General Public License
	 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
	 */
	package net.datastructures;
	
	import java.util.Objects;
	
	/**
	 * An implementation of a circularly linked list.
	 *
	 * @author Michael T. Goodrich
	 * @author Roberto Tamassia
	 * @author Michael H. Goldwasser
	 */
	public class CircularlyLinkedList<E> {
		// ---------------- nested Node class ----------------
		/**
		 * Singly linked node, which stores a reference to its element and to the
		 * subsequent node in the list.
		 */
		private static class Node<E> {
	
			/** The element stored at this node */
			private E element; // an element stored at this node
	
			/** A reference to the subsequent node in the list */
			private Node<E> next; // a reference to the subsequent node in the list
	
			/**
			 * Creates a node with the given element and next node.
			 *
			 * @param e the element to be stored
			 * @param n reference to a node that should follow the new node
			 */
			public Node(E e, Node<E> n) {
				element = e;
				next = n;
			}
	
			// Accessor methods
			/**
			 * Returns the element stored at the node.
			 * 
			 * @return the element stored at the node
			 */
			public E getElement() {
				return element;
			}
	
			/**
			 * Returns the node that follows this one (or null if no such node).
			 * 
			 * @return the following node
			 */
			public Node<E> getNext() {
				return next;
			}
	
			// Modifier methods
			/**
			 * Sets the node's next reference to point to Node n.
			 * 
			 * @param n the node that should follow this one
			 */
			public void setNext(Node<E> n) {
				next = n;
			}
		} // ----------- end of nested Node class -----------
	
		// instance variables of the CircularlyLinkedList
		/** The designated cursor of the list */
		private Node<E> tail = null; // we store tail (but not head)
	
		/** Number of nodes in the list */
		private int size = 0; // number of nodes in the list
	
		/** Constructs an initially empty list. */
		public CircularlyLinkedList() {
		} // constructs an initially empty list
	
		// access methods
		/**
		 * Returns the number of elements in the linked list.
		 * 
		 * @return number of elements in the linked list
		 */
		public int size() {
			return size;
		}
	
		/**
		 * Tests whether the linked list is empty.
		 * 
		 * @return true if the linked list is empty, false otherwise
		 */
		public boolean isEmpty() {
			return size == 0;
		}
	
		/**
		 * Returns (but does not remove) the first element of the list
		 * 
		 * @return element at the front of the list (or null if empty)
		 */
		public E first() { // returns (but does not remove) the first element
			if (isEmpty())
				return null;
			return tail.getNext().getElement(); // the head is *after* the tail
		}
	
		/**
		 * Returns (but does not remove) the last element of the list
		 * 
		 * @return element at the back of the list (or null if empty)
		 */
		public E last() { // returns (but does not remove) the last element
			if (isEmpty())
				return null;
			return tail.getElement();
		}
	
		// update methods
		/**
		 * Rotate the first element to the back of the list.
		 */
		public void rotate() { // rotate the first element to the back of the list
			if (tail != null) // if empty, do nothing
				tail = tail.getNext(); // the old head becomes the new tail
		}

		/**
		 * Adds an element to the front of the list.
		 * 
		 * @param e the new element to add
		 */
		public void addFirst(E e) { // adds element e to the front of the list
			if (size == 0) {
				tail = new Node<>(e, null);
				tail.setNext(tail); // link to itself circularly
			} else {
				Node<E> newest = new Node<>(e, tail.getNext());
				tail.setNext(newest);
			}
			size++;
		}
	
		/**
		 * Adds an element to the end of the list.
		 * 
		 * @param e the new element to add
		 */
		public void addLast(E e) { // adds element e to the end of the list
			addFirst(e); // insert new element at front of list
			tail = tail.getNext(); // now new element becomes the tail
		}
	
		/**
		 * Removes and returns the first element of the list.
		 * 
		 * @return the removed element (or null if empty)
		 */
		public E removeFirst() { // removes and returns the first element
			if (isEmpty())
				return null; // nothing to remove
			Node<E> head = tail.getNext();
			if (head == tail)
				tail = null; // must be the only node left
			else
				tail.setNext(head.getNext()); // removes "head" from the list
			size--;
			return head.getElement();
		}
	
		public void addPos(E e, int n) throws IndexOutOfBoundsException {
			if(n < 0 || n > size )
				throw new IndexOutOfBoundsException("Indice invalido: " + n);
				
			if(n == 0) {
				addFirst(e);
			return;
		}
			
			if (n == size) {
				addLast(e);
				return;
			}
	
			Node<E> actual = tail.getNext();
			for (int i = 0; i < n - 1; i++)
				actual = actual.getNext();
	
			Node<E> newest = new Node<>(e, actual.getNext());
			actual.setNext(newest);
			size++;
		}
		public E removeElement(E e) {
			if(isEmpty())
				return null;
			
		    // Caso especial: el elemento está en head (tail.getNext())
		    if (tail.getNext().getElement().equals(e))
		        return removeFirst();

		    // Recorrer mirando siempre el SIGUIENTE nodo para tener acceso al anterior
		    // En lista circular el recorrido termina cuando volvemos al head
		    Node<E> actual = tail.getNext(); // empezamos en head
		    do {
		        Node<E> siguiente = actual.getNext();
		        if (siguiente.getElement().equals(e)) {
		            // Si el nodo a eliminar es el tail, actualizarlo
		            if (siguiente == tail)
		                tail = actual;
		            // Saltar por encima del nodo encontrado
		            actual.setNext(siguiente.getNext());
		            size--;
		            return siguiente.getElement();
		        }
		        actual = actual.getNext();
		    } while (actual != tail); // recorrimos toda la lista sin encontrarlo

		    return null; // elemento no encontrado
		}
			
			
		
		public E removePos(int n) throws IndexOutOfBoundsException{
			if(n < 0 || n >= size)
				throw new IndexOutOfBoundsException("Indice invalido: " + n);
			
			if(n == 0)
				return removeFirst();
			
			if(n == size - 1) {
				Node<E> actual = tail.getNext();
				
				for(int i = 0; i < size - 2;i++)
					actual = actual.getNext();
				E elemento = tail.getElement();
				
				actual.setNext(tail.getNext());
				tail = actual;
				size--;
				return elemento;
			}
			
			Node<E> actual = tail.getNext();
			for(int i = 0; i < n - 1; i++)
				actual = actual.getNext();
			
			Node<E> toRemove = actual.getNext();	
			actual.setNext(toRemove.getNext());
			size--;
			return toRemove.getElement();
		}
	
		
		public E search(E e) {
			   if (isEmpty()) return null;

			    // Recorrer con do-while para garantizar que visitamos TODOS los nodos
			    // incluido el tail. El while original podía terminar antes de revisarlo
			    // porque tail.getNext() eventualmente devuelve tail mismo, nunca null
			    Node<E> actual = tail.getNext(); // empezamos en head
			    do {
			        if (actual.getElement().equals(e))
			            return actual.getElement();
			        actual = actual.getNext();
			    } while (actual != tail.getNext()); // condición de vuelta al inicio

			    return null; // elemento no encontrado
			}
	  
		/**
		 * Produces a string representation of the contents of the list. This exists for
		 * debugging purposes only.
		 */
		public String toString() {
			if (tail == null)
				return "()";
			StringBuilder sb = new StringBuilder("(");
			Node<E> walk = tail;
			do {
				walk = walk.getNext();
				sb.append(walk.getElement());
				if (walk != tail)
					sb.append(", ");
			} while (walk != tail);
			sb.append(")");
			return sb.toString();
		}
	}
