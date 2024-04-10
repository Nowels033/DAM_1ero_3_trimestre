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
        leer("C:\\dir1\\leer.txt");

    }

    public static String leer(String ruta) {
        StringBuilder retorno = new StringBuilder("");
        FileReader entrada = null;
        String añadir = "",stringArray;
        Scanner sc = new Scanner(System.in);
        File arch = new File(ruta);
        System.out.println("introduce una palabra");
        String introducido = sc.nextLine();
        ArrayList<String> array = new ArrayList<>();

        try {
            if (arch.exists()) {
                entrada = new FileReader(ruta);
                try {

                    int c;
                    char j;
                    do {
                        c = entrada.read();
                        if (c != -1) {
                            j=(char) c;
                            //System.out.print((char) c);
                            if (j != ' ' && j != '\n' ){
                                añadir += j;
                            }

                            if (j == ' ' || j == '\n' || j=='\r'){
                                stringArray = añadir;
                                añadir="";
                                array.add(stringArray);
                            }
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

        //System.out.println(retorno2);
        int contador =0;
        for (int i = 0; i < array.size(); i++) {

            if (array.get(i).equalsIgnoreCase(introducido)){
                contador++;
            }
        }
        System.out.println(introducido+ " aparece : "+ contador+" veces");
        return retorno2;
    }
}
