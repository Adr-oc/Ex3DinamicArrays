package view;

import java.util.Scanner;

public class TallerMecanicoView {
    private Scanner scanner;

    public TallerMecanicoView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("Taller Mecánico - Menú Principal");
        System.out.println("1. Registrar Vehículo");
        System.out.println("2. Registrar Servicio");
        System.out.println("3. Agregar Sede");
        System.out.println("4. Mostrar Estadísticas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public int obtenerOpcion() {
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
