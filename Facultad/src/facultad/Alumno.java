
package facultad;

import java.util.ArrayList;
import java.util.List;

/**
 * Alumno
 * Registra legajo, nombre y apellido.
 * Registra las materias que esta cursando (puede no estar cursando ninguna).
 * Punto 5: registra sus DatosPersonal.
 */
public class Alumno {

    private int legajo;
    private String nombre;
    private String apellido;
    private final List<Materia> materiasQueCursa = new ArrayList<>();
    private DatosPersonal datosPersonal;

    public Alumno(int legajo, String nombre, String apellido) {
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

    public List<Materia> getMateriasQueCursa() {
        return materiasQueCursa;
    }

    public void agregarMateriaQueCursa(Materia materia) {
        if (materia == null) return;
        if (!materiasQueCursa.contains(materia)) {
            materiasQueCursa.add(materia);
        }
    }

    public void quitarMateriaQueCursa(Materia materia) {
        materiasQueCursa.remove(materia);
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
        if (!(o instanceof Alumno)) return false;
        Alumno alumno = (Alumno) o;
        return legajo == alumno.legajo;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(legajo);
    }

    @Override
    public String toString() {
        return "Alumno{legajo=" + legajo + ", nombre='" + nombre + "', apellido='" + apellido + "'}";
    }
}