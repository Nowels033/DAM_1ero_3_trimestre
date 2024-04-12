package reto3_archivos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej2 {

    public static void main(String[] args) {
        try {
            ficheroBinario();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void ficheroBinario() throws IOException {
        StringBuilder datos = new StringBuilder(20);
        String introducido;
        int anio;
        Scanner sc = new Scanner(System.in);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream( "C:\\dir1\\personas.data");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        DataOutputStream dos = new DataOutputStream(fos);
        for (int i = 0; i < 3; i++) {
            datos.delete(0,datos.length());
            System.out.println("Introduce el nombre de la persona");
            introducido=sc.nextLine();
            datos.append(introducido);
            dos.writeUTF(String.valueOf(datos));




        }
        dos.close();
        fos.close();

        FileInputStream fis = null;

        try {
            fis = new FileInputStream("C:\\dir1\\personas.data");
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

                System.out.println(dis.readUTF());
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

