package reto5_serializacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*2. Gestión de un fichero binario

        MENU
 ------------------------------------------
1-Crear un fichero con datos (5 Clientes) Clientes.bin
-Codigo
-Nombre
-Direccion
2-Añadir cliente nuevo
3-Modificar un cliente (según el número de cliente, crear otro archivo auxiliar para hacer la modificación
y luego copiarlo en el original)
4-Borrar un cliente
5-Consultar los datos de un cliente
0-Salir

 Métodos
 -----------------
crearFichero
añadirCliente
consultarCliente
modificarCliente
borrarCliente*/
public class Ejercicio2 {
    public static void main(String[] args) {

    menu();

    }
    public static void crearFichero(List<Cliente>clientes){
        Cliente cl1 = new Cliente(0,"HULIO","C/PACO PORRAS");
        Cliente cl2 = new Cliente(1,"PACO","C/PIPO PORRAS");
        Cliente cl3 = new Cliente(2,"SEBASTIAN","C/ESPAÑA");
        Cliente cl4 = new Cliente(3,"BRAYA","C/EGIPTO");
        Cliente cl5 = new Cliente(4,"PABLO","C/RIVAS FUTURA");
        clientes.add(cl1);
        clientes.add(cl2);
        clientes.add(cl3);
        clientes.add(cl4);
        clientes.add(cl5);
        try {
            ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream( "C:\\dir1\\Clientes.bin"));
            escribirFichero.writeObject(clientes);
            escribirFichero.close();
            System.out.println("FICHERO CREADO CORRECTAMENTE");
        } catch (IOException  e) {
            throw new RuntimeException(e);
        }

    }
    public static List<Cliente> añadirCLiente(List<Cliente>clientes){
        Scanner sc = new Scanner(System.in);

        try {
            ObjectInputStream recuperarFichero = new ObjectInputStream(new FileInputStream("C:\\dir1\\Clientes.bin"));
            clientes = (List<Cliente>) recuperarFichero.readObject();
            recuperarFichero.close();

            System.out.println("2-Añadir cliente nuevo");
            //System.out.println("Introduce el codigo de cliente");
            //sc.nextLine();
            int codigo=clientes.get(clientes.size()-1).getCodigo()+1;
            System.out.println("Introduce el nombre de el cliente");
            String nombre=sc.nextLine();
            System.out.println("Introduce la direccion del cliente");
            String direccion = sc.nextLine();

            Cliente nuevoCliente = new Cliente(codigo,nombre,direccion);
            clientes.add(nuevoCliente);

            ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream( "C:\\dir1\\Clientes.bin"));
            escribirFichero.writeObject(clientes);
            escribirFichero.close();
            System.out.println("CLIENTE :"+nuevoCliente.getNombre()+" AÑADIDO");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return clientes;
    }

    public static void verFichero(){
        try {
            ObjectInputStream recuperarFichero = new ObjectInputStream(new FileInputStream("C:\\dir1\\Clientes.bin"));
            List<Cliente> clientes = (List<Cliente>) recuperarFichero.readObject();
            recuperarFichero.close();

            for (Cliente e: clientes) {

                System.out.println(e);

            }

            Thread.sleep(5000);

        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public static void borrarCliente(){
        List<Cliente> clientes =new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        try {
            ObjectInputStream recuperarFichero = new ObjectInputStream(new FileInputStream("C:\\dir1\\Clientes.bin"));
           clientes = (List<Cliente>) recuperarFichero.readObject();
            recuperarFichero.close();

            System.out.println("CLIENTES EN EL FICHERO");
            for (Cliente e: clientes) {

                System.out.println(e);

            }

            Thread.sleep(5000);
            System.out.println("INTRODUCE EL CODIGO DE CLIENTE PARA ELIMINAR UN CLIENTE");
            int codigo=sc.nextInt();


            for (Cliente e: clientes) {

               if (codigo==e.getCodigo()){

                   System.out.println("SEGURO QUE DESEA BORRAR AL CLIENTE :"+e.getNombre());
                   System.out.println("SI (introducir (S)) O NO (introducir (N))");
                   sc.nextLine();
                   char siONo=sc.nextLine().toLowerCase().charAt(0);
                   if (siONo=='s'){
                       System.out.println("SE BORRO AL CLIENTE : "+e.getNombre());
                       clientes.remove(e);
                   }
                   else{
                       System.out.println("NO SE LLEGO A BORRAR AL CLIENTE : "+e.getNombre());
                   }

               }

            }

            for (int i = 0; i < clientes.size(); i++) {
                clientes.get(i).setCodigo(i);
            }


            try {

                ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream( "C:\\dir1\\Clientes.bin"));
                escribirFichero.writeObject(clientes);
                escribirFichero.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public static void modificarCliente(){
        List<Cliente> clientes =new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        try {
            ObjectInputStream recuperarFichero = new ObjectInputStream(new FileInputStream("C:\\dir1\\Clientes.bin"));
            clientes = (List<Cliente>) recuperarFichero.readObject();
            recuperarFichero.close();

            System.out.println("CLIENTES EN EL FICHERO");
            for (Cliente e: clientes) {

                System.out.println(e);

            }

            Thread.sleep(5000);
            System.out.println("INTRODUCE EL CODIGO DE CLIENTE PARA MODIFICAR UN CLIENTE");
            int codigo=sc.nextInt();

            for (Cliente e: clientes) {

                if (codigo==e.getCodigo()){

                    System.out.println("SEGURO QUE DESEA MODIFICAR AL CLIENTE :"+e.getNombre());
                    System.out.println("SI (introducir (S)) O NO (introducir (N))");
                    char siONo=sc.nextLine().toLowerCase().charAt(0);
                    if (siONo=='s'){

                        System.out.println("INTRODUCE UN NUEVO NOMBRE DE CLIENTE");
                        String nombre = sc.nextLine();
                        e.setNombre(nombre);
                        System.out.println("INTRODUCE UNA NUEVA DIRECCION DE CLIENTE");
                        String direccion = sc.nextLine();
                        e.setNombre(direccion);

                        System.out.println("SE MODIFICO AL CLIENTE : "+e);

                    }
                    else{
                        System.out.println("NO SE LLEGO A MODIFICAR AL CLIENTE : "+e.getNombre());
                    }

                }

            }

            try {

                ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream( "C:\\dir1\\Clientes.bin"));
                escribirFichero.writeObject(clientes);
                escribirFichero.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public static void menu(){
        List<Cliente> clientes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("-#MENU EJERCICIO 2 SERIALIZACION#-");
            System.out.println("1-Crear un fichero con datos (5 Clientes) Clientes.bin");
            System.out.println("2-Añadir cliente nuevo");
            System.out.println("3-Ver fichero de clientes");
            System.out.println("4-Modificar un cliente (según el número de cliente, crear otro archivo auxiliar para hacer la modificación");
            System.out.println("5-Borrar un cliente");
            System.out.println("6-Consultar los datos de un cliente");
            System.out.println("0-Salir");

            opcion=sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearFichero(clientes);
                    break;
                case 2:
                    añadirCLiente(clientes);
                    break;
                case 3:
                    System.out.println("FICHERO DE CLIENTES");
                    verFichero();
                    break;
                case 4:
                    System.out.println("4-Modificar un cliente (según el número de cliente, crear otro archivo auxiliar para hacer la modificación");
                    break;
                case 5:
                    System.out.println("5-Borrar un cliente");
                    borrarCliente();
                    break;
                case 0:
                    System.out.println("--SALIR DE PROGRAMA--");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;

            }
        }while (opcion != 0);

        System.out.println("--FIN DE PROGRAMA--");

    }


}
