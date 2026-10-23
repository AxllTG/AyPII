package test;
import pilas.*;

public class PruebaLinkedStack {

	public static void main(String[] args) {

		LinkedStack<Integer> pila = new LinkedStack<>();

		// ================= PUSH =================
		long startPush = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			pila.push(i);
		}

		long endPush = System.currentTimeMillis();

		// ================= TOP =================
		long startTop = System.currentTimeMillis();

		Integer tope = pila.top();

		long endTop = System.currentTimeMillis();

		// ================= POP =================
		long startPop = System.currentTimeMillis();

		while (!pila.isEmpty()) {
			pila.pop();
		}

		long endPop = System.currentTimeMillis();

		// ================= RESULTADOS =================
		System.out.println("Tope: " + tope);

		System.out.println("Tiempo PUSH: "
				+ (endPush - startPush) + " ms");

		System.out.println("Tiempo TOP: "
				+ (endTop - startTop) + " ms");

		System.out.println("Tiempo POP: "
				+ (endPop - startPop) + " ms");
	}
}