package reto3_archivos;

import java.io.*;
import java.util.Scanner;

/*Ejercicio n° 1
Escribir un programa Java que realice la copia de un fichero (por ejemplo un fichero imagen).
Se pide al usuario el fichero de entrada y el nombre del fichero de salida.*/
public class Ej1 {

    public static void main(String[] args) {
    leer("C:\\dir1\\1.jpg");
    }
    public static void leer (String ruta){

        Scanner sc = new Scanner(System.in);
        FileInputStream fis = null;
        String entrada = "";
        try {
            fis = new FileInputStream(ruta);
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
                entrada += dis.readByte();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        try {

            dis.close();
            fis.close();
            System.out.println(entrada);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("introduce el nombre del archivo destino");
        String destino = sc.nextLine();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream( "C:\\dir1\\"+destino+".txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        DataOutputStream dos = new DataOutputStream(fos);

        try {
            dos.write(entrada.getBytes());
            dos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


