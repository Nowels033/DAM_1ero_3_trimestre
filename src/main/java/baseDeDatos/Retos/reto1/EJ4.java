package baseDeDatos.Retos.reto1;


/*Sea la base de datos llamada Personal, compuesta de dos tablas Empleado y Departamento las cuales se generarán ejecutando el script personal.sql

        Hacer un programa en java que cree la tabla OficinaEmpleados, cuya estructura es la siguiente:

        Nombre Empleado, Nombre Departamento, Salario y Comisión.

        Los datos a insertar, se sacarán de las tablas anteriores, excepto el atributo Comisión
        que se calculará de acuerdo al departamento al que pertenezca:

        Si pertenece a 'Contabilidad', será el 10% del salario.
        Si pertenece a 'Investigación', será el 20% del salario.
        Si pertenece a 'Ventas', será el 5% del salario.
        Si pertenece a 'Producción', será el 15% del salario.
        Posteriormente, se actualizara la tabla según la comisión. Las condiciones son:

        Si la comisión es menor de 300, este se incrementará en un 10%
        Si está comprendida entre 400 y 600, se incrementará en un 5%
        Si es mayor de 600 se quedará igual.
        Finalmente, se escribirá en pantalla la tabla actualizada*/

import java.sql.*;

public class EJ4 {

    public static void main(String[] args) {
        final String url ="jdbc:mysql://localhost:3306";
        final String usuario="root";
        final String contrasenia = "admin";
        final String instSqlverBDs= "show databases";
        try {
            Connection conexion = DriverManager.getConnection(url,usuario,contrasenia);
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(instSqlverBDs);
            int contador =1;
            while (rs.next()){

                System.out.println("BD "+contador+": "+ rs.getString(1));
                contador++;

            }

            //  String consulta ="create database "+"bdnueva";

            // st.execute(consulta);

            st.executeUpdate("use bdnueva");


            st.executeUpdate("create table if not exists tablonueva (id int auto_increment primary key,nombre varchar(64))");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}



