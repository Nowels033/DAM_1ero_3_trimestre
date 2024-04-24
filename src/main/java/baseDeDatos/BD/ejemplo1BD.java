package baseDeDatos.BD;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ejemplo1BD {

    public static void main(String[] args) {

        try {
            //Class.forName("com.mysql.jbdc.driver");
            //Connection miConexion = DriverManager.getConnection("jbdc:mysql://localhost:3307/sakila","root","admin");
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "root", "admin");
            Statement st = miConexion.createStatement();

            ResultSet rs =st.executeQuery("select * from cuentas");

            while (rs.next()){



               /* System.out.println(rs.getInt("codigo"+
                        "\t"+rs.getString("nombre")
                        +"\t"+rs.getDouble("precio")
                +"\t"+ rs.getBoolean("importado")));*/

                System.out.println(rs.getInt("id")+"\t"+rs.getDouble("saldo"));


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
