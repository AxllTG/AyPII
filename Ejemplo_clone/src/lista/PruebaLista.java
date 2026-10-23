package lista;

public class PruebaLista {

    public static void main(String[] args) {

        SinglyLinkedList<Empleado> lista2 = new SinglyLinkedList<Empleado>();

        lista2.addFirst(new Empleado(10, "Juan"));
        lista2.addFirst(new Empleado(20, "Pedro"));
        lista2.addFirst(new Empleado(30, "Luis"));

        System.out.println("Lista2 = [" + lista2 + "]");

        SinglyLinkedList<Empleado> lista3 = null;
        try {
            lista3 = lista2.clone1();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("Lista3(clon) = [" + lista3 + "]");

        // Modificamos el primero de lista2
        lista2.first().setNombre("MODIFICADO");

        System.out.println("\nDespues de modificar el primero de lista2:");
        System.out.println("Lista2 = [" + lista2 + "]");
        System.out.println("Lista3 = [" + lista3 + "] <- no cambio (clon profundo)");
    }
}