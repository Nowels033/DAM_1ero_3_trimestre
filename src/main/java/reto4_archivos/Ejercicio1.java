package reto4_archivos;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio1 {

   /* 1. Escribir un método que reciba por parámetro un array de valores enteros correspondientes a referencias a artículos y un array de valores reales
    correspondientes a los precios de los artículos anteriores. Se podrá usar también ArrayList.
    El método recibirá también el nombre de un fichero sobre el que se escribirá cada referencia de artículo seguida de su precio.*/




    public static void main(String[] args) {
        int[] refencias = {0, 1, 2, 3, 4, 5, 6};
        double[] precios = {1005.66, 4.55, 15.90, 100.5, 900, 50.99, 1.20};

        String fichero = "C:\\dir1\\ejercicioAleatorio.data";

        ej1(refencias, precios, fichero);


    }

    public static void ej1(int[] referencia,double[] precios,String fichero){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fichero);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        DataOutputStream dos = new DataOutputStream(fos);
        for (int i = 0; i < referencia.length; i++) {

            try {
                dos.writeInt(referencia[i]);
                dos.writeDouble(precios[i]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
        try {
            dos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
