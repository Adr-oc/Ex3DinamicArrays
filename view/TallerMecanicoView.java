package view;

import java.util.Scanner;

/**
 * The type Taller mecanico view.
 */
public class TallerMecanicoView {
    private Scanner scanner;

    /**
     * Limpiar pantalla.
     */
    public void limpiarPantalla() {
        System.out.print("\033[H\033[2J");  // Código ANSI para limpiar la pantalla
        System.out.flush();
    }

    /**
     * Instantiates a new Taller mecanico view.
     */
    public TallerMecanicoView() {
        scanner = new Scanner(System.in);
    }

    /**
     * Mostrar menu.
     */
    public void mostrarMenu() {
        limpiarPantalla();
        System.out.println("Taller Mecánico - Menú Principal");
        System.out.println("1. Registrar Vehículo");
        System.out.println("2. Registrar Servicio");
        System.out.println("3. Agregar Sede");
        System.out.println("4. Mostrar Estadísticas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Obtener opcion int.
     *
     * @return the int
     */
    public int obtenerOpcion() {
        return scanner.nextInt();
    }

    /**
     * Mostrar mensaje.
     *
     * @param mensaje the mensaje
     */
    public void mostrarMensaje(String mensaje) {
        limpiarPantalla();
        System.out.println(mensaje);
    }
}
