package entornos_de_desarrollo.ej1;

public class Habitacion {

    private int numero_habitacion;
    private boolean disponible;
    private int numero_camas;

    public Habitacion(int numero_habitacion, boolean disponible, int numero_camas) {
        this.numero_habitacion = numero_habitacion;
        this.disponible = disponible;
        this.numero_camas = numero_camas;
    }
    public Habitacion() {

    }

    public int getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(int numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getNumero_camas() {
        return numero_camas;
    }

    public void setNumero_camas(int numero_camas) {
        this.numero_camas = numero_camas;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numero_habitacion=" + getNumero_habitacion() +
                ", disponible=" + isDisponible() +
                ", numero_camas=" + getNumero_camas() +
                '}';
    }
}
