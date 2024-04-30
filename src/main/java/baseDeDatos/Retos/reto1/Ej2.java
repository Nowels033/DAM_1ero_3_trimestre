package baseDeDatos.Retos.reto1;

/*Ejecutar el fichero empresa.sql, que creará la base de datos Empresa, compuesta
de las tablas Empleados y Departamentos.
        Hacer un programa que actualice la tabla Empleados, mediante el fichero binario datos.dat.

        El fichero, datos.dat, tiene la siguiente estructura:

        El primer campo es una cadena que contendrá una A, una B o una M (alta, baja o modificación) y dependiendo de la operación
        tendrá los siguientes campos.
        Si es una baja sólo aparecerá el código del empleado a dar de baja.
        Si es un alta, vendrán todos los datos que forman parte de la tabla Empleados que es donde se van a insertar los datos.
        Y si es una modificación, vendrá el código del empleado y el porcentaje que se subirá el salario.
        Finalmente, sacar un informe en el que aparezca:

        Nº Empleado Nombre Empleado Salario Nombre Departamento*/

import java.sql.*;

public class Ej2 {
    public static void main(String[] args) {
        final String instSQLSelect="select * from personasPaises";
        String instSQLInsert="INSERT into productos values (4,'pistola',500.99,true)";
        final String instSQLDelete="delete from productos where codigo=4";
        final String instSQLUpdate="update personaspaises set edad = edad + 1 where nombrepais ='costa rica'";
        final String instSQLTable="Create table personasPaises (id int primary key,nombre varchar(30),apellido varchar(40),edad int, nombrePais varchar(40),tamaño varchar(15))";
        try {
            //Class.forName("com.mysql.jbdc.driver");

            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa_programacion", "root", "admin");
            Statement st = miConexion.createStatement();
            //st.executeUpdate(instSQLInsert);
            //st.executeUpdate(instSQLDelete);
            //st.execute(instSQLUpdate);
           // String insertarDatosSQL = "INSERT INTO PersonasPaises (id,Nombre, Apellido, Edad, NombrePais, Tamaño) " +
                //    "SELECT p.id,p.Nombre, p.Apellido, p.Edad, pa.Nombre, pa.Tamaño " +
                 //   "FROM Persona p JOIN Pais pa ON p.Pais = pa.Id";

            // st.execute(instSQLTable);

           // st.execute(insertarDatosSQL);






            ResultSet rs =st.executeQuery(instSQLSelect);

            while (rs.next()){





            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
