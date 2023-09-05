package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Sede model.
 */
public class SedeModel {
    private String nombre;
    private List<VehiculoModel> vehiculos;
    private List<ServicioModel> servicios;

    /**
     * Instantiates a new Sede model.
     *
     * @param nombre the nombre
     */
    public SedeModel(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
        this.servicios = new ArrayList<>();
    }

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Gets vehiculos.
     *
     * @return the vehiculos
     */
    public List<VehiculoModel> getVehiculos() {
        return vehiculos;
    }

    /**
     * Gets servicios.
     *
     * @return the servicios
     */
    public List<ServicioModel> getServicios() {
        return servicios;
    }

}
