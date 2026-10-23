package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class TestClone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBinaryTree<Integer> t1 = new LinkedBinaryTree<Integer>();
		
		Position<Integer> posA = t1.addRoot(1);
		Position<Integer> posB = t1.addLeft(posA, 2);
		Position<Integer> posC = t1.addRight(posA, 3);
		
		for(Position<Integer> s : t1.preorder()) {
			System.out.println(s.getElement());
		}
		
		LinkedBinaryTree<Integer> t2 = null;
		try {
			t2 = t1.clone();
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		System.out.println(">>Clone: ");
		for(Position<Integer> s1 : t2.preorder()) {
			System.out.println(s1.getElement());
		}
	}

}
