package entornos_de_desarrollo.ej7_3;

public class Asignatura {

    private String nombre;
    private String modulo;


    public Asignatura(String nombre, String modulo) {
        this.nombre = nombre;
        this.modulo = modulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "nombre='" + getNombre() + '\'' +
                ", modulo='" + getModulo() + '\'' +
                '}';
    }
}
