package polimorfismo;

import progression.*;

public class TestProgression {

	public static void main(String[] args) {
		AbstractProgression[] prog = new AbstractProgression[6];

		prog[0] = new ArithmeticProgression();
		prog[1] = new ArithmeticProgression(2,0); // 0,2,4,6
		
		prog[2] = new GeometricProgression(); // 0, 1, 1, 2
		prog[3] = new GeometricProgression(3,1); // 1, 3, 9, 27...
		
		
		prog[4] = new FibonacciProgression();
		prog[5] = new FibonacciProgression(4, 6);
		
		for(int i = 0; i < prog.length; i++) {
			System.out.print("Progresiones " + (i + 1) + ": ");
			prog[i].advance(10); // imprime 10 valores
		}
		
	}

}
