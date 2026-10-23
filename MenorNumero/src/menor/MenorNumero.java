package menor;

import java.util.Scanner;

public class MenorNumero {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in); // crea un objeto de Clase Scanner, de referencia Llamada 
		
//inicializa las variables que almacenaran numeros ingresados por el usuario;
		int cantidad;
		int numero;
		int menor;

		//mensaje para pedir la cantidad de numero a ingresar;
		System.out.println("Ingrese la cantidad de numero a generar. Luego ingresar los numeros: ");
		cantidad = entrada.nextInt(); //le asigna a entrada la cantidad de numero que va ingresar (este no se evalua)

		//ingresando los primeros numero ingresados por el usuario;
		System.out.println("Ingrese el primer numero: ");
		menor = entrada.nextInt(); // el primer numero siempre va a ser el menor ya que es el primer

		for (int i = 1; i < cantidad; i++) {
			System.out.println("ingrese un numero: ");
			numero = entrada.nextInt();  //ingresa los demas numeros;
			
			if(numero < menor) { // si el siguiente numero ingresado es menor que le anterior entonces hay un nuevo numero mas chico;
				menor = numero;
			}
		}
		System.out.println("El menor numero es: " + menor);
		
		entrada.close();
	}

}
