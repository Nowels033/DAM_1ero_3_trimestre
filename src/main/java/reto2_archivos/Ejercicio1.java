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

        leer("C:\\dir1\\leer.txt");
        System.out.println(leer("C:\\dir1\\leer.txt"));

    }

    public static StringBuilder leer(String ruta) {
        StringBuilder retorno = new StringBuilder("");
        try {
            FileReader entrada = new FileReader(ruta);
            try {
                int c;
                do {
                    c = entrada.read();
                    if (c != -1) {

                        System.out.print((char) c);
                        retorno.append(c);
                    }

                } while (c != -1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return retorno.reverse();
    }

    public static void escribir(String cadena) {

       cadena = " \n hoal que ase pepemel";

        FileWriter escribiendo = null;
        try {
            escribiendo = new FileWriter("C:\\dir1\\f1.txt",true);
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
