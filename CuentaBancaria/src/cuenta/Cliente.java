package cuenta;

public class Cliente {
	 private String nombre;
	    private String cuit;
	    private String direccion;
	    private String email;

	    public Cliente(String nombre, String cuit, String direccion, String email) {
	        this.nombre = nombre;
	        this.cuit = cuit;
	        this.direccion = direccion;
	        this.email = email;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public String toString() {
	        return nombre + " | CUIT: " + cuit;
	    }
}
