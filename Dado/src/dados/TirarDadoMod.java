package dados;

import java.util.Iterator;
import java.util.Random;


public class TirarDadoMod {

	public static void main(String[] args) {
		Random numerosAleatorios = new Random();
		int frecuencia[] = new int [13];
		
		
		for (int tiro = 1; tiro <= 6000; tiro++)
			++frecuencia[1 + numerosAleatorios.nextInt(12)];
		
		System.out.printf("%s%10s\n", " Cara ", " Frecuencia ");
		
		for ( int cara = 2; cara < frecuencia.length; cara++)
			System.out.printf("%4d%10d\n", cara, frecuencia[cara]);
		
		
		
	}

}
