package entornos_de_desarrollo.ej1;

public class Administrador extends Usuario{


    public Administrador(String nombre, String apellido, String correo, String contraseña) {
        super(nombre, apellido, correo, contraseña);
    }

    @Override
    public String toString() {
        return "Administrador{"+"idUsuario="+
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", correo='" + getCorreo() + '\'' + "}";
    }
}
