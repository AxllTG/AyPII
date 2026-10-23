package proveedor;

public class Empresa extends Cliente {
	public Empresa(int nroCliente, String nombre, Plan plan) {
		super(nroCliente, nombre, plan);
		// TODO Auto-generated constructor stub
	}

	private double baseEmpresa;
	private int cantEmpleados;
	

	
	@Override
	public double calcularFactura() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getBaseEmpresa() {
		return baseEmpresa;
	}

	public void setBaseEmpresa(double baseEmpresa) {
		this.baseEmpresa = baseEmpresa;
	}

	public int getCantEmpleados() {
		return cantEmpleados;
	}

	public void setCantEmpleados(int cantEmpleados) {
		this.cantEmpleados = cantEmpleados;
	}
	
	
	
	
}
