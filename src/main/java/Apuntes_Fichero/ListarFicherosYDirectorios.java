package Apuntes_Fichero;

import java.io.File;
import java.util.Scanner;

public class ListarFicherosYDirectorios {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario el nombre del directorio
        System.out.println("Introduce el nombre del directorio:");
        String nombreDirectorio = scanner.nextLine();

        // Pedir al usuario el nombre del fichero
        System.out.println("Introduce el nombre del fichero:");
        String nombreFichero = scanner.nextLine();

        // Crear el objeto File para el directorio
        File directorio = new File(nombreDirectorio);

        // Verificar si el directorio existe
        if (!directorio.exists() || !directorio.isDirectory()) {
            System.out.println("El directorio especificado no existe.");
            return;
        }

        // Crear el objeto File para el fichero dentro del directorio
        File fichero = new File(directorio, nombreFichero);

        // Verificar si el fichero existe dentro del directorio
        if (!fichero.exists() || !fichero.isFile()) {
            System.out.println("El fichero especificado no existe en el directorio.");
            return;
        }

        // Listar los subdirectorios del directorio
        System.out.println("Subdirectorios del directorio:");
        File[] subdirectorios = directorio.listFiles(File::isDirectory);
        for (File subdir : subdirectorios) {
            System.out.println(subdir.getName());
        }

        // Listar los ficheros del directorio
        System.out.println("Ficheros del directorio:");
        File[] ficheros = directorio.listFiles(File::isFile);
        for (File file : ficheros) {
            System.out.println(file.getName());
        }

        // Calcular el tamaño total de los ficheros del directorio
        long tamanoTotal = 0;
        for (File file : ficheros) {
            tamanoTotal += file.length();
        }
        System.out.println("Tamaño total de los ficheros del directorio: " + tamanoTotal + " bytes");

        // Listar los ficheros del directorio que empiecen por una letra en particular
        System.out.println("Introduce una letra para filtrar los ficheros:");
        char letra = scanner.nextLine().charAt(0);
        System.out.println("Ficheros que empiezan por la letra '" + letra + "':");
        for (File file : ficheros) {
            if (file.getName().charAt(0) == letra) {
                System.out.println(file.getName());
            }
        }
    }
}
