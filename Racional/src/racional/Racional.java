package racional;

public class Racional {
//inicializacion de atributos.
	private int numerador;

	private int denominador;

	public Racional(int numerador, int denominador) {
		super();
		this.numerador = numerador;
		this.denominador = denominador;
	}

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}

	public String toString() {
		return numerador + "/" + denominador;
	}

	public Racional sumar(Racional r) {
		int n;
		int d;
		n = numerador * r.denominador + denominador * r.numerador;
		d = denominador * r.denominador;
		return new Racional(n, d);
	}

	public Racional restar(Racional r) {
		int n;
		int d;
		n = numerador * r.denominador - denominador * r.numerador;
		d = denominador * r.denominador;

		return new Racional(n, d);
	}

	public Racional multiplicar(Racional r) {
		int n;
		int d;
		n = numerador * r.numerador;
		d = denominador * r.denominador;

		return new Racional(n, d);
	}

	public Racional dividir(Racional r) {
		int n;
		int d;
		n = numerador * r.denominador;
		d = denominador * r.numerador;

		return new Racional(n, d);
	}
	
}
