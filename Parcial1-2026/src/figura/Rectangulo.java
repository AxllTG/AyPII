package figura;

import java.util.Objects;

public class Rectangulo extends Figura {
	private int ancho;
	private int alto;

	public Rectangulo(String nombre, Punto origen, int ancho, int alto) {
		super(nombre, origen);
		this.ancho = ancho;
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	@Override
	public double area() {

		return ancho * alto;
	}

	@Override
	public String toString() {
		return getNombre()+ ": " + "[ancho=" + ancho +", alto= " + alto +"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(alto, ancho);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangulo other = (Rectangulo) obj;
		return alto == other.alto && ancho == other.ancho;
	}

}
