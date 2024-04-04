package reto1_archivos;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ejercicio2 {


//    Ejercicio 2
//
//    Escribir un programa Java que le pida al usuario el nombre de un fichero y el nombre de un directorio.
//
//    Compruebe si el fichero existe. Si no existe devuelve un mensaje de error y sale.
//
//    Comprueba si se puede leer y si se puede escribir en él
//
//    Visualiza la longitud del fichero
//
//    Borra el fichero

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un directorio :");
        String directorio = sc.nextLine();
        System.out.println("introduce el nombre de un elemento");
        String elemento = sc.nextLine();

        File dir1 = new File(directorio, elemento);

        Path path = Paths.get(directorio,elemento);

        if (dir1.exists()){

            if (Files.isReadable(path)){
                System.out.println(dir1.getAbsoluteFile()+" Se puede leer");
            }
            if (!Files.isReadable(path)){
                System.out.println(dir1.getAbsoluteFile()+" No se puede leer");
            }

            if (Files.isWritable(path)){
                System.out.println(dir1.getAbsoluteFile()+" Se puede escribir");
            }
            if (!Files.isWritable(path)){
                System.out.println(dir1.getAbsoluteFile()+" No se puede escribir");
            }
            System.out.println("la longitud del fichero es de : "+dir1.length());
            dir1.delete();

        }
        else {
            System.out.println("No existe el fichero : [ "+elemento+" ]");
        }


    }
}
