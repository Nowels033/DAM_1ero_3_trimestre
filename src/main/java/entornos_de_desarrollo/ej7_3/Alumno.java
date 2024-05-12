package entornos_de_desarrollo.ej7_3;

import java.util.ArrayList;
import java.util.List;

public class Alumno extends Persona{

    private List <Notas>  notas = new ArrayList<Notas>();


    public Alumno(String nombre, String apellidos, String direccion, String correo, int telefono, String contrasenia) {
        super(nombre, apellidos, direccion, correo, telefono, contrasenia);
    }


    public List<Notas> getNotas() {
        return notas;
    }

    public void setNotas(List<Notas> notas) {
        this.notas = notas;
    }
    public void verNotas(){

        if (!this.notas.isEmpty()) {
            for (int i = 0; i < notas.size(); i++) {

                System.out.println(notas.get(i).toString());

            }
        }
        if (this.notas.isEmpty()) {
            System.out.println("NO TIENES NOTAS REGISTRADAS");
        }
    }



    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + getNombre()+ '\'' +
                ", apellidos='" + getApellidos() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", telefono=" + getTelefono() +
                ", notas=" + getNotas() +
                '}';
    }
}
