package baseDeDatos.BD;

import java.sql.*;

public class VerBDs {

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
            st.executeUpdate("create table if not exists tablanueva (id int auto_increment primary key,nombre varchar(64))");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
