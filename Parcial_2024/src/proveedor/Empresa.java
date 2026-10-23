package proveedor;

import java.util.Objects;

public class Empresa extends Cliente {
	private String razonSocial;
	private boolean ivaExento;

	public Empresa(int id, String direccion, Plan plan, String razonSocial, boolean ivaExento) {
		super(id, direccion, plan);
		// TODO Auto-generated constructor stub
		this.razonSocial = razonSocial;
		this.ivaExento = ivaExento;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public boolean isIvaExento() {
		return ivaExento;
	}

	public void setIvaExento(boolean ivaExento) {
		this.ivaExento = ivaExento;
	}
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(razonSocial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(razonSocial, other.razonSocial);
	}

	

	@Override
	public String toString() {
		return "Empresa [razonSocial=" + razonSocial + ", ivaExento=" + ivaExento + ", getId()=" + getId()
				+ ", getDireccion()=" + getDireccion() + ", getPlan()=" + getPlan() + "]";
	}

	@Override
	public double calcularFactura() {
		// TODO Auto-generated method stub
		double total = super.getPlan().getTarifa();
		if(!ivaExento)
			total += total * Empresa.getIVA() / 100;
		return total;
	}
}
