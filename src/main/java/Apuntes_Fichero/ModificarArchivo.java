package Apuntes_Fichero;

import java.io.*;

public class ModificarArchivo {

    public static void main(String[] args) {
        String nombreArchivo = "C:\\dir1\\ejemplo.dat";

        // Ejemplo de variables
        int nuevoEntero = 456;
        double nuevoDoble = 678.90;
        String nuevaCadena = "Mundo";
        char nuevoCaracter = 'b';
        boolean nuevoBooleano = false;

        // Modificar las variables en el archivo
        modificarVariablesEnArchivo(nuevoEntero, nuevoDoble, nuevaCadena, nuevoCaracter, nuevoBooleano, nombreArchivo);

        // Leer y mostrar el contenido actualizado del archivo
        System.out.println("Contenido actualizado del archivo:");
        leerYMostrarArchivo(nombreArchivo);
    }

    // Método para modificar variables en un archivo
    public static void modificarVariablesEnArchivo(int nuevoEntero, double nuevoDoble, String nuevaCadena, char nuevoCaracter, boolean nuevoBooleano, String nombreArchivo) {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw")) {
            // Mover el puntero al principio del archivo
            raf.seek(0);

            // Escribir las nuevas variables en el archivo
            raf.writeInt(nuevoEntero);
            raf.writeDouble(nuevoDoble);
            raf.writeUTF(nuevaCadena);
            raf.writeChar(nuevoCaracter);
            raf.writeBoolean(nuevoBooleano);
            System.out.println("Se han modificado las variables en el archivo correctamente.");
        } catch (IOException e) {
            System.err.println("Error al modificar el archivo: " + e.getMessage());
        }
    }

    // Método para leer y mostrar el contenido del archivo
    public static void leerYMostrarArchivo(String nombreArchivo) {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "r")) {
            System.out.println("Entero: " + raf.readInt());
            System.out.println("Doble: " + raf.readDouble());
            System.out.println("Cadena: " + raf.readUTF());
            System.out.println("Caracter: " + raf.readChar());
            System.out.println("Booleano: " + raf.readBoolean());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}