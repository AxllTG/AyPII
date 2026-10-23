package empresa;

public abstract class Vehiculo {
	private String patente;
	private String marca;
	private int modelo;
	
public Vehiculo(String patente, String marca, int modelo) {
		super();
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
	}

public String getPatente() {
	return patente;
}

public void setPatente(String patente) {
	this.patente = patente;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public int getModelo() {
	return modelo;
}

public void setModelo(int modelo) {
	this.modelo = modelo;
}

public abstract double CalcularAquiler(int dias, int kms);

@Override
public String toString() {
	return "Vehiculo [patente=" + patente + ", marca=" + marca + ", modelo=" + modelo + "]" ;
}
	
}
