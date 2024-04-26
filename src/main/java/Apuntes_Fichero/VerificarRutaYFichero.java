package Apuntes_Fichero;

import java.io.File;
import java.util.Scanner;

public class VerificarRutaYFichero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario el nombre del directorio
        System.out.println("Introduce el nombre del directorio:");
        String directorioPath = scanner.nextLine();

        // Pedir al usuario el nombre del elemento
        System.out.println("Introduce el nombre del elemento:");
        String elementoNombre = scanner.nextLine();

        // Crear el objeto File para el directorio
        File directorio = new File(directorioPath);

        // Verificar si el directorio existe
        if (!directorio.exists() || !directorio.isDirectory()) {
            System.out.println("El directorio especificado no existe.");
            return;
        }

        // Crear el objeto File para el elemento dentro del directorio
        File elemento = new File(directorio, elementoNombre);

        // Verificar si el elemento existe
        if (!elemento.exists()) {
            System.out.println("El elemento especificado no existe en el directorio.");
            return;
        }

        // Verificar si el elemento es un directorio
        if (elemento.isDirectory()) {
            // Listar el contenido del directorio
            String[] contenido = elemento.list();
            System.out.println("Contenido del directorio:");
            for (String archivo : contenido) {
                System.out.println(archivo);
            }
        } else {
            // Si el elemento es un fichero, mostrar su longitud
            if (elemento.isFile()) {
                System.out.println("Longitud del fichero: " + elemento.length());

                // Si el elemento es un fichero, pedir al usuario un nuevo nombre y renombrarlo
                System.out.println("Introduce el nuevo nombre del fichero:");
                String nuevoNombre = scanner.nextLine();
                File nuevoArchivo = new File(directorio, nuevoNombre);
                if (elemento.renameTo(nuevoArchivo)) {
                    System.out.println("El fichero se ha renombrado correctamente.");
                } else {
                    System.out.println("Error al renombrar el fichero.");
                }
            } else {
                System.out.println("El elemento especificado no es ni un directorio ni un fichero.");
            }
        }
    }
}