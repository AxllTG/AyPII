package array;

import java.util.Arrays;

public class PruebaLista {

	public static void main(String[] args) {

		Empleado empleado[] = new Empleado[5];

		empleado[0] = new Empleado(100, "Juan");
		empleado[1] = new Empleado(110, "Ana");
		empleado[2] = new Empleado(120, "Pedro");
		empleado[3] = new Empleado(130, "Pablo");
		empleado[4] = new Empleado(140, "Andrea");

		// equals(A, B)
		System.out.println("\nPrueba Arrays.equals");
		Empleado emp1[] = new Empleado[2];
		emp1[0] = new Empleado(100, "Juan");
		emp1[1] = new Empleado(110, "Ana");

		Empleado emp2[] = new Empleado[2];
		emp2[0] = new Empleado(100, "Juan1");
		emp2[1] = new Empleado(110, "Ana1");

		boolean resultado = Arrays.equals(emp1, emp2);

		if (resultado)
			System.out.println("Son iguales");
		else
			System.out.println("Son distintos");

		// fill(A,x)
		System.out.println("\nPrueba Arrays.fill");
		Empleado emp3[] = new Empleado[10];

		Arrays.fill(emp3, new Empleado(180, "Omar"));
		for (Empleado e : emp3)
			System.out.println(e);

		if (emp3[0] == emp3[1])
			System.out.println("mismo objeto");

		// copyOf(A, n)
		System.out.println("\nPrueba Arrays.copyOf");
		Empleado emp4[];

		emp4 = Arrays.copyOf(empleado, 4);
		for (Empleado e : emp4)
			System.out.println(e);

		if (empleado[0] == emp4[0])
			System.out.println("mismo objeto");

		// copyOfRange(A, s, t)
		System.out.println("\nPrueba Arrays.copyOfRange");
		Empleado emp5[];

		emp5 = Arrays.copyOfRange(empleado, 2, 3);
		for (Empleado e : emp5)
			System.out.println(e);

		if (empleado[2] == emp5[0])
			System.out.println("mismo objeto");

		// toString(A)
		System.out.println("\nPrueba Arrays.toString");
		System.out.println(empleado);
		System.out.println(Arrays.toString(empleado));

		// sort(A)
		System.out.println("\nPrueba Arrays.sort");
		Arrays.sort(empleado);

		for (Empleado e : empleado)
			System.out.println(e);

		// binarySearch(A)
		System.out.println("\nPrueba Arrays.binarySearch");
		System.out.println("Encontrado en: " + Arrays.binarySearch(empleado, new Empleado(120, "")));

	}
}
