package reto2_archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*Ejercicio 5.-

Hacer un programa que pida al usuario una palabra por
teclado y diga cuántas veces aparece esa palabra en el fichero "parrafo.txt".*/
public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una palabra:");
        String introducido = sc.nextLine().toLowerCase();
        leer("C:\\dir1\\leer.txt", introducido);
        sc.close();
    }

    public static void leer(String ruta, String introducido) {
        StringBuilder retorno = new StringBuilder();
        FileReader entrada = null;
        ArrayList<String> array = new ArrayList<>();

        try {
            File arch = new File(ruta);
            if (arch.exists()) {
                entrada = new FileReader(ruta);
                int c;
                StringBuilder palabra = new StringBuilder();

                while ((c = entrada.read()) != -1) {
                    char j = (char) c;
                    if (Character.isLetterOrDigit(j)) {
                        palabra.append(j);
                    } else {
                        if (palabra.length() > 0) {
                            array.add(palabra.toString());
                            palabra.setLength(0);
                        }
                    }
                    retorno.append(j);
                }

                // Agregar la última palabra si es que hay una al final del archivo
                if (palabra.length() > 0) {
                    array.add(palabra.toString());
                }

                entrada.close();
            } else {
                System.out.println(ruta + " NO EXISTE");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int contador = 0;
        for (String palabra : array) {
            if (palabra.equalsIgnoreCase(introducido)) {
                contador++;
            }
        }

        System.out.println("CONTENIDO DE LA ARRAY:");
        for (String palabra : array) {
            System.out.println("- " + palabra);
        }
        System.out.println(introducido + " aparece: " + contador + " veces");
    }
}