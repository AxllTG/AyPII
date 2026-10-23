package comparation;

import java.util.Scanner;

public class Comparation {
	public static void main(String arg[]) {
		Scanner entrada = new Scanner(System.in);

		int n1;
		int n2;

		System.out.print("Ingrese el primer Entero: ");
		n1 = entrada.nextInt();

		System.out.println("Ingrese el segundo Entero: ");
		n2 = entrada.nextInt();

		if (n1 == n2) {
			System.out.printf("%d == %d\n", n1, n2);
		}
		if (n1 != n2) {
			System.out.printf("%d != %d\n", n1, n2);
		}
		if(n1 < n2) {
			System.out.printf("%d < %d\n", n1, n2);
		}
		if(n1 > n2) {
			System.out.printf("%d > %d\n", n1, n2);
		}
		if(n1 <= n2) {
			System.out.printf("%d <= %d\n", n1, n2);
		}
		if(n1 >= n2) {
			System.out.printf("%d >= %d\n", n1, n2);
		}
		entrada.close();
	
	}//fin del metodo main
}
