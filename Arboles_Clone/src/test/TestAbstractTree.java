package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class TestAbstractTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
		
		Position<String> posA = t.addRoot("A");
		Position<String> posB = t.addLeft(posA, "B");
		Position<String> posC = t.addRight(posA, "C");
		Position<String> posD = t.addLeft(posB, "D");
		Position<String> posE = t.addRight(posB, "E");
		Position<String> posF = t.addLeft(posC, "F");
		Position<String> posG = t.addRight(posC, "G");
		
		System.out.println(t.postorder());
	}

}
