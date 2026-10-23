package empresa;

public class Contratado extends Personal {

	public Contratado(String nombre, String email, double valorHora) {
		super(nombre, email, valorHora);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Contratado {" + super.toString() + "}"; 
	}
	
}
