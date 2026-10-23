package craps;


// Fig. 6.10: CrapsTest.java
// Application to test class Craps.

public class CrapsTest {
	private static final int NUM = 100;
	private static final int MAX = 13;

	public static void main(String args[]) {
		int frecuency[] = new int[MAX];

		Craps game = new Craps();
		int cant = 0;
		for (int i = 0; i < NUM; i++) {
			if (game.play(frecuency))
				cant++;
		}
		System.out.println("Numero de partidas: " + NUM + " Ganadas: " + cant);
		for (int i = 2; i < MAX; i++) {
			System.out.println(i + " = " + frecuency[i]);
		}

	} // end main
} // end class CrapsTest

/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/


  
