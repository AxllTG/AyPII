package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class TestTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBinaryTree<String> t = new LinkedBinaryTree<>();
		
		Position<String> p,q;
		
		p=t.addRoot("A");
		
		q=t.addLeft(p,"B");
		t.addRight(p, "C");
		
		t.addLeft(q, "D");
		t.addRight(q, "E");
		
		
		for(Position<String> s : t.breadthfirst()) {
			System.out.println(s.getElement());
		}
		
		System.out.println("Profundidad: " + t.depth(p));
		System.out.println("Altura: " + t.height(p));
		System.out.println("Tamaño: " + t.size());
		
		
	}

}
