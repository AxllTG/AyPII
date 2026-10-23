
package facultad;

import java.util.ArrayList;
import java.util.List;

/**
 * Profesor
 * Registra legajo, nombre y apellido.
 * Puede dictar mas de una materia.
 * Punto 5: registra sus DatosPersonal.
 */
public class Profesor {

    private int legajo;
    private String nombre;
    private String apellido;
    private final List<Materia> materiasQueDicta = new ArrayList<>();
    private DatosPersonal datosPersonal;

    public Profesor(int legajo, String nombre, String apellido) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Materia> getMateriasQueDicta() {
        return materiasQueDicta;
    }

    public void agregarMateriaQueDicta(Materia materia) {
        if (materia == null) return;
        if (!materiasQueDicta.contains(materia)) {
            materiasQueDicta.add(materia);
        }
    }

    public void quitarMateriaQueDicta(Materia materia) {
        materiasQueDicta.remove(materia);
    }

    public DatosPersonal getDatosPersonal() {
        return datosPersonal;
    }

    public void setDatosPersonal(DatosPersonal datosPersonal) {
        this.datosPersonal = datosPersonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profesor)) return false;
        Profesor profesor = (Profesor) o;
        return legajo == profesor.legajo;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(legajo);
    }

    @Override
    public String toString() {
        return "Profesor{legajo=" + legajo + ", nombre='" + nombre + "', apellido='" + apellido + "'}";
    }
}