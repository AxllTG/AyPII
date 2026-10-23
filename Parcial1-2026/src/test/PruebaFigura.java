package test;

import figura.*;

public class PruebaFigura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Punto p = new Punto(0, 0);

		Figura[] figura = new Figura[4];

		Circulo c1 = new Circulo("Circulo 1", p, 20);
		Rectangulo r1 = new Rectangulo("Rectangulo 1", p, 2, 4);
		Circulo c2 = new Circulo("Circulo 2", p, 10);
		Rectangulo r2 = new Rectangulo("Rectangulo 2", p, 8, 16);

		figura[0] = c1;
		figura[1] = r2;
		figura[2] = c2;
		figura[3] = r1;

		double sumaTotal = 0;

		for (int i = 0; i < figura.length; i++) {

			System.out.println("========");
			System.out.println("Figura:" + figura[i]);
			System.out.println("Area: " + figura[i].area());
			System.out.println("========");
			System.out.println();
			sumaTotal += figura[i].area();
		}

		System.out.println("Suma Total de las Areas: " + sumaTotal);

	}

}
