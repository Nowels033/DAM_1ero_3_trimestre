package entornos_de_desarrollo.ej7_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorDeNotas {



    public static void main(String[] args) {



        Asignatura asignatura1 = new Asignatura("Matematicas", "Primero");
        Asignatura asignatura2 = new Asignatura("Ingles", "Primero");
        Asignatura asignatura3 = new Asignatura("Fisica", "Segundo");

        List<Asignatura> asignatura = new ArrayList<Asignatura>();

        asignatura.add(asignatura1);
        asignatura.add(asignatura2);
        asignatura.add(asignatura3);

        Profesor profesor1 = new Profesor("Pepe", "Perez", "Calle falsa 123", "JQ3ZV@example.com", 123456789,"123");
        Profesor profesor2 = new Profesor("Juan", "Perez", "Calle falsa 123", "JQ3ZV@example.com", 123456789,"123");

        Alumno alumno1 = new Alumno("Pablo", "Perez", "Calle falsa 123", "JQ3ZV@example.com", 123456789,"123");
        Alumno alumno2 = new Alumno("Brayan", "Ochoa", "Calle falsa 123", "JQ3ZV@example.com", 123456789,"123");

        List <Persona> ccc = new ArrayList<Persona>();

        ccc.add(profesor1);
        ccc.add(profesor2);
        ccc.add(alumno1);
        ccc.add(alumno2);

        Scanner sc = new Scanner(System.in);
        int op;

       do {
           System.out.println("MENU GESTION DE NOTAS");
           System.out.println("1. INICIAR SESION");
           System.out.println("2. RESGISTRARSE");
           System.out.println("0. SALIR");
           System.out.println("INGRESA UNA OPCION");
            op = sc.nextInt();

           switch (op) {
               case 1:
                   inicioSesion(ccc);
                   break;
               case 2:
                   registro(ccc);
                   break;
               case 0:
                   System.out.println("GRACIAS POR UTILIZAR EL GESTOR DE NOTAS");
                   break;
               default:
                   System.out.println("OPCION INCORRECTA");
           }

       } while (op != 0);



    }
    public static void registro(List<Persona> ccc){
        final int codigoProfesor = 1;
        final int codigoAlumno = 2;

        System.out.println("REGISTRO");
        System.out.println("INGRESA UNA TU CODIGO DE REGISTRO");
        Scanner sc = new Scanner(System.in);
        int op;
        op = sc.nextInt();

        if (op == codigoAlumno){
            System.out.println("REGISTRO DE ALUMNO");
            System.out.println("INTRODUCE TU NOMBRE");
            sc.nextLine();
            String nombre = sc.nextLine();
            System.out.println("INTRODUCE TUS APELLIDOS");
            String apellidos = sc.nextLine();
            System.out.println("INTRODUCE TU DIRECCION");
            String direccion = sc.nextLine();
            System.out.println("INTRODUCE TU CORREO");
            String correo = sc.nextLine();
            System.out.println("INTRODUCE TU TELEFONO");
            int telefono = sc.nextInt();
            sc.nextLine();
            String contrasenia;
            String contraseniaVerificar;
            do {
                System.out.println("INTRODUCE TU CONTRASEÑA");
                contrasenia = sc.nextLine();
                System.out.println("VUELVE A INTRODUCIR TU CONTRASEÑA");
                contraseniaVerificar = sc.nextLine();

                if (!contrasenia.equals(contraseniaVerificar)){
                    System.out.println("LAS CONTRASEÑAS NO COINCIDEN");
                }
            } while (!contrasenia.equals(contraseniaVerificar));

            if (contrasenia.equals(contraseniaVerificar)){
                System.out.println("CONTRASENIA CORRECTA");
            }

            Alumno alumno1 = new Alumno(nombre, apellidos, direccion, correo, telefono,contrasenia);
            ccc.add(alumno1);
        }else if (op == codigoProfesor){
            System.out.println("REGISTRO DE PROFESOR");
            System.out.println("INTRODUCE TU NOMBRE");
            sc.nextLine();
            String nombre = sc.nextLine();
            System.out.println("INTRODUCE TUS APELLIDOS");
            String apellidos = sc.nextLine();
            System.out.println("INTRODUCE TU DIRECCION");
            String direccion = sc.nextLine();
            System.out.println("INTRODUCE TU CORREO");
            String correo = sc.nextLine();
            System.out.println("INTRODUCE TU TELEFONO");
            int telefono = sc.nextInt();
            sc.nextLine();
            String contrasenia;
            String contraseniaVerificar;
            do {
                System.out.println("INTRODUCE TU CONTRASEÑA");
                 contrasenia = sc.nextLine();
                System.out.println("VUELVE A INTRODUCIR TU CONTRASEÑA");
                contraseniaVerificar = sc.nextLine();

                if (!contrasenia.equals(contraseniaVerificar)){
                    System.out.println("LAS CONTRASEÑAS NO COINCIDEN");
                }
            } while (!contrasenia.equals(contraseniaVerificar));

            if (contrasenia.equals(contraseniaVerificar)){
                System.out.println("CONTRASENIA CORRECTA");
            }

            Profesor profesor1 = new Profesor(nombre, apellidos, direccion, correo, telefono,contrasenia);
            ccc.add(profesor1);
        }


    }
    public static void inicioSesion(List<Persona> ccc){
        System.out.println("INICIAR SESION");
        System.out.println("INTRODUCE TU CORREO");
        Scanner sc = new Scanner(System.in);
        String correo = sc.nextLine();
        System.out.println("INTRODUCE TU CONTRASEÑA");
        String contrasenia = sc.nextLine();

        for (int i = 0; i < ccc.size(); i++){
            if (ccc.get(i).getCorreo().equals(correo) && ccc.get(i).getContrasenia().equals(contrasenia)){
                System.out.println("BIENVENIDO");

                if (ccc.get(i) instanceof Alumno){
                    Alumno alumno = (Alumno) ccc.get(i);

                }

                if (ccc.get(i) instanceof Profesor){
                    Profesor profesor = (Profesor) ccc.get(i);

                }
            }
        }
    }


}
