package model;

import java.util.Date;

public class ServicioModel {
    private String tipo;
    private Date fecha;
    private int numeroFactura;
    private double montoTotal;
    private VehiculoModel vehiculo; // Nuevo atributo para asociar un vehículo al servicio

    public ServicioModel(String tipo, Date fecha, int numeroFactura, double montoTotal) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.numeroFactura = numeroFactura;
        this.montoTotal = montoTotal;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    // Método para obtener el vehículo asociado al servicio
    public VehiculoModel getVehiculo() {
        return vehiculo;
    }

    // Método para establecer el vehículo asociado al servicio
    public void setVehiculo(VehiculoModel vehiculo) {
        this.vehiculo = vehiculo;
    }
}
