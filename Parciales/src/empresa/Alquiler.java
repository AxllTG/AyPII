package empresa;


// Clase Alquiler
public class Alquiler {
    private int cantDias;
    private int cantKms;
    private Vehiculo vehiculo;
    private Cliente cliente;

    public Alquiler(int cantDias, int cantKms, Vehiculo vehiculo, Cliente cliente) {
        this.cantDias = cantDias;
        this.cantKms = cantKms;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
    }

    public double calcularCostoTotal() {
        return vehiculo.CalcularAquiler(cantDias, cantKms);
    }

    // Getters y Setters
    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public int getCantKms() {
        return cantKms;
    }

    public void setCantKms(int cantKms) {
        this.cantKms = cantKms;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}