package concatenado;

import java.util.Scanner;

public class Concatenado {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // ✅ sin guiones

        String nombre;
        String apellido;

        System.out.println("Ingrese su nombre: ");
        nombre = input.nextLine();

        System.out.println("Ingrese su apellido: ");
        apellido = input.nextLine();

        System.out.println("Hola, " + nombre + " " + apellido);
    
        input.close();    
    }
    
}