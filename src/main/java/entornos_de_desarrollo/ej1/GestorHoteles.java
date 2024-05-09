package entornos_de_desarrollo.ej1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorHoteles {
    public static void main(String[] args) {


        gestorHoteles();

    }

    public static int menu (){
        Scanner sc = new Scanner(System.in);
        int menu;

        System.out.println("--------------GESTOR DE HOTELES-------------");
        System.out.println("-1-INICIAR SESION---------------------------");
        System.out.println("-2-REGISTRARSE EN EL GESTOR DE HOTELES------");
        System.out.println("-0-SALIR------------------------------------");
        System.out.println("-INTRODUCE UNA OPCION-----------------------");
        menu= sc.nextInt();
        return menu;

    }
    public static void gestorHoteles(){
        List<Usuario> usuarios = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;
        final int codigoAdmin=123456;
        do {
            opcion = menu();

            switch (opcion) {
                case 1:
                    System.out.println("--INICIAR SESION---------------------------");
                    System.out.println("Introduce tu correo electronico");
                    String correoE = sc.nextLine();
                    System.out.println("Introduce tu contraseña");
                    String inicioSesion = sc.nextLine();
                    for (int i = 0; i < usuarios.size(); i++) {

                        if (usuarios.get(i).getCorreo().equalsIgnoreCase(correoE) && usuarios.get(i).getContrasenia_user().equals(inicioSesion)) {
                            System.out.println("BIENVENIDO " + usuarios.get(i).getNombre() + " " + usuarios.get(i).getApellido());

                            if (usuarios.get(i) instanceof Administrador){
                                // Administrador admin=(Administrador) usuarios.get(i);
                                System.out.println("Has iniciado sesion como administrador " + usuarios.get(i).getNombre());

                            }else if (usuarios.get(i) instanceof Cliente){
                                do {

                                    System.out.println("Has iniciado sesion " + usuarios.get(i).getNombre());
                                    System.out.println("Elija una opción:");
                                    System.out.println("1. Hacer reserva");
                                    System.out.println("2. Ver reservas");
                                    System.out.println("3. salir");

                                    opcion = sc.nextInt();

                                    switch (opcion) {
                                        case 1:

                                            break;
                                        case 2:
                                            System.out.println("TUS RESERVAS SON : ");
                                            ((Cliente) usuarios.get(i)).verReservas();

                                            break;
                                        case 0:
                                            System.out.println("¡Adiós!");
                                            break;
                                        default:
                                            System.out.println("Opción no válida");
                                    }

                                }while (opcion != 0);
                            }
                            else {
                                System.out.println("Error");
                            }

                        }

                    }




                    break;
                case 2:
                    System.out.println("--REGISTRARSE EN EL GESTOR DE HOTELES------");
                    System.out.println("1-CREAR USUARIO ADMINISTRADOR--------------");
                    System.out.println("2-CREAR USUARIO CLIENTE--------------------");
                    int adminOCliente = sc.nextInt();
                    if (adminOCliente ==1){
                        System.out.println("Introduce el codigo proporcionado por la empresa");
                        int codigo=sc.nextInt();
                        if (codigo==codigoAdmin){

                            System.out.println("Codigo correcto ");
                            System.out.println("Introduce tu nombre");
                            sc.nextLine();
                            String nombre = sc.nextLine();
                            System.out.println("Introduce tu apellido");
                            String apellido = sc.nextLine();
                            System.out.println("Introduce tu correo electronico");
                            String correo = sc.nextLine();
                            String contrasenia;
                            String verifyContrasenia;
                            do {


                                System.out.println("Introduce tu contraseña");
                                contrasenia = sc.nextLine();
                                System.out.println("Vuelve a introducir la contraseña");
                                verifyContrasenia = sc.nextLine();
                                if (!contrasenia.equals(verifyContrasenia)){
                                    System.out.println("Las contraseñas no son iguales");
                                }
                            }while (!contrasenia.equals(verifyContrasenia));

                            Administrador admin = new Administrador(nombre,apellido,correo,contrasenia);
                            usuarios.add(admin);
                            System.out.println("ADMINISTRADOR CREADO CORRECTAMENTE");
                        }
                        else{
                            System.out.println("Codigo incorrecto contacta con la empresa");
                        }
                    }
                    if (adminOCliente==2){

                        System.out.println("Introduce tu nombre");
                        sc.nextLine();
                        String nombre = sc.nextLine();
                        System.out.println("Introduce tu apellido");
                        String apellido = sc.nextLine();
                        System.out.println("Introduce tu correo electronico");
                        String correo = sc.nextLine();
                        String contrasenia;
                        String verifyContrasenia;
                        do {


                            System.out.println("Introduce tu contraseña");
                            contrasenia = sc.nextLine();
                            System.out.println("Vuelve a introducir la contraseña");
                            verifyContrasenia = sc.nextLine();
                            if (!contrasenia.equals(verifyContrasenia)){
                                System.out.println("Las contraseñas no son iguales");
                            }
                        }while (!contrasenia.equals(verifyContrasenia));

                        Cliente client = new Cliente(nombre,apellido,correo,contrasenia);
                        usuarios.add(client);
                        System.out.println("CLIENTE CREADO CORRECTAMENTE");

                    }
                    else {
                        System.out.println("OPCION INCORRECTA");
                    }
                    break;
                case 0:
                    System.out.println("¡ADIOS!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }



        }while(opcion != 0);

    }
}
