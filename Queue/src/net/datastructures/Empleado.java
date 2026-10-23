package net.datastructures;

public class Empleado implements PorPagar {

    private int legajo;
    private String nombre;
    private int horasTrabajadas;
    private double valorHora;
    private Empleado supervisor;

    public Empleado(int legajo, String nombre, Empleado supervisor,
                    int horasTrabajadas, double valorHora) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.supervisor = supervisor;
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    @Override
    public double obtenerPago() {
        return horasTrabajadas * valorHora;
    }

    public int getLegajo() { return legajo; }
    public String getNombre() { return nombre; }
    public int getHorasTrabajadas() { return horasTrabajadas; }
    public double getValorHora() { return valorHora; }
    public Empleado getSupervisor() { return supervisor; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append(String.format("  EMPLEADO - Legajo N° %d\n", legajo));
        sb.append("========================================\n");
        sb.append(String.format("  Nombre       : %s\n", nombre));
        sb.append(String.format("  Supervisor   : %s\n",
                supervisor != null ? supervisor.getNombre() : "Sin supervisor"));
        sb.append(String.format("  Horas        : %d\n", horasTrabajadas));
        sb.append(String.format("  Valor/Hora   : $%.2f\n", valorHora));
        sb.append("  ----------------------------------------\n");
        sb.append(String.format("  SUELDO: $%.2f\n", obtenerPago()));
        sb.append("========================================\n");
        return sb.toString();
    }
}