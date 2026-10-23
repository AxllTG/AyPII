package iquals;

public class TestAlumno {

	public static void main(String[] args) {
		Alumno a1 = new Alumno(10, "Juan", "Juan@gmail.com");
		Alumno a2 = new Alumno(20, "Ana", "Ana@gmail.com");
		Alumno a3 = null;
		Alumno a4 = new Alumno(1000, "Juan Perez", "Juan@gmail.com");
		
		Alumno a5 = a1;
		
		
		Empleado e1 = new Empleado (5220, "Pedro", "Pedro@gmail.com");
		
		System.out.println(a1);
		System.out.println(a2);
		
		System.out.println(a1.getClass());
		System.out.println(e1.getClass());
		
		if(a1.equals(a4))
			System.out.println("Son iguales");
		else
			System.out.println("No son iguales");
		

		if(a1 == a5) // el "==" compara direcciones en memoria.
			System.out.println("Son iguales");
		else
			System.out.println("No son iguales");
		
		if(a1.getEmail() == a5.getEmail())
			System.out.println("Son iguales");
		else
			System.out.println("No son iguales");
		
		
	}

}
