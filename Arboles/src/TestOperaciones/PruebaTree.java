package TestOperaciones;

import net.datastructures.ArrayStack;
import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class PruebaTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBinaryTree<String> t = new LinkedBinaryTree<>();

		Position<String> raiz = t.addRoot("*");

		// división y 8
		Position<String> div = t.addLeft(raiz, "/");
		t.addRight(raiz, "8");

		// numerador
		Position<String> mult1 = t.addLeft(div, "*");

		Position<String> suma1 = t.addLeft(mult1, "+");
		t.addLeft(suma1, "5");
		t.addRight(suma1, "2");

		Position<String> resta1 = t.addRight(mult1, "-");
		t.addLeft(resta1, "2");
		t.addRight(resta1, "1");

		// denominador
		Position<String> suma2 = t.addRight(div, "+");

		Position<String> suma3 = t.addLeft(suma2, "+");
		t.addLeft(suma3, "2");
		t.addRight(suma3, "9");

		Position<String> resta2 = t.addRight(suma2, "-");

		Position<String> resta3 = t.addLeft(resta2, "-");
		t.addLeft(resta3, "7");
		t.addRight(resta3, "2");

		t.addRight(resta2, "1");

		StringBuilder postFija = new StringBuilder();

		System.out.println("Recorrido PostOrder: ");

		for (Position<String> p : t.postorder()) {
			System.out.println(p.getElement() + "");
			postFija.append(p.getElement()).append(" ");
		}

		System.out.println();
		System.out.println("\nPostFija:");
		System.out.println(postFija);

		// Pilaaaaa>>>>>>>>>>
		ArrayStack<Double> pila = new ArrayStack<>();

		String[] tokens = postFija.toString().trim().split("\\s+");

		for (String token : tokens) {

			if (esNumero(token)) {
				pila.push(Double.parseDouble(token));
			} else {

				double b = pila.pop();
				double a = pila.pop();

				switch (token) {

				case "+":
					pila.push(a + b);
					break;

				case "-":
					pila.push(a - b);
					break;

				case "*":
					pila.push(a * b);
					break;

				case "/":
					pila.push(a / b);
					break;
				}
			}
		}

		System.out.println("\nResultado = " + pila.pop());
	}

	private static boolean esNumero(String s) {

		try {
			Double.parseDouble(s);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
