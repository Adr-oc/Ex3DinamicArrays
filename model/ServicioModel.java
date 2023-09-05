package model;

import java.util.Date;

/**
 * The type Servicio model.
 */
public class ServicioModel {
    private String tipo;
    private Date fecha;
    private int numeroFactura;
    private double montoTotal;
    private VehiculoModel vehiculo; // Nuevo atributo para asociar un vehículo al servicio

    /**
     * Instantiates a new Servicio model.
     *
     * @param tipo          the tipo
     * @param fecha         the fecha
     * @param numeroFactura the numero factura
     * @param montoTotal    the monto total
     */
    public ServicioModel(String tipo, Date fecha, int numeroFactura, double montoTotal) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.numeroFactura = numeroFactura;
        this.montoTotal = montoTotal;
    }

    /**
     * Gets tipo.
     *
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Gets fecha.
     *
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Gets numero factura.
     *
     * @return the numero factura
     */
    public int getNumeroFactura() {
        return numeroFactura;
    }

    /**
     * Gets monto total.
     *
     * @return the monto total
     */
    public double getMontoTotal() {
        return montoTotal;
    }

    /**
     * Gets vehiculo.
     *
     * @return the vehiculo
     */
// Método para obtener el vehículo asociado al servicio
    public VehiculoModel getVehiculo() {
        return vehiculo;
    }

    /**
     * Sets vehiculo.
     *
     * @param vehiculo the vehiculo
     */
// Método para establecer el vehículo asociado al servicio
    public void setVehiculo(VehiculoModel vehiculo) {
        this.vehiculo = vehiculo;
    }
}
