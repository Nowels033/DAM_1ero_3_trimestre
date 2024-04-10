package reto2_archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
    /*Ejercicio 3.-

    Realizar un programa que cuente el número de líneas, caracteres y
    palabras que tiene un fichero que se pasará por teclado.

    Se debe comprobar que el fichero existe antes de empezar a contar.*/

    public static void main(String[] args) {
        leer("C:\\dir1\\leer.txt");

    }

    public static String leer(String ruta) {
        StringBuilder retorno = new StringBuilder("");
        FileReader entrada = null;
        String añadir = "";
        Scanner sc = new Scanner(System.in);
        File arch = new File(ruta);
        int carac=0,linea=0,palabra=0;

        try {
            if (arch.exists()) {
                entrada = new FileReader(ruta);
                try {

                    int c;
                    do {
                        c = entrada.read();
                        if (c != -1) {
                            //System.out.print((char) c);
                            añadir += String.valueOf((char) c);


                        }
                        if (c ==' ' ){
                            palabra++;
                        }
                        if (c == '\n'){
                            linea++;
                        }




                    } while (c != -1);

                    retorno.append(añadir);
                    entrada.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println(ruta + " NO EXISTE");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {

        }

        String retorno2 = retorno.toString();
        palabra=palabra+linea;
        carac=retorno2.length()-palabra-linea;
        System.out.println(retorno2);
        System.out.println("tiene : "+linea+" lineas , tiene : "+carac+" caracteres y tiene : "+palabra+" palabras");
        return retorno2;
    }
}
