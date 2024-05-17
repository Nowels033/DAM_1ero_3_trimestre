package baseDeDatos.CosasBD;

import java.sql.*;

public class Prueba {
    public static void main(String[] args) {
        final String url ="jdbc:mysql://localhost:3306/prueba";
        final String usuario="root";
        final String contrasenia = "admin";
        try {
            Connection conexion = DriverManager.getConnection(url,usuario,contrasenia);
            PreparedStatement sentencia = conexion.prepareStatement("select * from productos where nombre =? and importado = ?");
            sentencia.setString(1,"taladradora");
            sentencia.setBoolean(2,false);
            if (sentencia.execute()){
                System.out.println("Se ha ejecutado la sentencia");
            }
            else {
                System.out.println("No se ha ejecutado la sentencia");
            }
            sentencia = conexion.prepareStatement("select * from productos where nombre =? and importado = ?");
            sentencia.setString(1,"taladradora");
            sentencia.setBoolean(2,false);






            ResultSet rs = sentencia.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("codigo")+"\t"+rs.getString("nombre")+"\t"+rs.getDouble("precio")+"\t"+rs.getBoolean("importado"));

            }


            rs.close();
            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
