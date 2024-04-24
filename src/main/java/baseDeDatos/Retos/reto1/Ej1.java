package baseDeDatos.Retos.reto1;


        /*Se tiene la base de datos América, compuesta por las tablas Personas y Países.

        Hacer un programa en Java que cree la tabla PersonasPaises que tendrá los siguientes atributos:

        Id, Nombre, Apellido, Edad, NombrePais y Tamaño.

        La información que va almacenar es la sacada de las otras dos tablas. Tras crear dicha tabla, actualizarla sumando 1 a la edad de las personas de Costa Rica.

        Finalmente sacar un listado con toda la información de la nueva tabla.*/

import java.sql.*;

public class Ej1 {

    public static void main(String[] args) {
        final String instSQLSelect="select * from productos";
        final String instSQLInsert="INSERT into productos values (4,'pistola',500.99,true)";
        final String instSQLDelete="delete from productos where codigo=4";
        final String instSQLUpdate="update productos set precio = precio * 2 where codigo=2";
        final String instSQLTable="Create table personasPaises (id int primary key,nombre varchar(30),apellido varchar(40),edad int, " +
                "nombrePais varchar(40),tamaño int)";
        try {
            //Class.forName("com.mysql.jbdc.driver");

            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/america", "root", "admin");
            Statement st = miConexion.createStatement();
            //st.executeUpdate(instSQLInsert);
            //st.executeUpdate(instSQLDelete);
            //st.execute(instSQLUpdate);



            ResultSet rs =st.executeQuery(instSQLSelect);

            while (rs.next()){






            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
