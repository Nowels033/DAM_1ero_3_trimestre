package Apuntes_Fichero;

import java.io.*;

public class bytePersona {

    public static void main(String[] args) {
        // Crear algunas personas de ejemplo
        Persona[] personas = {
                new Persona("Juan", "Garcia", "Perez", 1990),
                new Persona("Maria", "Lopez", "Gomez", 1985),
                new Persona("Pedro", "Martinez", "Sanchez", 1978)
        };

        String nombreArchivo = "personas.bin";

        // Escribir las personas en el archivo binario
        escribirPersonasEnArchivo(personas, nombreArchivo);

        // Leer y mostrar la información del archivo binario
        leerYMostrarArchivoBinario(nombreArchivo);
    }

    // Método para escribir las personas en un archivo binario
    public static void escribirPersonasEnArchivo(Persona[] personas, String nombreArchivo) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(nombreArchivo)))) {
            for (Persona persona : personas) {
                dos.writeUTF(padRight(persona.getNombre(), 20));
                dos.writeUTF(padRight(persona.getApellido1(), 20));
                dos.writeUTF(padRight(persona.getApellido2(), 20));
                dos.writeInt(persona.getAnioNacimiento());
            }
            System.out.println("Se ha escrito la información en el archivo binario correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo binario: " + e.getMessage());
        }
    }

    // Método para leer y mostrar la información del archivo binario
    public static void leerYMostrarArchivoBinario(String nombreArchivo) {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(nombreArchivo)))) {
            while (dis.available() > 0) {
               /* El método trim() en Java se utiliza para
                eliminar los espacios en blanco al principio y
            al final de una cadena de caracteres (String).
                        Retorna una copia de la cadena original, sin los espacios en blanco iniciales y finales.*/

                String nombre = dis.readUTF().trim();
                String apellido1 = dis.readUTF().trim();
                String apellido2 = dis.readUTF().trim();
                int anioNacimiento = dis.readInt();
                System.out.println("Nombre: " + nombre + ", Apellido1: " + apellido1 + ", Apellido2: " + apellido2 + ", Año de nacimiento: " + anioNacimiento);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo binario: " + e.getMessage());
        }
    }

    // Método para rellenar una cadena con espacios al final hasta una longitud específica
    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}

// Clase para representar a una persona
class Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int anioNacimiento;

    public Persona(String nombre, String apellido1, String apellido2, int anioNacimiento) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.anioNacimiento = anioNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }
}
