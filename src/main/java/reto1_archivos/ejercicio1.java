package reto1_archivos;

import java.io.File;
import java.util.Scanner;

/* Ejercicio 1

 Escribir un programa Java que le pida al usuario el nombre de un directorio y el nombre de un elemento.

Compruebe si el elemento es un fichero que existe en el directorio tecleado por el usuario. Si no existe devuelve
un mensaje de error y sale

Si el elemento es un directorio debe listar su contenido (comprobar en la API cómo averiguar si es un directorio)

 Si el elemento es un fichero visualiza la longitud del fichero

 Si el elemento es un fichero pide al usuario el nombre nuevo y lo renombra. */
public class ejercicio1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un directorio :");
        String directorio = sc.nextLine();
        System.out.println("introduce el nombre de un elemento");
        String elemento = sc.nextLine();

        File dir1 = new File(directorio, elemento);


        if (dir1.exists()) {

            if (dir1.isDirectory()) {

                System.out.println("El elemento : " + dir1.getName() + " es un directorio");

                File[] directorioArray = dir1.listFiles();
                System.out.println("CONTENIDO DE " + dir1.getName() + " ES :");
                for (File f : directorioArray) {
                    System.out.println(f.getAbsolutePath());
                }
            }
            if (dir1.isFile()) {


                System.out.println("La longitud de " + dir1.getName() + " es de : " + dir1.length());

                System.out.println("introduce el nuevo nombre del fichero:");
                String nuevoFich = sc.nextLine();
                File file1 = new File(directorio, nuevoFich);

                if (dir1.renameTo(file1)) {
                    System.out.println("Se cambio el nombre del fichero por :" + nuevoFich);
                } else {
                    System.out.println("No se pudo cambiar el nombre del fichero por " + nuevoFich);
                }
            }

        } else {
            System.err.println("ESE DIRECTORIO INTRODUCIDO NO EXISTE");
        }


    }
}
