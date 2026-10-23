package lista;

public class ArrayList<E> {

    private Object[] datos;
    private int tope;
    private static final int CAPACIDAD_INICIAL = 10;

    public ArrayList() {
        datos = new Object[CAPACIDAD_INICIAL];
        tope = 0;
    }

    // Agrega al final
    public void add(E e) {
        if (tope == datos.length)
            redimensionar(datos.length * 2);
        datos[tope++] = e;
    }

    // Obtiene el elemento en la posición i
    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i < 0 || i >= tope)
            throw new IndexOutOfBoundsException("Índice: " + i);
        return (E) datos[i];
    }

    // Elimina el elemento en la posición i
    @SuppressWarnings("unchecked")
    public E remove(int i) {
        if (i < 0 || i >= tope)
            throw new IndexOutOfBoundsException("Índice: " + i);
        E valor = (E) datos[i];
        for (int j = i; j < tope - 1; j++)
            datos[j] = datos[j + 1];
        datos[--tope] = null;
        return valor;
    }

    public int size() {
        return tope;
    }

    public boolean isEmpty() {
        return tope == 0;
    }

    public int capacity() {
        return datos.length;
    }

    // Redimensiona internamente el arreglo
    private void redimensionar(int nuevaCapacidad) {
        Object[] nuevo = new Object[nuevaCapacidad];
        for (int i = 0; i < tope; i++)
            nuevo[i] = datos[i];
        datos = nuevo;
    }

    // *** trimToSize: reemplaza el arreglo por uno con capacidad == tope ***
    public void trimToSize() {
        if (tope < datos.length)
            redimensionar(tope);
    }

    @Override
    public String toString() {           
        StringBuilder sb = new StringBuilder("ArrayList[");
        for (int i = 0; i < tope; i++) {
            sb.append(datos[i]);
            if (i < tope - 1) sb.append(", ");
        }
        return sb.append("] (size=" + tope + ", capacity=" + datos.length + ")").toString();
    }

    // --- Programa principal de prueba ---
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();

        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        System.out.println("Antes de trim:");
        System.out.println(lista);
        // ArrayList[1, 2, 3, 4, 5] (size=5, capacity=10)

        lista.trimToSize();

        System.out.println("\nDespués de trim:");
        System.out.println(lista);
        // ArrayList[1, 2, 3, 4, 5] (size=5, capacity=5)
    }
}