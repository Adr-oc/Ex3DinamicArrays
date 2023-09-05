package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Taller mecanico model.
 */
public class TallerMecanicoModel {
    private List<VehiculoModel> vehiculos;
    private List<ServicioModel> servicios;
    private List<SedeModel> sedes;

    /**
     * Instantiates a new Taller mecanico model.
     */
    public TallerMecanicoModel() {
        vehiculos = new ArrayList<>();
        servicios = new ArrayList<>();
        sedes = new ArrayList<>();
    }

    /**
     * Agregar vehiculo.
     *
     * @param vehiculo the vehiculo
     */
    public void agregarVehiculo(VehiculoModel vehiculo) {
        vehiculos.add(vehiculo);
    }

    /**
     * Agregar servicio.
     *
     * @param servicio the servicio
     */
    public void agregarServicio(ServicioModel servicio) {
        servicios.add(servicio);
    }

    /**
     * Agregar sede.
     *
     * @param sede the sede
     */
    public void agregarSede(SedeModel sede) {
        sedes.add(sede);
    }

    /**
     * Obtener total vehiculos int.
     *
     * @return the int
     */
    public int obtenerTotalVehiculos() {
        return vehiculos.size();
    }

    /**
     * Obtener total servicios int.
     *
     * @return the int
     */
    public int obtenerTotalServicios() {
        return servicios.size();
    }

    /**
     * Obtener vehiculos disponibles list.
     *
     * @return the list
     */
    public List<VehiculoModel> obtenerVehiculosDisponibles() {
        List<VehiculoModel> vehiculosDisponibles = new ArrayList<>();

        for (VehiculoModel vehiculo : vehiculos) {
            boolean estaDisponible = true;
            for (ServicioModel servicio : servicios) {
                if (servicio.getVehiculo() == vehiculo) {
                    estaDisponible = false;
                    break;
                }
            }

            if (estaDisponible) {
                vehiculosDisponibles.add(vehiculo);
            }
        }

        return vehiculosDisponibles;
    }

    /**
     * Calcular ingresos totales double.
     *
     * @return the double
     */
    public double calcularIngresosTotales() {
        double ingresosTotales = 0.0;
        for (ServicioModel servicio : servicios) {
            ingresosTotales += servicio.getMontoTotal();
        }
        return ingresosTotales;
    }

    /**
     * Contar vehiculos reparados en semana int.
     *
     * @return the int
     */
    public int contarVehiculosReparadosEnSemana() {
        long unaSemanaEnMillis = 7 * 24 * 60 * 60 * 1000;
        Date fechaActual = new Date();
        int contador = 0;

        for (ServicioModel servicio : servicios) {
            Date fechaServicio = servicio.getFecha();
            long diferenciaEnTiempo = fechaActual.getTime() - fechaServicio.getTime();

            if (diferenciaEnTiempo <= unaSemanaEnMillis) {
                contador++;
            }
        }

        return contador;
    }

    // Puedes agregar más métodos para calcular otras estadísticas aquí

    /**
     * Gets servicios.
     *
     * @return the servicios
     */
    public List<ServicioModel> getServicios() {
        return servicios;
    }
}
