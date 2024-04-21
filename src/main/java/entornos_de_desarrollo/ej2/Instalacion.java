package entornos_de_desarrollo.ej2;

public abstract class Instalacion {
    private int id;
    private double precioHora;
    private boolean interior;
    private boolean disponible;

    public Instalacion(int id, double precioHora, boolean interior) {
        this.id=id;
        this.precioHora = precioHora;
        this.interior = interior;
        this.disponible=true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(double precioHora) {
        this.precioHora = precioHora;
    }

    public boolean isInterior() {
        return interior;
    }

    public void setInterior(boolean interior) {
        this.interior = interior;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

   /* public abstract double  calcularPrecioInstalacion(){

    }
*/
    @Override
    public String toString() {
        return "Instalacion{" +
                "precioHora=" + getPrecioHora() +
                ", interior=" + isInterior() +
                ", disponible=" + isDisponible() +
                '}';
    }
}
