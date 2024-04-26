package Examen_Ficheros;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  @descrition Clase que describe un Aula de Alumnos para los ejercicios
 */
public class Aula {
    private List<Alumno> alumnos;
    private int numalumnos; //atributo para controlar el número real de elementos que tiene nuestro almacén

    /**
     * Constructor del Almacén con un determinado tamano
     *
     * @param tamano
     */
    public Aula(int tamano) {
        alumnos = new ArrayList<Alumno>(tamano);
        numalumnos = 0;

    }

    /**
     * Comprueba si el almacén está vacio
     *
     * @return true si está vacio
     */
    public boolean estaVacio() {
        return alumnos.isEmpty();
    }

    /**
     * Comprueba si el almacén está lleno
     *
     * @return
     */
    public boolean estaLLeno() {
        return numalumnos == alumnos.size();
    }

    /**
     * Anade un nuevo elemento al almacén si hay sitio
     *
     * @param valor a anadir al almacén
     */
    public void add(Alumno alumno) {
        if (!this.estaLLeno()) {
            alumnos.add(alumno);
            numalumnos++;
        }
    }

    /**
     * Elimina un elemento del almacén si está en el almacen
     *
     * @param valor
     * @return true si elimina el elemento, false en caso contrario
     */
    public boolean eliminar(Alumno alumno) {
        return alumnos.remove(alumno);

    }


    /**
     * Imprime por pantalla los elementos del almacén
     */
    public void informacionAlumnos() {
        System.out.println("El aula tiene los siguientes alumnos:");
        for (int j = 0; j < alumnos.size(); j++) {
            System.out.println(alumnos.get(j).toString() + " ");
        }
    }

    public static void escribirAlumnos(String rutaCompletaFichero) {

        String nombre;
        String apellido;
        int añoNacimiento;
        String calle;
        int numero;

        Alumno alumno;
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fw = null;
            try {
                fw = new FileWriter(rutaCompletaFichero);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            BufferedWriter escribir = new BufferedWriter(fw);

           // do {
//CREAMOS 3 ALUMNOS EN EL FICHERO
            for (int i = 0; i < 3; i++) {
                sc.nextLine();
                System.out.println("Introduce el Nombre del alumno");
                nombre = sc.nextLine();
                System.out.println("Introduce el apellido del alumno");
                apellido=sc.nextLine();
                System.out.println("introduce el NOMBRE de la calle del alumno");
                calle=sc.nextLine();
                System.out.println("introduce el numero de la calle;");
                numero=sc.nextInt();
                System.out.println("introduce el año de nacimiento");
                añoNacimiento=sc.nextInt();
                    try {
                        escribir.write(nombre+"\t");
                        escribir.write(apellido+"\t");
                        escribir.write(añoNacimiento+"\t");
                        escribir.write(calle+"\t");
                        escribir.write(numero+"\t");
                        escribir.write("\n");//PARA HACER UN SALTO DE LINEA
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    alumno=new Alumno(nombre,apellido,añoNacimiento,calle,numero);
                System.out.println(" Se creo el alumno :"+alumno.toString());
                }

            System.out.println("SE CREO EL FICHERO CON LOS ALUMNOS");

            //} while (!texto.isBlank());
            try {
                escribir.close();
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } finally {

        }
    }

    public static void leerFicheroAlumno(String rutaCompletaFichero){
        String nombre;
        String apellido;
        int añoNacimiento;
        String calle;
        int numero;
        Scanner sc = new Scanner(System.in);
        FileReader fr = null;
        try {
            fr = new FileReader(rutaCompletaFichero);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader leer = new BufferedReader(fr);
        System.out.println("FICHERO DE ALUMNOS");


        for (int i = 0; i < 3; i++) {


            try {
                nombre= leer.readLine();
                /*apellido= String.valueOf(leer.read());
                añoNacimiento= leer.read();
                calle= String.valueOf(leer.read());
                numero= leer.read();*/

                System.out.println(nombre);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        try {
            leer.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static void construirAulaConFichero(String rutaCompletaFichero){
        String linea ;
        StringBuilder builder = new StringBuilder();
        Alumno alumno;
        String nombre;
        String apellido;
        int añoNacimiento;
        String calle;
        int numero;
        char caracter;
        Scanner sc = new Scanner(System.in);
        FileReader fr = null;
        try {
            fr = new FileReader(rutaCompletaFichero);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader leer = new BufferedReader(fr);
        System.out.println("INTRODUCE EL TAMAÑO DEL AULA");
        int tamañoAula=sc.nextInt();
        Aula nuevaAula = new Aula(tamañoAula);
        int subString=0;

        for (int i = 0; i < 3; i++) {

//NO DI CON ELLO

            try {
                builder= new StringBuilder(leer.readLine());
/*
                nombre= builder.substring(subString);
                subString++;
                apellido=builder.substring(subString);
                subString++;
                añoNacimiento= Integer.parseInt(builder.substring(subString));
                subString++;
                calle= builder.substring(subString);
                subString++;
                numero= Integer.parseInt(builder.substring(subString));
                subString++;*/

                /*for (int j = 0; j < linea.length(); j++) {

                   caracter=linea.charAt(i);



                   if (caracter== '\t'){


                   }*/

                //}
                nombre="A";

                apellido="b";

                añoNacimiento= 1992;

                calle= "CALLE";

                numero= 23;


              alumno=new Alumno(nombre,apellido,añoNacimiento,calle,numero);
              nuevaAula.add(alumno);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        nuevaAula.informacionAlumnos();
    }
}