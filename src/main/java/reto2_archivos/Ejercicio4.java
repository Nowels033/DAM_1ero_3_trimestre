package reto2_archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*Ejercicio 4.-

Hacer un programa, que modifique el fichero “texto.txt”, insertando un * delante
de cada vocal.

Mostrar el fichero “texto.txt” resultante.

        Ejemplo :

Inicialmente Texto.txt Voy a hacer una prueba

Finalmente Texto.txt V*oy *a h*ac*er *un*a pr*u*eb*a*/
public class Ejercicio4 {

    public static void main(String[] args) {
        leer("C:\\dir1\\leer.txt");

    }

    public static String leer(String ruta) {
        StringBuilder retorno = new StringBuilder("");
        FileReader entrada = null;
        String añadir = "";
        Scanner sc = new Scanner(System.in);
        File arch = new File(ruta);


        try {
            if (arch.exists()) {
                entrada = new FileReader(ruta);
                try {

                    int c;
                    char j;
                    do {
                        c = entrada.read();
                        if (c != -1) {
                            //System.out.print((char) c);
                            j=(char) c;
                            if (j == 'a' ||j == 'e' || j == 'i' ||j == 'o' ||j == 'u' ) {
                               añadir+= "*";
                            }
                            añadir += String.valueOf((char) c);
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

        System.out.println(retorno2);

        return retorno2;
    }
}
