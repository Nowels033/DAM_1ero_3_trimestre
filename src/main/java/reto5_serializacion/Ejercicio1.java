package reto5_serializacion;


import java.io.*;
import java.util.ArrayList;

public class Ejercicio1 {

   /* 1. Escribir un programa Java que trate objetos de la clase Casa. Un objeto casa tiene los siguientes atributos:
•    dirección
•    portal
•    piso
•    localidad
•    código postal
•    metros cuadrados
•    número de habitaciones

    La aplicación debe permitir escribir y leer estos datos de un fichero.*/

    public static void main(String[] args) {

        //Casa [] casas =new Casa[3];
        ArrayList<Casa> casas = new ArrayList<>();
        Casa casa1 = new Casa("C/velez blanco", 35, 2, "Madrid", 28033, 90, 4);
        Casa casa2 = new Casa("C/velez rubio", 40, 5, "Madrid", 28033, 60, 2);
        Casa casa3 = new Casa("C/albasanz", 55, 7, "Madrid", 28044, 200, 7);
       /* casas[0]=casa1;
        casas[1]=casa2;
        casas[2]=casa3;*/

        casas.add(casa1);
        casas.add(casa2);
        casas.add(casa3);

        serializar(casas);

    }

    public static void serializar(ArrayList<Casa> casas) {
        try {


            ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream("C:\\dir1\\serializar2.dat", true));
            escribirFichero.writeObject(casas);
            escribirFichero.close();

            ObjectInputStream recuperarFichero = new ObjectInputStream(new FileInputStream("C:\\dir1\\serializar2.dat"));
            ArrayList<Casa> casas2 = (ArrayList<Casa>) recuperarFichero.readObject();
            recuperarFichero.close();

            for (Casa e : casas2) {

                System.out.println(e);

            }


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void serializar2(ArrayList<Casa> casas) {
        try {
            // Abre el fichero en modo de apendizaje
            ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream("C:\\dir1\\serializar2.dat",true));

            // Escribe cada objeto Casa en el fichero
            for (Casa casa : casas) {
                escribirFichero.writeObject(casa);
            }
            escribirFichero.close();

            // Lee las casas desde el fichero
            ObjectInputStream recuperarFichero = new ObjectInputStream(new FileInputStream("C:\\dir1\\serializar2.dat"));
            ArrayList<Casa> casas2 = new ArrayList<>();

            // Lee los objetos Casa del fichero
            try {
                while (true) {
                    Casa casa = (Casa) recuperarFichero.readObject();
                    casas2.add(casa);
                }
            } catch (EOFException e) {
                // EOF alcanzado, no hay más objetos para leer
            }

            recuperarFichero.close();

            // Imprime las casas recuperadas
            for (Casa e : casas2) {
                System.out.println(e);
            }
        } catch (IOException | ClassNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println("fin de fichero");
        }

    }
}
