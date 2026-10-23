package conjunto;

import java.util.Arrays;

public class ConjuntoEntero {

	private static final int MAX = 101;
	private boolean conjunto[];

	public ConjuntoEntero() {
		conjunto = new boolean[MAX];
	}

	// Implementar
	public void insertarElemento(int i) {
		conjunto[i] = true;
	}

	// Implementar
	public void eliminarElemento(int i) {
		conjunto[i] = false;
	}

	// Implementar
	public ConjuntoEntero union(ConjuntoEntero c) {
		ConjuntoEntero u = new ConjuntoEntero();
		for (int i = 0; i < MAX; i++)
			if (conjunto[i] == true || c.conjunto[i] == true)
				u.insertarElemento(i);
		return u;
	}

	// Implementar
	public ConjuntoEntero interseccion(ConjuntoEntero c) {
		ConjuntoEntero u = new ConjuntoEntero();
		for (int i = 0; i < MAX; i++)
			if (conjunto[i] == true && c.conjunto[i] == true)
				u.insertarElemento(i);
		return u;
	}

	// Implementar
	public ConjuntoEntero diferencia(ConjuntoEntero c) {
		ConjuntoEntero u = new ConjuntoEntero();
		for (int i = 0; i < MAX; i++)
			if (conjunto[i] == true && c.conjunto[i] == false)
				u.insertarElemento(i);

		return u;
	}

	// Implementar
	public String toString() {
		String s = "{ ";
		for (int i = 0; i < MAX; i++)
			if (conjunto[i] == true)
				s += i + " ";

		s += "}";
		return s;
	}

	// Generado con Eclipse
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(conjunto);
		return result;
	}

	// Generado con Eclipse
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConjuntoEntero other = (ConjuntoEntero) obj;
		if (!Arrays.equals(conjunto, other.conjunto))
			return false;
		return true;
	}

}
