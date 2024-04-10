package reto2_archivos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*Ejercicio 2.-

Realizar un programa que muestre las n primeras líneas del fichero de texto “texto.txt”.
El valor de n se pedirá al usuario y se tendrá en cuenta que puede ser mayor que el
número de filas del fichero.*/



public class Ejercicio2 {

    public static void main(String[] args) {
        System.out.println(leer("C:\\dir1\\leer.txt"));
    }

    public static String leer(String ruta) {
        StringBuilder retorno = new StringBuilder("");
        FileReader entrada = null;
        String añadir = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce un numero de lineas");
        int linea = sc.nextInt();
        try {
            entrada = new FileReader(ruta);
            try {
                int c;
                do {
                    c = entrada.read();
                    if (c != -1) {
                        //System.out.print((char) c);
                        añadir += String.valueOf((char) c);

                    }
                    if (c == '\n'){
                        linea--;
                    }

                } while (c != -1 && linea != 0);

                retorno.append(añadir);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                entrada.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // retorno.reverse();
       /* System.out.println();
        System.out.println( retorno.toString());*/

        String retorno2 = retorno.toString();
        return retorno2;
    }

}
