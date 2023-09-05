package model;

import java.util.ArrayList;
import java.util.List;

public class SedeModel {
    private String nombre;
    private List<VehiculoModel> vehiculos;
    private List<ServicioModel> servicios;

    public SedeModel(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
        this.servicios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<VehiculoModel> getVehiculos() {
        return vehiculos;
    }

    public List<ServicioModel> getServicios() {
        return servicios;
    }

}
