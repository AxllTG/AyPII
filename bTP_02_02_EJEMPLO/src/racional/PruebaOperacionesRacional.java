package racional;


class PruebaOperacionesRacional {

	public static void main(String[] args) {

		// https://www.superprof.es/apuntes/escolar/matematicas/aritmetica/racionales/numeros-racionales-2.html#tema_suma-y-resta-de-numeros-racionales
					
		Racional r1 = new Racional(3, 4);
		Racional r2 = new Racional(1, 4);
		Racional r3, r4;
		
		
		r3 = r1.sumar(r2);
		r4 = new Racional(5,5);
		
		System.out.println(r3.equals(r4));
		
		System.out.println(Racional.simplificar(r1.sumar(r2)));
		
		
		// Realizar operaciones con racionales
		// 5/4 + 1/6 = 17/12
		// 5/4 - 1/6 = 13/12
		// 5/4 * 1/6 = 5/24
		// 5/4 / 1/6 = 15/2
		// (5/4)^2 = 25/16
						
	}

}
