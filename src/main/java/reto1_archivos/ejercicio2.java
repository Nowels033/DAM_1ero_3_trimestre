package reto1_archivos;

import java.io.File;
import java.util.Scanner;

public class ejercicio2 {

//    Ejercicio 2
//    Escribir un programa Java que le pida al usuario el nombre de un fichero y el nombre de un directorio.
//    Compruebe si el fichero existe. Si no existe devuelve un mensaje de error y sale.
//
//    Comprueba si se puede leer y si se puede escribir en él
//
//    Visualiza la longitud del fichero
//
//    Borra el fichero

    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);

        System.out.println("introduce un directorio");
        String directorio=scanner.nextLine();
        System.out.println("introduce un elemento");
        String elemento = scanner.nextLine();

        File directorioCompleto = new File(directorio,elemento);


    }
}
