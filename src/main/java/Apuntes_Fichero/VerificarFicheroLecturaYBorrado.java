package Apuntes_Fichero;

import java.io.File;
import java.util.Scanner;

public class VerificarFicheroLecturaYBorrado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario el nombre del fichero
        System.out.println("Introduce el nombre del fichero:");
        String nombreFichero = scanner.nextLine();

        // Pedir al usuario el nombre del directorio
        System.out.println("Introduce el nombre del directorio:");
        String nombreDirectorio = scanner.nextLine();

        // Crear el objeto File para el fichero
        File fichero = new File(nombreDirectorio, nombreFichero);

        // Verificar si el fichero existe
        if (!fichero.exists() || !fichero.isFile()) {
            System.out.println("El fichero especificado no existe.");
            return;
        }

        // Verificar si se puede leer y escribir en el fichero
        if (!fichero.canRead() || !fichero.canWrite()) {
            System.out.println("No se puede leer y/o escribir en el fichero.");
            return;
        }

        // Visualizar la longitud del fichero
        System.out.println("Longitud del fichero: " + fichero.length());

        // Borrar el fichero
        if (fichero.delete()) {
            System.out.println("El fichero se ha borrado correctamente.");
        } else {
            System.out.println("Error al borrar el fichero.");
        }
    }
}