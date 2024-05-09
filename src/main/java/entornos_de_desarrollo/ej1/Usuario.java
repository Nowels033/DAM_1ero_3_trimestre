package entornos_de_desarrollo.ej1;

public abstract class Usuario {


    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia_user;

    public Usuario(String nombre, String apellido, String correo, String contrasenia_user) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenia_user = contrasenia_user;
    }

    public String getContrasenia_user() {
        return contrasenia_user;
    }

    public void setContrasenia_user(String contrasenia_user) {
        this.contrasenia_user = contrasenia_user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                '}';
    }
}
