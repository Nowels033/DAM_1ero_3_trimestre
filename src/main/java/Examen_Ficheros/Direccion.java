package Examen_Ficheros;

public class Direccion {

    String calle;
    int numero;

    Direccion(String calle, int numero) {
        this.calle = calle;
        this.numero = numero;
    }

    Direccion(Direccion direccion) {
        this.calle = direccion.getCalle();
        this.numero = direccion.getNumero();
    }

    private String getCalle() {
        return calle;
    }

    void setCalle(String calle) {
        this.calle = calle;
    }

    private int getNumero() {
        return numero;
    }

    void setNumero(int numero) {
        this.numero = numero;
    }
}
