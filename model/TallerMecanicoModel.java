package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TallerMecanicoModel {
    private List<VehiculoModel> vehiculos;
    private List<ServicioModel> servicios;
    private List<SedeModel> sedes;

    public TallerMecanicoModel() {
        vehiculos = new ArrayList<>();
        servicios = new ArrayList<>();
        sedes = new ArrayList<>();
    }

    public void agregarVehiculo(VehiculoModel vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void agregarServicio(ServicioModel servicio) {
        servicios.add(servicio);
    }

    public void agregarSede(SedeModel sede) {
        sedes.add(sede);
    }

    public int obtenerTotalVehiculos() {
        return vehiculos.size();
    }

    public int obtenerTotalServicios() {
        return servicios.size();
    }

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

    public double calcularIngresosTotales() {
        double ingresosTotales = 0.0;
        for (ServicioModel servicio : servicios) {
            ingresosTotales += servicio.getMontoTotal();
        }
        return ingresosTotales;
    }

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

    public List<ServicioModel> getServicios() {
        return servicios;
    }
}
