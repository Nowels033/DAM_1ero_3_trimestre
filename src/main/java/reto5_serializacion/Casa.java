package reto5_serializacion;

import java.io.Serializable;

public class Casa implements Serializable {

       /* 1. Escribir un programa Java que trate objetos de la clase Casa. Un objeto casa tiene los siguientes atributos:
•    dirección
•    portal
•    piso
•    localidad
•    código postal
•    metros cuadrados
•    número de habitaciones

    La aplicación debe permitir escribir y leer estos datos de un fichero.*/

    private String direccion;
    private int portal;
    private int piso;
    private String localidad;
    private int codigoPostal;
    private int metrosCuadrados;
    private int numeroHabitaciones;

    public Casa(String direccion, int portal, int piso, String localidad, int codigoPostal, int metrosCuadrados, int numeroHabitaciones) {
        this.direccion = direccion;
        this.portal = portal;
        this.piso = piso;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.metrosCuadrados = metrosCuadrados;
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPortal() {
        return portal;
    }

    public void setPortal(int portal) {
        this.portal = portal;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "direccion='" + getDireccion() + '\'' +
                ", portal=" + getPortal() +
                ", piso=" + getPiso() +
                ", localidad='" + getLocalidad() + '\'' +
                ", codigoPostal=" + getCodigoPostal() +
                ", metrosCuadrados=" + getMetrosCuadrados() +
                ", numeroHabitaciones=" + getNumeroHabitaciones() +
                '}';
    }
}
