	package lista;

import java.util.Arrays;

public class Lista<E> {
	
		private E lista[];
		private int indice;
		private final int MAXELEM;
	
		public Lista(int n) {
			lista = (E[]) new Object[n];
			MAXELEM = n;
			indice = 0;
		}
	
		/* Agrega un elemento al final de la lista */
		public void add(E e) throws IndexOutOfBoundsException {
			if (indice == MAXELEM)
				throw new IndexOutOfBoundsException("Lista llena");
			lista[indice++] = e;
		}
	
		/* Agrega un elemento a la lista en la posici�n p */
		public void add(int p, E e) throws IndexOutOfBoundsException {
			if(indice == MAXELEM)
					throw new IndexOutOfBoundsException ( "Lista llena" );
			if(p < 0 || p > indice)
				throw new IndexOutOfBoundsException ( "Indice invalido: " + p );
			
			//desplaza los elementos hacia la derecha desde el final hasta la posicion p
			for(int i = indice; i > p; i--)
				lista[i] = lista [i - 1];
			
			lista[p] = e;
			indice++;
		}
	
		/* Retorna el elemento que se encuentra en p */
		public E get(int p) throws IndexOutOfBoundsException {		
			if (p < 0 || p >= indice)
				throw new IndexOutOfBoundsException("Indice inv�lido: " + p);
			return lista[p];
		}
	
		/* Remueve el elemento E de la lista. Retorna null sino se encuentra */
		public E remove(E e) {
			boolean encontrado = false;
			int i;
			for (i = 0; i < indice && !encontrado; i++)
				if (lista[i].equals(e))
					encontrado = true;
			if (!encontrado)
				return null;
			return remove(i);
		}
	
		/* Remueve el elemento que se encuentra en la posici�n p */
		public E remove(int p) throws IndexOutOfBoundsException {
			if( p < 0 || p >= indice)
				throw new IndexOutOfBoundsException ( "Lista llena" );
			
			E eliminado = lista[p];
			
			// desplaza los elementos hacia la izquierda desde p+1
			for(int i = p; i < indice - 1;i++)
				lista[i] = lista[i + 1];
			
			lista[indice--] = null; // limpia el ultimo lugar y decrementa el indice
			return eliminado;
			
		}
		
		public String toString(){
			String s = "";
			for(int i=0; i<indice; i++)
				s +=lista[i]+"\n";
			return s;
			 
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.deepHashCode(lista);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Lista other = (Lista) obj;
			return Arrays.deepEquals(lista, other.lista);
		}
	}
