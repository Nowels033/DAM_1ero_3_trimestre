package reto5_serializacion;


import java.io.*;

public class Main {

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

        Casa [] casas =new Casa[3];
        Casa casa1 =new Casa("C/velez blanco",35,2,"Madrid",28033,90,4);
        Casa casa2 =new Casa("C/velez rubio",40,5,"Madrid",28033,60,2);
        Casa casa3 =new Casa("C/albasanz",55,7,"Madrid",28044,200,7);
        casas[0]=casa1;
        casas[1]=casa2;
        casas[2]=casa3;

        serializar(casas);

    }
    public static void serializar(Casa[] casas){
        try {
            ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream( "C:\\dir1\\serializar2.dat"));
            escribirFichero.writeObject(casas);
            escribirFichero.close();

            ObjectInputStream recuperarFichero = new ObjectInputStream(new FileInputStream("C:\\dir1\\serializar2.dat"));
            Casa[] casas2 = (Casa[]) recuperarFichero.readObject();
            recuperarFichero.close();

            for (Casa e: casas2) {

                System.out.println(e);

            }


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
