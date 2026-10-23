package test;
import net.datastructures.*;

public class TestDeque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayCircularDeque<Integer> c = new ArrayCircularDeque<Integer>(200000);
		
		c.addFirst(10);

		c.addFirst(20);

		c.addFirst(30);

		c.addFirst(40);
		
		System.out.println(c);
		
	}

}
