package net.datastructures;

import java.util.Objects;

public class Empleado implements Cloneable {
	private int legajo;
	private String nombre;

	public Empleado(int legajo, String nombre) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
	}

	public Empleado Clone() throws CloneNotSupportedException {
		return (Empleado) super.clone();
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

	@Override
	public String toString() {
		return "Empleado [legajo=" + legajo + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(legajo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return legajo == other.legajo;
	}

}
