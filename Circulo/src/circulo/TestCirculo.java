package circulo;

import java.util.Scanner;

public class TestCirculo {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		double radio;
		
		System.out.println("ingresar el radio: ");
		radio = input.nextDouble();

		System.out.printf("Diametro: %4.2f",Circulo.diametro(radio));
		System.out.printf("Circunferencia: %f",Circulo.circunferencia(radio));
	}

}
