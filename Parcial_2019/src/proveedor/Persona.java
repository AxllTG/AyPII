package proveedor;

public class Persona extends Cliente {
	private int porc_jub;
	private boolean jubilado;
	
	
	public Persona(int nroCliente, String nombre,Plan plan) {
		super(nroCliente, nombre, plan);
		// TODO Auto-generated constructor stub
	}


	public int getPorc_jub() {
		return porc_jub;
	}


	public void setPorc_jub(int porc_jub) {
		this.porc_jub = porc_jub;
	}


	public boolean isJubilado() {
		return jubilado;
	}


	public void setJubilado(boolean jubilado) {
		this.jubilado = jubilado;
	}


	@Override
	public double calcularFactura() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
