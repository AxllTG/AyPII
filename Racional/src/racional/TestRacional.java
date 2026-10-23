package racional;

public class TestRacional {

	public static void main(String[] args) {
		Racional r1 = new Racional(3, 4);
		Racional r2 = new Racional(1, 4);
		Racional r3;
		r2.setNumerador(5);

		r3 = r1.sumar(r2);

		System.out.println(r3.getNumerador());
		System.out.println(r3.getDenominador());

		System.out.println("" + r3);
		System.out.println(r1.restar(r2));
		System.out.println(r1.multiplicar(r2));
		System.out.println(r1.dividir(r2));

	}

}
