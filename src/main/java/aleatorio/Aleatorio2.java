package aleatorio;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Aleatorio2 {
   static RandomAccessFile fich = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int posicion;
        long tamanio;
        int numero;

        try {
            fich = new RandomAccessFile("C:\\dir1\\enteros.dat", "rw");
            tamanio = fich.length() / 4;
            System.out.println("el fichero tiene " + tamanio + " enteros");
        do {
            System.out.println("posicion >=1 y <= "+tamanio);
            posicion=sc.nextInt();
        }while (posicion < 1 || posicion > tamanio);
        posicion--;
        fich.seek(posicion* 4L);
            System.out.println("VALOR : "+fich.readInt());
            System.out.println("Ingresar valor nuevo");
            numero=sc.nextInt();
            fich.seek(fich.getFilePointer()-4);
            fich.writeInt(numero);

            System.out.println("contenido del fichero :");
            mostarFich();
            fich.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static void mostarFich(){
        int numero;
        try {
            fich.seek(0);
            while (true){
                numero=fich.readInt();
                System.out.println(numero);
            }
        } catch (EOFException e){} catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
