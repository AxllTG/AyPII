package empresa;

public class Empleado extends Personal {

	public Empleado(String nombre, String email, double valorHora) {
		super(nombre, email, valorHora);
		// TODO Auto-generated constructor stub
	}
	 @Override
	    public String toString() {
	        return "Empleado{" + super.toString() + "}";
	    }
}
