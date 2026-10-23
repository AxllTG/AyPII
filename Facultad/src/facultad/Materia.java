
package facultad;

import java.util.ArrayList;
import java.util.List;



/**
 * Materia
 * Registra codigo y nombre.
 * Punto 5: registra tambien sus materias correlativas.
 */
public class Materia {

    private String codigo;
    private String nombre;
    private final List<Materia> correlativas = new ArrayList<>();

    public Materia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void agregarCorrelativa(Materia materia) {
        if (materia == null || materia == this) return;
        if (!correlativas.contains(materia)) {
            correlativas.add(materia);
        }
    }

    public void quitarCorrelativa(Materia materia) {
        correlativas.remove(materia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Materia)) return false;
        Materia materia = (Materia) o;
        return codigo.equals(materia.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    @Override
    public String toString() {
        return "Materia{codigo='" + codigo + "', nombre='" + nombre + "'}";
    }
}