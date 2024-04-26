package Apuntes_Fichero;

import java.io.*;

public class TamañoVariables {

    public static void main(String[] args) {
        String nombreArchivo = "C:\\dir1\\ejemplo.dat";

        // Ejemplo de variables
        int entero = 123; // Tamaño: 4 bytes
        double doble = 123.45; // Tamaño: 8 bytes
        String cadena = "Hola"; // Tamaño: 8 bytes (4 caracteres * 2 bytes cada uno)
        char caracter = 'a'; // Tamaño: 2 bytes
        boolean booleano = true; // Tamaño: 1 byte

        // Escribir las variables en el archivo
        escribirVariablesEnArchivo(entero, doble, cadena, caracter, booleano, nombreArchivo);

        // Leer y mostrar el contenido del archivo
        System.out.println("Contenido del archivo:");
        leerYMostrarArchivo(nombreArchivo);
    }

    // Método para escribir variables en un archivo
    public static void escribirVariablesEnArchivo(int entero, double doble, String cadena, char caracter, boolean booleano, String nombreArchivo) {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw")) {
            // Escribir las variables en el archivo
            raf.writeInt(entero);
            raf.writeDouble(doble);
            raf.writeUTF(cadena);
            raf.writeChar(caracter);
            raf.writeBoolean(booleano);
            System.out.println("Se ha escrito la información en el archivo correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
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