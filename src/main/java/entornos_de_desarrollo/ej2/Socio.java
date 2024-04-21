package entornos_de_desarrollo.ej2;

public class Socio {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private double cuota;

    public Socio(int id, String nombre, String direccion, String telefono, double cuota) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuota = cuota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", cuota=" + getCuota() +
                '}';
    }
}
