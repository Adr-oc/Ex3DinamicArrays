package model;

public class VehiculoModel {
    private String placa;
    private String marca;
    private String linea;
    private String modelo;
    private String propietario;

    public VehiculoModel(String placa, String marca, String linea, String modelo, String propietario) {
        this.placa = placa;
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getLinea() {
        return linea;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPropietario() {
        return propietario;
    }


}
