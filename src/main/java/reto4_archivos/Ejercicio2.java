package reto4_archivos;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejercicio2 {

    /*2.  Escribir un método que reciba por parámetro el nombre
    de un fichero que almacena una serie de referencias y precios de artículos y muestre su contenido por pantalla.*/
    public static void main(String[] args) {
      String fichero="C:\\dir1\\ejercicioAleatorio.data";
      ej2(fichero);

    }

    public static void ej2(String fichero){

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(fichero);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        DataInputStream dis = new DataInputStream(fis);
        while (true){
            try {
                if (!(dis.available() >0)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {

                System.out.println(dis.readInt()+"-"+ dis.readDouble());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        try {

            dis.close();
            fis.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
