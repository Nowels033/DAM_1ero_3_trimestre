package reto2_archivos;

//Ejercicio 1.-
//
//        Hacer un programa que lea el fichero de texto, “texto.txt”, y genere otro llamado “invertido.txt”, e
//        n el que se guardarán las frases del primero pero invertidas.
//
//        Mostrar en pantalla el nuevo fichero.
//
//        Ejemplo:
//
//        texto.txt Esto es un ejemplo
//
//        invertido.txt olpmeje nu se otsE


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1 {


    public static void main(String[] args) {



        System.out.println( leer("C:\\dir1\\leer.txt"));
        escribir(leer("C:\\dir1\\leer.txt"));


    }

    public static String leer(String ruta) {
        StringBuilder retorno = new StringBuilder("");
        FileReader entrada = null;
        String añadir = "";
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

                } while (c != -1);

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
        retorno.reverse();
        String retorno2 = retorno.toString();
        return retorno2;
     }

    public static void escribir(String cadena) {

       //cadena = " \n hoal que ase pepemel";

        FileWriter escribiendo = null;
        try {
            escribiendo = new FileWriter("C:\\dir1\\textoinvertido.txt",true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


            try {
                escribiendo.write(cadena);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        try {
            escribiendo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
