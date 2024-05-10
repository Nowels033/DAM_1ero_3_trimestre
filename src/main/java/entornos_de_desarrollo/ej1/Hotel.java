package entornos_de_desarrollo.ej1;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private int codigo_hotel;
    private String nombre;
    private String direccion;
    private String telefono;

    private List <Habitacion> habitaciones = new ArrayList<Habitacion>();

    public Hotel(int codigo_hotel, String nombre, String direccion, String telefono, List<Habitacion> habitaciones) {
        this.codigo_hotel = codigo_hotel;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.habitaciones = habitaciones;
    }

    public Hotel() {

    }

    public int getCodigo_hotel() {
        return codigo_hotel;
    }

    public void setCodigo_hotel(int codigo_hotel) {
        this.codigo_hotel = codigo_hotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "codigo_hotel=" + getCodigo_hotel() +
                ", nombre='" + getNombre() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                '}';
    }
}