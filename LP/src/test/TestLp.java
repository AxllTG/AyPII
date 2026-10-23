package test;

import java.util.Iterator;

import net.datastructures.PositionalList;
import net.datastructures.LinkedPositionalList;
import net.datastructures.Position;

public class TestLp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PositionalList<String> pl = new LinkedPositionalList<String>();
		Position<String> p;
		/*
		 * pl.addLast("Ana"); p = pl.addLast("Juan"); pl.addLast("Omar");
		 * pl.addLast("Maria");
		 * 
		 * pl.addBefore(p, "Samuel"); pl.addAfter(p, "Pedro");
		 * 
		 * pl.set(p, "Luis");
		 */
		pl.addLast("Jose");
		pl.addLast("Pedro");
		pl.addLast("Luis");
		pl.addLast("Pedro");
		pl.addLast("Jose");
/*
		String s;
		Iterator<String> i = pl.iterator();
		while (i.hasNext()) {
			s = i.next();
			if (s.equals("Juan"))
				i.remove();
		}
		*/
		for (String t : pl)
			System.out.println(t);

		if (isPalindrome(pl)) {
			System.out.println("Es Palindromo.");
		} else {
			System.out.println("No es Palindromo");
		}
	}

	public static boolean isPalindrome(PositionalList<String> pl) {
		Position<String> primero = pl.first();
		Position<String> ultimo = pl.last();
		for (int i = 0; i < pl.size() / 2; i++) {
			if (!primero.getElement().equals(ultimo.getElement())) {
				return false;
			} else {
				primero = pl.after(primero);
				ultimo = pl.before(ultimo);
			}
		}
		return true;
	}
}