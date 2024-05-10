package entornos_de_desarrollo.ej1;

import java.time.LocalDate;
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
        List<Habitacion> habitaciones = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();
        List<Hotel> hoteles = new ArrayList<>();

        habitaciones.add(new Habitacion(1, true, 1));
        habitaciones.add(new Habitacion(2, true, 2));
        habitaciones.add(new Habitacion(3, true, 4));
        habitaciones.add(new Habitacion(4, true, 6));
        habitaciones.add(new Habitacion(5, true, 1));
        habitaciones.add(new Habitacion(6, true, 2));
        habitaciones.add(new Habitacion(7, true, 1));
        habitaciones.add(new Habitacion(8, true, 2));
        habitaciones.add(new Habitacion(9, true, 1));
        habitaciones.add(new Habitacion(10, true, 2));

        Hotel hotel1 = new Hotel(1, "HOTEL 1", "Calle 1", "123456789",habitaciones);
        Hotel hotel2 = new Hotel(2, "HOTEL 2", "Calle 2", "123456789",habitaciones);
        Hotel hotel3 = new Hotel(3, "HOTEL 3", "Calle 3", "123456789",habitaciones);
        hoteles.add(hotel1);
        hoteles.add(hotel2);
        hoteles.add(hotel3);




        usuarios.add(new Administrador("admin","admin","admin@hotel.com","admin"));
        usuarios.add(new Cliente("prueba","apelldio","correo@ejemplo.com","123"));




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
                                do {

                                    System.out.println("Has iniciado sesion " + usuarios.get(i).getNombre());
                                    System.out.println("Elija una opción:");
                                    System.out.println("1. Ver reservas sin factura");
                                    System.out.println("2. Ver reservas del dia de hoy sin factura");
                                    System.out.println("0. Salir");

                                    opcion = sc.nextInt();

                                    switch (opcion) {
                                        case 1:
                                            System.out.println("LAS RESERVAS SON : ");
                                            for (int j = 0; j < usuarios.size(); j++) {

                                                if (usuarios.get(j) instanceof Cliente) {

                                                    ((Cliente) usuarios.get(j)).verReservasAdmin();

                                                }
                                            }

                                            break;
                                        case 2:
                                            System.out.println("LAS RESERVAS DE HOY  SON : ");
                                            for (int j = 0; j < usuarios.size(); j++) {

                                                if (usuarios.get(j) instanceof Cliente) {

                                                    ((Cliente) usuarios.get(j)).verReservasAdminDelDia();

                                                }
                                            }

                                            break;
                                        case 0:
                                            System.out.println("¡Adiós!");
                                            break;
                                        default:
                                            System.out.println("Opción no válida");
                                    }

                                }while (opcion != 0);
                            }else if (usuarios.get(i) instanceof Cliente){
                                do {

                                    System.out.println("Has iniciado sesion " + usuarios.get(i).getNombre());
                                    System.out.println("Elija una opción:");
                                    System.out.println("1. Hacer reserva");
                                    System.out.println("2. Ver reservas");
                                    System.out.println("0. Salir");

                                    opcion = sc.nextInt();

                                    switch (opcion) {
                                        case 1:
                                           // ((Cliente) usuarios.get(i)).realizarReserva();
                                            System.out.println("Ingrese la fecha de entrada (YYYY-MM-DD):");
                                            sc.nextLine();
                                            String entradaStr = sc.nextLine();
                                            LocalDate fechaEntrada = LocalDate.parse(entradaStr);

                                            System.out.println("Ingrese la fecha de salida (YYYY-MM-DD):");
                                            String salidaStr = sc.nextLine();
                                            LocalDate fechaSalida = LocalDate.parse(salidaStr);

                                            System.out.println("Ingrese el número de personas:");
                                            int numeroPersonas = sc.nextInt();
                                            sc.nextLine();

                                            System.out.println("Los hoteles disponibles son: ");
                                            for (int j = 0; j < hoteles.size(); j++) {
                                                System.out.println(hoteles.get(j).toString());
                                            }

                                            System.out.println("Elija un hotel:");
                                            int hotelElegido = sc.nextInt();
                                            sc.nextLine();

                                            Hotel hotel = hoteles.get(hotelElegido - 1);

                                            System.out.println("Las habitaciones disponibles son: ");
                                            for (int j = 0; j < habitaciones.size(); j++) {
                                                System.out.println(habitaciones.get(j).toString());
                                            }

                                            System.out.println("Elija una habitación:");
                                            int habitacionElegida = sc.nextInt();
                                            sc.nextLine();

                                            Habitacion habitacion = habitaciones.get(habitacionElegida - 1);

                                            System.out.println("Habitación elegida: " + habitacion.toString());

                                            Reserva reserva = new Reserva(fechaEntrada, fechaSalida, habitacion, hotel, numeroPersonas);

                                            ((Cliente) usuarios.get(i)).realizarReserva(reserva);
                                            System.out.println("Reserva realizada");

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
                   /* else {
                        System.out.println("OPCION INCORRECTA");
                    }*/
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
