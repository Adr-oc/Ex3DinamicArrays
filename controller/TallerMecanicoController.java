package controller;

import model.SedeModel;
import model.ServicioModel;
import model.TallerMecanicoModel;
import model.VehiculoModel;
import view.TallerMecanicoView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TallerMecanicoController {
    private TallerMecanicoModel modelo;
    private TallerMecanicoView vista;
    private Scanner scanner;

    public TallerMecanicoController(TallerMecanicoModel modelo, TallerMecanicoView vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.obtenerOpcion();

            switch (opcion) {
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    registrarServicio();
                    break;
                case 3:
                    agregarSede();
                    break;
                case 4:
                    mostrarEstadisticas();
                    break;
                case 0:
                    vista.mostrarMensaje("Saliendo del programa.");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    private void registrarVehiculo() {
        vista.mostrarMensaje("Registrando un nuevo vehículo:");

        vista.mostrarMensaje("Ingrese la placa del vehículo:");
        String placa = scanner.next();

        vista.mostrarMensaje("Ingrese la marca del vehículo:");
        String marca = scanner.next();

        vista.mostrarMensaje("Ingrese la línea del vehículo:");
        String linea = scanner.next();

        vista.mostrarMensaje("Ingrese el modelo del vehículo:");
        String modeloo = scanner.next();

        vista.mostrarMensaje("Ingrese el nombre del propietario:");
        String propietario = scanner.next();

        VehiculoModel vehiculo = new VehiculoModel(placa, marca, linea, modeloo, propietario);
        modelo.agregarVehiculo(vehiculo);

        vista.mostrarMensaje("Vehículo registrado exitosamente.");
    }

    private void registrarServicio() {
        vista.mostrarMensaje("Registrando un nuevo servicio:");

        vista.mostrarMensaje("Ingrese el tipo de servicio:");
        String tipo = scanner.next();

        vista.mostrarMensaje("Ingrese la fecha del servicio (yyyy-MM-dd):");
        String fechaStr = scanner.next();

        Date fecha = null;
        try {
            fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
        } catch (ParseException e) {
            vista.mostrarMensaje("Error al analizar la fecha. Formato válido: yyyy-MM-dd");
            return;
        }

        vista.mostrarMensaje("Ingrese el número de factura:");
        int numeroFactura = scanner.nextInt();

        vista.mostrarMensaje("Ingrese el monto total del servicio:");
        double montoTotal = scanner.nextDouble();

        List<VehiculoModel> vehiculosDisponibles = modelo.obtenerVehiculosDisponibles();
        vista.mostrarMensaje("Vehículos disponibles para el servicio:");

        for (int i = 0; i < vehiculosDisponibles.size(); i++) {
            vista.mostrarMensaje((i + 1) + ". " + vehiculosDisponibles.get(i).getPlaca());
        }

        vista.mostrarMensaje("Seleccione el número del vehículo para el servicio:");
        int seleccionVehiculo = scanner.nextInt();

        if (seleccionVehiculo >= 1 && seleccionVehiculo <= vehiculosDisponibles.size()) {
            VehiculoModel vehiculoSeleccionado = vehiculosDisponibles.get(seleccionVehiculo - 1);
            ServicioModel servicio = new ServicioModel(tipo, fecha, numeroFactura, montoTotal);
            servicio.setVehiculo(vehiculoSeleccionado); // Asociar el vehículo al servicio
            modelo.agregarServicio(servicio);
            vista.mostrarMensaje("Servicio registrado exitosamente.");
        } else {
            vista.mostrarMensaje("Selección de vehículo no válida.");
        }
    }

    private void agregarSede() {
        vista.mostrarMensaje("Agregando una nueva sede:");

        vista.mostrarMensaje("Ingrese el nombre de la nueva sede:");
        String nombreSede = scanner.next();

        SedeModel sede = new SedeModel(nombreSede);
        modelo.agregarSede(sede);

        vista.mostrarMensaje("Sede agregada exitosamente.");
    }

    private void mostrarEstadisticas() {
        vista.mostrarMensaje("Mostrando estadísticas:");

        double ingresosTotales = calcularIngresosTotales();
        vista.mostrarMensaje("Ingresos totales: $" + ingresosTotales);

        int vehiculosReparadosEnSemana = contarVehiculosReparadosEnSemana();
        vista.mostrarMensaje("Vehículos reparados en la última semana: " + vehiculosReparadosEnSemana);


        vista.mostrarMensaje("Estadísticas mostradas.");
    }


    public static void main(String[] args) {
        TallerMecanicoModel modelo = new TallerMecanicoModel();
        TallerMecanicoView vista = new TallerMecanicoView();
        TallerMecanicoController controller = new TallerMecanicoController(modelo, vista);
        controller.iniciar();
    }

    private double calcularIngresosTotales() {
        double ingresosTotales = 0.0;
        for (ServicioModel servicio : modelo.getServicios()) {
            ingresosTotales += servicio.getMontoTotal();
        }
        return ingresosTotales;
    }

    private int contarVehiculosReparadosEnSemana() {
        // Supongamos que una semana es un rango de 7 días
        long unaSemanaEnMillis = 7 * 24 * 60 * 60 * 1000; // Milisegundos en una semana

        Date fechaActual = new Date();
        int contador = 0;

        for (ServicioModel servicio : modelo.getServicios()) {
            Date fechaServicio = servicio.getFecha();
            long diferenciaEnTiempo = fechaActual.getTime() - fechaServicio.getTime();

            if (diferenciaEnTiempo <= unaSemanaEnMillis) {
                contador++;
            }
        }

        return contador;
    }



}
