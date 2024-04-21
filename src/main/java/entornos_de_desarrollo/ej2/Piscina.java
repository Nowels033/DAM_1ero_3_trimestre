package entornos_de_desarrollo.ej2;

public class Piscina extends Instalacion{

    private String nombre;

    public Piscina(int id, double precioHora, boolean interior,String nombre) {
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
        return "Piscina{" +
                "nombre='" + getNombre() + '\'' +
                "} " + super.toString();
    }
}
