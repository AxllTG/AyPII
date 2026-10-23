package iquals;

import java.util.Objects;

public class Alumno {
	private int legajo;
	private String nombre;
	private String email;
	public Alumno(int legajo, String nombre, String email) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.email = email;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Alumno [legajo=" + legajo + ", nombre=" + nombre + ", email=" + email + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
	@Override
	public boolean equals(Object obj) {  //"equals" compara contenido / atributos
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(email, other.email);
	}
	
	
	
	
	
}
