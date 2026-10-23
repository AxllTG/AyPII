
package facultad;	

import java.util.ArrayList;
import java.util.List;

/**
 * Facultad
 * Gestiona profesores, alumnos y materias.
 *
 * Punto 5 - Consultas:
 *  - materiasQueDicta(profesor)
 *  - alumnosQueCursan(materia)
 *  - cantidadDeAlumnosPorMateria()
 */
public class Facultad {

    private String nombre;

    private final List<Profesor> profesores = new ArrayList<>();
    private final List<Alumno> alumnos = new ArrayList<>();
    private final List<Materia> materias = new ArrayList<>();

    public Facultad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // ---------- Gestion de Profesores ----------
    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void agregarProfesor(Profesor profesor) {
        if (profesor != null && !profesores.contains(profesor)) {
            profesores.add(profesor);
        }
    }

    public void quitarProfesor(Profesor profesor) {
        profesores.remove(profesor);
    }

    // ---------- Gestion de Alumnos ----------
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void agregarAlumno(Alumno alumno) {
        if (alumno != null && !alumnos.contains(alumno)) {
            alumnos.add(alumno);
        }
    }

    public void quitarAlumno(Alumno alumno) {
        alumnos.remove(alumno);
    }

    // ---------- Gestion de Materias ----------
    public List<Materia> getMaterias() {
        return materias;
    }

    public void agregarMateria(Materia materia) {
        if (materia != null && !materias.contains(materia)) {
            materias.add(materia);
        }
    }

    public void quitarMateria(Materia materia) {
        materias.remove(materia);
    }

    // ---------- Consultas (punto 5) ----------

    /**
     * Todas las materias que dicta un profesor.
     */
    public List<Materia> materiasQueDicta(Profesor profesor) {
        if (profesor == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(profesor.getMateriasQueDicta());
    }

    /**
     * Todos los alumnos que cursan una determinada materia.
     */
    public List<Alumno> alumnosQueCursan(Materia materia) {
        List<Alumno> resultado = new ArrayList<>();
        if (materia == null) {
            return resultado;
        }
        for (Alumno alumno : alumnos) {
            if (alumno.getMateriasQueCursa().contains(materia)) {
                resultado.add(alumno);
            }
        }
        return resultado;
    }

    /**
     * Cantidad de alumnos que cursan una materia puntual.
     */
    public int cantidadDeAlumnos(Materia materia) {
        return alumnosQueCursan(materia).size();
    }

    /**
     * Cantidad de alumnos por materia, para todas las materias
     * registradas en la facultad.
     * Devuelve un mapa Materia -> cantidad de alumnos.
     */
    public java.util.Map<Materia, Integer> cantidadDeAlumnosPorMateria() {
        java.util.Map<Materia, Integer> resultado = new java.util.LinkedHashMap<>();
        for (Materia materia : materias) {
            resultado.put(materia, cantidadDeAlumnos(materia));
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Facultad{nombre='" + nombre + "'}";
    }
}