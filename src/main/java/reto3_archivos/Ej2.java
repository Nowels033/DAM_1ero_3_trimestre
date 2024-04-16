package reto3_archivos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej2 {

//    Escribir un programa Java que permita crear secuencialmente un fichero binario que contenga la información de varias personas.
//    Para cada persona se almacenará: nombre, apellido1, apellido2 y año de nacimiento.
//    El nombre y los apellidos tendrán 20 caracteres rellenando con espacios al final para completar la longitud. Leer el fichero
    public static void main(String[] args) {

            ficheroBinario();

    }
    public static void ficheroBinario()  {
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
            for (int j = introducido.length(); j < 20; j++) {
                    datos.append(" ");
            }

            try {
                dos.writeUTF(String.valueOf(datos));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            datos.delete(0,datos.length());
            System.out.println("Introduce el apellido1 de la persona");
            introducido=sc.nextLine();
            datos.append(introducido);
            for (int j = introducido.length(); j < 20; j++) {
                datos.append(" ");
            }
            try {
                dos.writeUTF(String.valueOf(datos));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            datos.delete(0,datos.length());
            System.out.println("Introduce el apellido2 de la persona");
            introducido=sc.nextLine();
            datos.append(introducido);
            for (int j = introducido.length(); j < 20; j++) {
                datos.append(" ");
            }
            try {
                dos.writeUTF(String.valueOf(datos));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Introduce la feha de nacimiento de la persona");
            anio=sc.nextInt();
            sc.nextLine();
            try {
                dos.writeInt(anio);
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

                System.out.print(dis.readUTF());
                System.out.print(dis.readUTF());
                System.out.print(dis.readUTF());
                System.out.println(dis.readInt());

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

