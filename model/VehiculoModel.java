package model;

/**
 * The type Vehiculo model.
 */
public class VehiculoModel {
    private String placa;
    private String marca;
    private String linea;
    private String modelo;
    private String propietario;

    /**
     * Instantiates a new Vehiculo model.
     *
     * @param placa       the placa
     * @param marca       the marca
     * @param linea       the linea
     * @param modelo      the modelo
     * @param propietario the propietario
     */
    public VehiculoModel(String placa, String marca, String linea, String modelo, String propietario) {
        this.placa = placa;
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    /**
     * Gets placa.
     *
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Gets marca.
     *
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Gets linea.
     *
     * @return the linea
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Gets modelo.
     *
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Gets propietario.
     *
     * @return the propietario
     */
    public String getPropietario() {
        return propietario;
    }


}
