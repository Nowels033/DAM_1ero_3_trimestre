package entornos_de_desarrollo.ej7_3;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona {

    private List<Alumno> alumnos = new ArrayList<Alumno>();

    public Profesor(String nombre, String apellidos, String direccion, String correo, int telefono, String contrasenia) {
        super(nombre, apellidos, direccion, correo, telefono, contrasenia);
    }


    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + getNombre()+ '\'' +
                ", apellidos='" + getApellidos() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", telefono=" + getTelefono() +
                ",alumnos=" + getAlumnos() +
                '}';
    }
}
