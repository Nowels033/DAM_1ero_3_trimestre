package reto3_archivos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*Ejercicio n° 1
Escribir un programa Java que realice la copia de un fichero (por ejemplo un fichero imagen).
Se pide al usuario el fichero de entrada y el nombre del fichero de salida.*/
public class Ej1 {

    public static void main(String[] args) {

        copiarImagen("C:\\dir1\\1.jpg");
    }
    public static void copiarImagen(String ruta){

        Scanner sc = new Scanner(System.in);
        FileInputStream fis = null;
        //int entrada = 0 ;
        ArrayList<Integer> entrada = new ArrayList<>();
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
                entrada.add(dis.read());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        try {

            dis.close();
            fis.close();
            System.out.println("Array de la imagen");
            for (int i = 0; i < entrada.size(); i++) {
                System.out.println(entrada.get(i));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("introduce el nombre del archivo destino");
        String destino = sc.nextLine();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream( "C:\\dir1\\"+destino+".jpg");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        DataOutputStream dos = new DataOutputStream(fos);

        try {
            for (int i = 0; i < entrada.size(); i++) {
                dos.write(entrada.get(i));
            }
            dos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


