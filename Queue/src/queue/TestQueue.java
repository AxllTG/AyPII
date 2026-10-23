package queue;
import net.datastructures.*;

/**
 * Ejercicio 2.11 — usando ArrayQueue<E> (cola circular con arreglo)
 *
 * Se encolan objetos PorPagar (Empleado y Factura) en una ArrayQueue,
 * luego se desencolan calculando los importes a pagar.
 */
public class TestQueue {

    public static void main(String[] args) {

        // ── 1. Cola circular con arreglo ──────────────────────────────────────
        ArrayQueue<PorPagar> cola = new ArrayQueue<>();

        // ── 2. Crear y encolar Empleados ──────────────────────────────────────
        Empleado gerente = new Empleado(101, "Carlos Mendoza",   null,    200, 850.00);
        Empleado emp1    = new Empleado(102, "Ana García",       gerente, 180, 450.00);
        Empleado emp2    = new Empleado(103, "Luis Pérez",       gerente, 160, 420.00);
        Empleado emp3    = new Empleado(104, "María Rodríguez",  emp1,    140, 380.00);

        cola.enqueue(gerente);
        cola.enqueue(emp1);
        cola.enqueue(emp2);
        cola.enqueue(emp3);

        // ── 3. Crear y encolar Facturas ───────────────────────────────────────
        Factura f1 = new Factura("TecnoSuministros S.A.", 5001, "2024-03-10");
        f1.agregarItems("Monitor 24\"",        2,  45000.00);
        f1.agregarItems("Teclado mecánico",    4,   8500.00);
        f1.agregarItems("Mouse inalámbrico",   4,   3200.00);
        f1.agregarItems("Cable HDMI 2m",      10,    850.00);

        Factura f2 = new Factura("OficinaMax S.R.L.", 5002, "2024-03-12");
        f2.agregarItems("Resma A4 500 hojas",  20,  1200.00);
        f2.agregarItems("Bolígrafo azul x10",   5,   350.00);
        f2.agregarItems("Carpeta archivadora", 15,   580.00);

        Factura f3 = new Factura("Muebles Corporativos", 5003, "2024-03-15");
        f3.agregarItems("Silla ergonómica",    6,  28000.00);
        f3.agregarItems("Escritorio L",        2,  42000.00);

        cola.enqueue(f1);
        cola.enqueue(f2);
        cola.enqueue(f3);

        // ── 4. Estado inicial de la cola ──────────────────────────────────────
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║        SISTEMA DE PAGOS - EJERCICIO 2.11             ║");
        System.out.println("║   ArrayQueue<PorPagar> (cola circular con arreglo)   ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.printf("%n  Capacidad del arreglo : %d%n", ArrayQueue.CAPACITY);
        System.out.printf("  Elementos encolados   : %d%n", cola.size());
        System.out.printf("  Primer elemento       : %s%n%n",
                cola.first().getClass().getSimpleName());

        // ── 5. Procesar la cola ───────────────────────────────────────────────
        double totalEmpleados = 0;
        double totalFacturas  = 0;

        int orden = 1;
        while (!cola.isEmpty()) {
            PorPagar item = cola.dequeue();

            System.out.printf("  [%d] Tipo: %-10s  ", orden++,
                    item.getClass().getSimpleName());

            if (item instanceof Empleado) {
                System.out.println();
                System.out.println(item);
                totalEmpleados += item.obtenerPago();
            } else if (item instanceof Factura) {
                System.out.println();
                System.out.println(item);
                totalFacturas += item.obtenerPago();
            }
        }

        // ── 6. Resumen final ──────────────────────────────────────────────────
        double totalGeneral = totalEmpleados + totalFacturas;
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║                   RESUMEN DE PAGOS                   ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.printf( "║  Total sueldos   (empleados) : $%,14.2f       ║%n", totalEmpleados);
        System.out.printf( "║  Total facturas  (proveedores): $%,14.2f      ║%n", totalFacturas);
        System.out.println("║  ──────────────────────────────────────────────────  ║");
        System.out.printf( "║  TOTAL GENERAL               : $%,14.2f       ║%n", totalGeneral);
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.printf("%n  Cola vacía  : %b%n", cola.isEmpty());
        System.out.printf("  Tamaño final: %d%n", cola.size());
    }
}