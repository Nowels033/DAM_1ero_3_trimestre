package examen_Recuperacion2Ev;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MainRecuperacion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce el tamaño de los fondos prestables");
        int tamaño = sc.nextInt();

        ArrayList<FondoPrestable> biblioteca = new ArrayList<>(tamaño);
        int numero;
        do {
            numero = menu();

            switch (numero) {
                case 1:
                    System.out.println("1----------------DAR DE ALTA UN LIBRO");
                    biblioteca.add(darDeAltaLibro());
                    break;
                case 2:
                    System.out.println("2----------------DAR DE ALTA UN VIDEO");
                    biblioteca.add(darDeAltaVideo());

                    break;
                case 3:
                    System.out.println("3----------PRESTAR UN FONDO PRESTABLE");
                    prestarFondo(biblioteca);

                    break;
                case 4:
                    System.out.println("3----------DEVOLVER UN FONDO PRESTABLE");
                    devolverFondo(biblioteca);

                    break;
                case 5:
                    System.out.println("5----ORDENAR POR FECHA DISPONIBILIDAD");

                    ordenarPorFechaDisponibilidad(biblioteca);


                    for (FondoPrestable fp : biblioteca) {
                        System.out.println(fp);
                    }

                    break;
                case 0:
                    System.out.println("0--------------------------------SALIR");
                    break;

                default:

                    System.out.println("VUELTA AL MENU DE FONDO PRESTABLE");
                    break;
            }

        }while (numero!= 0);

    }
    public static void ordenarPorFechaDisponibilidad(ArrayList<FondoPrestable> biblioteca) {
        Collections.sort(biblioteca, new Comparator<FondoPrestable>() {
            @Override
            public int compare(FondoPrestable fp1, FondoPrestable fp2) {
                if (fp1.getFechaDisponibilidad() == null && fp2.getFechaDisponibilidad() == null) {
                    return 0;
                } else if (fp1.getFechaDisponibilidad() == null) {
                    return -1;
                } else if (fp2.getFechaDisponibilidad() == null) {
                    return 1;
                } else {
                    return fp1.getFechaDisponibilidad().compareTo(fp2.getFechaDisponibilidad());
                }
            }
        });
    }
    public static void devolverFondo(ArrayList<FondoPrestable> arrayList) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arrayList.size(); i++) {

            System.out.println((i + 1) + "--" + arrayList.get(i).getTitulo());

        }
        System.out.println("QUE FONDO DESEAS DEVOLVER ((INTRODUCE EL NUMERO DE LA IZQUIERDA))");
        int numero = sc.nextInt();
        arrayList.get(numero - 1).devolver();

    }


    public static void prestarFondo(ArrayList<FondoPrestable> arrayList) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arrayList.size(); i++) {

            System.out.println((i + 1) + "--" + arrayList.get(i).getTitulo());

        }
        System.out.println("QUE FONDO DESEAS PRESTAR ((INTRODUCE EL NUMERO DE LA IZQUIERDA))");
        int numero = sc.nextInt();
        arrayList.get(numero - 1).prestar();

    }

    public static int menu() {
        int numero = 0;
        Scanner sc = new Scanner(System.in);
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("------------MENU DE FONDOS PRESTABLES");
                System.out.println("1----------------DAR DE ALTA UN LIBRO");
                System.out.println("2----------------DAR DE ALTA UN VIDEO");
                System.out.println("3----------PRESTAR UN FONDO PRESTABLE");
                System.out.println("4---------DEVOLVER UN FONDO PRESTABLE");
                System.out.println("5----ORDENAR POR FECHA DISPONIBILIDAD");
                System.out.println("0-------------------------------SALIR");
                numero = sc.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número entero.");
                sc.nextLine(); 
            }
        }

        return numero;
    }


    public static Libro darDeAltaLibro() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String titulo;
        String ISBN;
        LocalDate fechaPublicacion = null;
        FondoPrestable fondo;

        System.out.println("Titulo del fondo prestable");
        titulo = sc.nextLine();
        System.out.println("ISBN del fondo prestable");
        ISBN = sc.nextLine();
        System.out.println("Introduce una fecha en formato yyyy-MM-dd:");
        String inputFecha = sc.nextLine();

        try {
            fechaPublicacion = LocalDate.parse(inputFecha, formatter);

        } catch (Exception e) {
            System.out.println("Error: Formato de fecha incorrecto. Asegúrate de usar el formato yyyy-MM-dd.");
        }
        System.out.println("¿ES UN LIBRO(1) O UNA PELICULA?(2)");


        System.out.println("Autor del fondo prestable");
        String autor = sc.nextLine();
        System.out.println("Numero de paginas del fondo prestable");
        int numPaginas = sc.nextInt();
        Libro libro = new Libro(titulo, ISBN, fechaPublicacion, autor, numPaginas);
        return libro;

    }

    public static Video darDeAltaVideo() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String titulo;
        String ISBN;
        LocalDate fechaPublicacion = null;
        FondoPrestable fondo;

        System.out.println("Titulo del fondo prestable");
        titulo = sc.nextLine();
        System.out.println("ISBN del fondo prestable");
        ISBN = sc.nextLine();
        System.out.println("Introduce una fecha en formato yyyy-MM-dd:");
        String inputFecha = sc.nextLine();

        try {
            fechaPublicacion = LocalDate.parse(inputFecha, formatter);

        } catch (Exception e) {
            System.out.println("Error: Formato de fecha incorrecto. Asegúrate de usar el formato yyyy-MM-dd.");
        }
        System.out.println("¿ES UN LIBRO(1) O UNA PELICULA?(2)");


        System.out.println("Director del fondo prestable");
        String director = sc.nextLine();
        System.out.println("Numero de minutos del fondo prestable");
        int duracion = sc.nextInt();
        Video video = new Video(titulo, ISBN, fechaPublicacion, director, duracion);
        return video;

    }


}
