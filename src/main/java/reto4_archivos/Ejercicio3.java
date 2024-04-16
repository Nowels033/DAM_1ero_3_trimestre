package reto4_archivos;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio3 {

    /*3. Realizar un método que reciba por parámetro el nombre de un fichero que almacena una
    serie de referencias y precios de artículos y actualice los precios de forma que los superiores
    a 100 euros se decrementen en un 50% y los inferiores se incrementen en un 50%.
    El método capturará y tratará todas las excepciones que puedan producirse.*/

    public static void main(String[] args) {

        String fichero="C:\\dir1\\ejercicioAleatorio.data";
        ej3(fichero);

    }
    public static void ej3(String fichero){
        try {
            RandomAccessFile fich = new RandomAccessFile(fichero,"rw");
            int referencia;
            double precio;

            do {
                referencia= fich.readInt();
                precio=fich.readDouble();

                if (precio>100){

                    precio=precio*0.5;
                }
                else {
                    precio=precio*1.5;
                }

                fich.seek(fich.getFilePointer()-8);
                fich.writeDouble(precio);

            }while(fich.getFilePointer()<fich.length());
            fich.close();
            System.out.println("Precios cambiados correctamente");

        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo no encontrado.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
