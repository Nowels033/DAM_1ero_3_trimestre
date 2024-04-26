package Examen_Ficheros;

import examen_Recuperacion2Ev.FondoPrestable;

import java.util.Scanner;

public class MainExamen {

    public static void main(String[] args) {

        String rutaFichero;
        Scanner sc = new Scanner(System.in);
        int numero;
        int tamañoAula;

        do {
            System.out.println("MENU EXAMEN FICHEROS");
            System.out.println("-1-CREAR UN ALULA CON ALUMNOS");
            System.out.println("-2-LLAMAR AL METODO ESCRIBIR ALUMNOS");
            System.out.println("-3-LLAMAR AL METODO LEER ALUMNOS");
            numero = sc.nextInt();

            switch (numero) {
                case 1:
                    System.out.println("Introduce la ruta del fichero completa EJEMPLO = 'C:\\dir1\\alumnos.data'");
                    sc.nextLine();
                    rutaFichero=sc.nextLine();
                    Aula.construirAulaConFichero(rutaFichero);
                    break;
                case 2:
                    System.out.println("Introduce la ruta del fichero completa  EJEMPLO = 'C:\\dir1\\alumnos.data'");
                    sc.nextLine();
                    rutaFichero=sc.nextLine();

                    Aula.escribirAlumnos(rutaFichero);

                    break;
                case 3:
                    System.out.println("Introduce la ruta del fichero completa  EJEMPLO = 'C:\\dir1\\alumnos.data'");
                    sc.nextLine();
                    rutaFichero=sc.nextLine();

                    Aula.leerFicheroAlumno(rutaFichero);

                    break;

                case 0:
                    System.out.println("0--------------------------------SALIR");
                    break;

                default:

                    System.out.println("VUELTA AL MENU ");
                    break;
            }

        }while (numero!= 0);

        System.out.println("FIN DE PROGRAMA");

    }


}
