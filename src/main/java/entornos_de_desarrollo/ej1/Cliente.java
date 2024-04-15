package entornos_de_desarrollo.ej1;

public class Cliente {

    private  int numero_cliente;
    private String nombre;
    private String telefono;

    public Cliente(int numero_cliente, String nombre, String telefono) {
        this.numero_cliente = numero_cliente;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public Cliente() {

    }

    public int getNumero_cliente() {
        return numero_cliente;
    }

    public void setNumero_cliente(int numero_cliente) {
        this.numero_cliente = numero_cliente;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "numero_cliente=" + getNumero_cliente() +
                ", nombre='" + getNombre() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                '}';
    }
}
