package aleatorio;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;
import java.util.Scanner;

public class Aleatorio1 {
     static RandomAccessFile fich = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;

        try {
            fich = new RandomAccessFile("C:\\dir1\\enteros.dat","rw");

            mostarFich();
            System.out.println("ingresar numero entero para añadir al final del fichero");
            numero = sc.nextInt();
            fich.seek(fich.length());
            fich.writeInt(numero);
            mostarFich();

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
