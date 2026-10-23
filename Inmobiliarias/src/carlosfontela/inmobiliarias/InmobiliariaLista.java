// Inmobiliaria.java
package carlosfontela.inmobiliarias;
//import net.datastructures.ArrayList;
//import net.datastructures.List;

import java.util.ArrayList;
import java.util.List;

public class InmobiliariaLista {
    private String nombre;
    private List<Inmueble> inmuebles;

    public InmobiliariaLista(String nombre) {
        this.nombre = nombre;
        this.inmuebles = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadInmuebles() {
        return inmuebles.size();
    }

    public void agregarInmueble(Inmueble inmuebleNuevo) {
        inmuebles.add(inmuebleNuevo);
    }

    private int posicionInmueble(Inmueble x) {
        return inmuebles.indexOf(x);
    }

    public void quitarInmueble(Inmueble x) {
        int pos = posicionInmueble(x);
        if (pos > -1) { // encontró el inmueble
            inmuebles.remove(pos);
        }
    }

    public void imprimirDatos() {
        System.out.println("Inmobiliaria: " + this.getNombre());
        for (Inmueble i : inmuebles) {
            i.imprimirDatos();
        }
        System.out.println();
    }
}