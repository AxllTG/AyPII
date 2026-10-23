package complejo;

public class Complejo {
	private double real;
	private double imaginario;

	public Complejo() {
		   
    }
	public Complejo(double real, double imaginario) {
		super();
		this.real = real;
		this.imaginario = imaginario;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImaginario() {
		return imaginario;
	}

	public void setImaginario(double imaginario) {
		this.imaginario = imaginario;
	}

	public String toString() {
        return "(" + real + ", " + imaginario + "i)";
    }


	public Complejo sumar(Complejo c) {
		Complejo aux = new Complejo();
		aux.real = real + c.real;
		aux.imaginario = imaginario + c.imaginario;
		return aux;
	}

	public Complejo restar(Complejo c) {
		Complejo aux = new Complejo();
        aux.real = real - c.real;
        aux.imaginario = imaginario - c.imaginario;
        return aux;
	}

}
