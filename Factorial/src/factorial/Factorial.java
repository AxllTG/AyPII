package factorial;

public class Factorial {

	public static int factorial(int n) {
		if (n == 0 || n == 1)
			return 1;

		int f = 1;
		for (int i = 2; i <= n; i++)
			f = f * i;
		return f;
	}
}
 /*
	O(c) --> constante
	O log2 n --> logaritmica base 2
	O n --> lineal
	O n*log n	
	O n^2 --> cuadratica
	O n^3...
	
	O b^n --> exponencial

*/