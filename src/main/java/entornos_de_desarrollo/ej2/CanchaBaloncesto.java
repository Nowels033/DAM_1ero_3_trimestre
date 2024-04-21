package entornos_de_desarrollo.ej2;

public class CanchaBaloncesto extends Instalacion{

    private String nombre;

    public CanchaBaloncesto(int id, double precioHora, boolean interior,String nombre) {
        super(id, precioHora, interior);

        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cancha de Baloncesto{" +
                "nombre='" + getNombre() + '\'' +
                "} " + super.toString();
    }
}
