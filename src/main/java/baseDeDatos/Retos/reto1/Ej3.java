package baseDeDatos.Retos.reto1;

/*
Sea la base de datos llamada DatosCoches, compuesta de dos tablas Propietarios y Coches y la cual se generará ejecutando el script Coches.sql.

        Hacer un programa en java que cree la tabla SeguroCoche, cuya estructura es la siguiente:

        Dni, Edad, Matricula y Seguro.

        Los datos a insertar, se sacarán de las tablas anteriores, excepto el atributo Seguro que se calculará de acuerdo a las siguientes premisas:

        el 2% del precio del coche para aquellos propietarios que tengan menos de 40 años
        el 1% para el resto.
        Posteriormente, se actualizara la tabla según el valor del seguro. Las condiciones son:

        Si el seguro es menor de 100, éste se incrementará en un 5%
        Si está comprendido entre 100 y 400, se quedará igual.
        Si es mayor de 400 se dará de baja.
        Finalmente, se escribirá en pantalla la tabla actualizada
*/

import java.sql.*;

public class Ej3 {

    public static void main(String[] args) {
        final String instSQLSelect = "select * from personasPaises";
        String instSQLInsert = "INSERT into productos values (4,'pistola',500.99,true)";
        final String instSQLDelete = "delete from productos where codigo=4";
        final String instSQLUpdate = "update personaspaises set edad = edad + 1 where nombrepais ='costa rica'";
        final String instSQLTable = "Create table segurocoche (dni varchar(10),edad int, matricula varchar(10),seguro double)";
        try {
            //Class.forName("com.mysql.jbdc.driver");

            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/datoscoches", "root", "admin");
            Statement st = miConexion.createStatement();
            //st.executeUpdate(instSQLInsert);
            //st.executeUpdate(instSQLDelete);
            //st.execute(instSQLUpdate);
            // String insertarDatosSQL = "INSERT INTO segurocoche (dni,edad,matricula,seguro) " +
            //    "SELECT dni,matricula " +
            //   "FROM  propietarios JOIN coches  ON propietarios.dni = coches.dni";

           st.execute(instSQLTable);

            // st.execute(insertarDatosSQL);


            ResultSet rs = st.executeQuery(instSQLSelect);

            while (rs.next()) {


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static double calcularSeguro(int edad, double precioCoche) {
        if (edad < 40) {
            return precioCoche * 0.02; // 2% del precio del coche
        } else {
            return precioCoche * 0.01; // 1% del precio del coche
        }
    }

}
