package figura;

import java.util.Objects;

public class Circulo extends Figura {
	private int radio;

	public Circulo(String nombre, Punto origen, int radio) {
		super(nombre, origen);
		this.radio = radio;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(radio, 2);
	}

	@Override
	public String toString() {
		return getNombre()+ ": " + "[radio=" + radio +"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(radio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circulo other = (Circulo) obj;
		return radio == other.radio;
	}
}
