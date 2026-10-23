package pila;

public class Balanceo {

	public static boolean isMatched(String expression) {

		final String opening = "([{";
		final String closing = ")]}";

		LinkedStack<Character> buffer = new LinkedStack<>();

		for (char c : expression.toCharArray()) {

			if (opening.indexOf(c) != -1) {

				buffer.push(c);

			} else if (closing.indexOf(c) != -1) {

				if (buffer.isEmpty())
					return false;

				if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
					return false;
			}
		}

		return buffer.isEmpty();
	}
}