package examenFinal_Noel_Dominguez;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Final3 {

    public static void main(String[] args) {
        exmanen3Ev();

    }

    public static void insertardatosFichero(String ruta) {

    //METODO PARA INSERTAR DATOS AL FICHERO


        Scanner sc = new Scanner(System.in);

        try {


            FileOutputStream fos = new FileOutputStream(ruta + "\\ciudades.bin");
            DataOutputStream dos = new DataOutputStream(fos);
            File dir = new File(ruta + "\\ciudades.bin");
            if (dir.exists()) {
                dos.writeUTF("Las rozas");
                dos.writeInt(95071);
                dos.writeInt(35390);
                dos.writeInt(50286);
                dos.writeDouble(58.31);
                dos.writeDouble(0);
                dos.writeDouble(0);

                dos.writeUTF("Colmenar Viejo");
                dos.writeInt(48614);
                dos.writeInt(18925);
                dos.writeInt(31360);
                dos.writeDouble(182.56);
                dos.writeDouble(0);
                dos.writeDouble(0);

                dos.writeUTF("Tres Cantos");
                dos.writeInt(46046);
                dos.writeInt(14460);
                dos.writeInt(41048);
                dos.writeDouble(37.93);
                dos.writeDouble(0);
                dos.writeDouble(0);

                dos.writeUTF("Aranjuez");
                dos.writeInt(52213);
                dos.writeInt(24790);
                dos.writeInt(26386);
                dos.writeDouble(201.11);
                dos.writeDouble(0);
                dos.writeDouble(0);

                dos.writeUTF("Fuenlabrada");
                dos.writeInt(194669);
                dos.writeInt(70835);
                dos.writeInt(22092);
                dos.writeDouble(39.45);
                dos.writeDouble(0);
                dos.writeDouble(0);


            } else {
                System.out.println("El fichero no existe");
            }


            dos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println("ENTRANDO EN EL SIGUIENTE EJERCICIO");
        }

    }

    public static void modificarDatostosFichero(String ruta) {

        //METODO PARA MODIFICAR DATOS AL FICHERO

        Scanner sc = new Scanner(System.in);
        try {
            int poblacion, renta;
            double extension, densidadPoblacion, riqueza;

            FileOutputStream fos = new FileOutputStream(ruta + "\\ciudades.bin", true);
            DataOutputStream dos = new DataOutputStream(fos);


            FileInputStream fis = new FileInputStream(ruta + "\\ciudades.bin");
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() > 0) {
                dis.readUTF();
                poblacion = dis.readInt();
                dis.readInt();
                renta = dis.readInt();
                extension = dis.readDouble();
                densidadPoblacion = (densidadPoblacion(poblacion, extension));
                dos.writeDouble(densidadPoblacion);
                riqueza = riqueza(renta, poblacion);
                dos.writeDouble(riqueza);


            }
            fos.close();
            dos.close();
            dis.close();
            fis.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println("ENTRANDO EN EL SIGUIENTE EJERCICIO");
        }

    }

    public static void visualizarDatosFichero(String ruta) {


        //METODO PARA VISUALIZAR DATOS DEL FICHERO



        Scanner sc = new Scanner(System.in);
        try {
            int poblacion, renta, viviendas;
            double extension, densidadPoblacion, riqueza;
            String nombre;

            FileInputStream fis = new FileInputStream(ruta + "\\ciudades.bin");
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() > 0) {
                nombre = dis.readUTF();
                poblacion = dis.readInt();
                viviendas = dis.readInt();
                renta = dis.readInt();
                extension = dis.readDouble();
                densidadPoblacion = dis.readDouble();
                riqueza = dis.readDouble();

                System.out.println("Nombre : " + nombre + ", Poblacion : " + poblacion + ", Viviendas : " + viviendas + ", Renta : " + renta + ", Extension : " + extension + ", Densidad Poblacion : " + densidadPoblacion + ", Riqueza : " + riqueza);


            }

            dis.close();
            fis.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println("ENTRANDO EN EL SIGUIENTE EJERCICIO");
        }
    }

    public static double densidadPoblacion(double poblacion, double extension) {

        //METODO PARA CALCULAR LA DENSIDAD DE POBLACIÓN

        return poblacion / extension;
    }

    ;

    public static double riqueza(double renta, double poblacion) {

        //METODO PARA CALCULAR LA RIQUEZA

        return renta * poblacion;
    }

    public static void exmanen3Ev() {
        //METODO DONDE QUE SE EJECUTARA EL MAIN CON TODOS LOS METODOS
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa la ruta donde se creara el fichero: ciudades.bin EJEMPLO: C:\\\\dir1");
        String ruta = sc.nextLine();
        insertardatosFichero(ruta);
        modificarDatostosFichero(ruta);
        visualizarDatosFichero(ruta);
        ejercicio2AccesoBBDD(ruta);
    }

    public static void ejercicio2AccesoBBDD(String ruta) {

        //METODO DONDE SE EJECUTA EL EJERCICIO 2

        Scanner scanner = new Scanner(System.in);

        System.out.println("ACABAS DE ENTRAR AL EJERCICIO 2 ACCESO A BBDD");

        //creamos la url con user y admin para conectarnos a la BD
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "admin";


        //SENTENCIAS SQL
        final String instSQLCrearBD = "create database if not exists datosdeciudades";
        final String instSQLUsarBD = "use datosdeciudades;";




        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión exitosa a la base de datos");

            Statement statement = connection.createStatement();

            // CREAMOS LA BD
            statement.execute(instSQLCrearBD);

            //SELECCIONAMOS LA BD
            statement.execute(instSQLUsarBD);

            System.out.println("quieres crear la tabla ciudades? (s/n)");
            char respuesta = scanner.nextLine().toLowerCase().charAt(0);
            if (respuesta == 's') {
                crearBBDDTabla(connection);
            }

            System.out.println("quieres insertar los datos? (s/n)");
            respuesta = scanner.nextLine().toLowerCase().charAt(0);
            if (respuesta == 's') {
                insertarDatosBBDD(ruta);
            }
            System.out.println("QUieres eleminar una ciudad? (s/n)");
            respuesta = scanner.nextLine().toLowerCase().charAt(0);
            if (respuesta == 's') {
                borrarDatos();
            }

            System.out.println("Quieres mostrar los datos de la tabla ciudades? (s/n)");
            respuesta = scanner.nextLine().toLowerCase().charAt(0);
            if (respuesta == 's') {
                visualizarBBDD();
            }

            System.out.println("FIN DEL EXAMEN");

            connection.close();





        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

    }

    public static void crearBBDDTabla( Connection connection) {

        //METODO DONDE SE EJECUTA CREA LA TABLA CIUDADES

        Scanner scanner = new Scanner(System.in);
        //creamos la url con user y admin para conectarnos a la BD
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "admin";


        //SENTENCIAS SQL
        final String instSQLCrearBD = "create database if not exists datosdeciudades";
        final String instSQLUsarBD = "use datosdeciudades";
        final String instSQLCrearTabla = "create table ciudades(" +
                "  id int auto_increment primary key," +
                "  nombre varchar(30)," +
                "  poblacion int," +
                "  viviendas int," +
                "  renta int," +
                "  extension double," +
                "  densidadPoblacion double," +
                "  riqueza double);";


        try  {



            Statement statement = connection.createStatement();


            //SELECCIONAMOS LA BD
            statement.executeUpdate(instSQLUsarBD);


            statement.executeUpdate(instSQLCrearTabla);

            System.out.println("SE CREO LA TABLA CORRECTAMENTE");


        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public static void insertarDatosBBDD(String ruta) {

    //METODO DONDE SE INSERTAN LOS DATOS A LA TABLA CIUDADES
        Scanner scanner = new Scanner(System.in);
        //creamos la url con user y admin para conectarnos a la BD
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "admin";


        //SENTENCIAS SQL

        final String instSQLUsarBD = "use datosdeciudades";
        final String instSQLInsertar = "insert into ciudades(nombre,poblacion,viviendas,renta,extension,densidadPoblacion,riqueza) values(?,?,?,?,?,?,?)";



        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            Statement statement = connection.createStatement();


            //SELECCIONAMOS LA BD
            statement.executeUpdate(instSQLUsarBD);

            try {
                int poblacion, renta, viviendas;
                double extension, densidadPoblacion, riqueza;
                String nombre;

                FileInputStream fis = new FileInputStream(ruta + "\\ciudades.bin");
                DataInputStream dis = new DataInputStream(fis);
                while (dis.available() > 0) {
                    nombre = dis.readUTF();
                    poblacion = dis.readInt();
                    viviendas = dis.readInt();
                    renta = dis.readInt();
                    extension = dis.readDouble();
                    dis.readDouble();
                    dis.readDouble();
                    densidadPoblacion =densidadPoblacion(poblacion, extension); ;
                    riqueza = riqueza(renta, poblacion);



                    PreparedStatement ps = connection.prepareStatement(instSQLInsertar);
                    ps.setString(1, nombre);
                    ps.setInt(2, poblacion);
                    ps.setInt(3, viviendas);
                    ps.setInt(4, renta);
                    ps.setDouble(5, extension);
                    ps.setDouble(6, densidadPoblacion);
                    ps.setDouble(7, riqueza);
                    ps.executeUpdate();


                }

                dis.close();
                fis.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                //throw new RuntimeException(e);
                //System.out.println("FIN DE FICHERO");
            }


        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
    public static void borrarDatos() {
    //METODO PARA BORRAR UNA CIUDAD
        Scanner scanner = new Scanner(System.in);
        //creamos la url con user y admin para conectarnos a la BD
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "admin";


        //SENTENCIAS SQL

        final String instSQLUsarBD = "use datosdeciudades";
        final String instSQLBorrar = "delete from ciudades where nombre=?;";




        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            Statement statement = connection.createStatement();


            //SELECCIONAMOS LA BD
            statement.executeUpdate(instSQLUsarBD);

            visualizarBBDD();

            System.out.println("Introduce el nombre de la ciudad que quieres borrar: ");
            String nombre = scanner.nextLine();
            PreparedStatement ps = connection.prepareStatement(instSQLBorrar);
            ps.setString(1, nombre);
            ps.executeUpdate();
            System.out.println("Se ha borrado la ciudad: " + nombre + " con exito");





        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public static void visualizarBBDD() {

        //METODO PARA VISUALIZAR LA TABLA CIUDADES
        Scanner scanner = new Scanner(System.in);
        //creamos la url con user y admin para conectarnos a la BD
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "admin";


        //SENTENCIAS SQL

        final String instSQLUsarBD = "use datosdeciudades";
        final String instSQLVisualizar = "select * from ciudades;";




        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            Statement statement = connection.createStatement();


            //SELECCIONAMOS LA BD
            statement.executeUpdate(instSQLUsarBD);

            ResultSet rs = statement.executeQuery(instSQLVisualizar);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7));
            }







        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

}

