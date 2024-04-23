package baseDeDatos.BD;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ejemplo1BD {

    public static void main(String[] args) {

        try {
            //Class.forName("com.mysql.jbdc.driver");
            Connection miConexion = DriverManager.getConnection("jbdc:mysql://localhost:3307/sakila","root","admin");
            Statement st = miConexion.createStatement();

            ResultSet rs =st.executeQuery("select * from actor");

            while (rs.next()){



               /* System.out.println(rs.getInt("codigo"+
                        "\t"+rs.getString("nombre")
                        +"\t"+rs.getDouble("precio")
                +"\t"+ rs.getBoolean("importado")));*/

                System.out.println(rs.getInt("actor_id"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
