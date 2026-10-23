package lista;

import java.util.Iterator;

import net.datastructures.ArrayList;
import net.datastructures.List;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l = new ArrayList<Integer>();

		for (int i = 0; i < 30; i++)
			l.add(i, i * 2);
		/*
		 * for(int i = 0; i < 30; i++) System.out.println(l.get(i));
		 * 
		 * for(Integer i:l) System.out.println(i);
		 */
		Iterator<Integer> i = l.iterator();
		while (i.hasNext()) {
			int n = i.next();
			System.out.println(n);

		}
	}

}
