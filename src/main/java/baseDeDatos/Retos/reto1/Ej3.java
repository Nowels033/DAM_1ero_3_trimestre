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


        final String instSQLTable = "Create table segurocoche (id int auto_increment primary key,dni varchar(10),edad int, matricula varchar(10),seguro double)";
        try {


            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/datoscoches", "root", "admin");
            Statement st = miConexion.createStatement();



            st.executeUpdate(instSQLTable);


            String instSQLSelect = "select propietarios.dni,edad,matricula,precio from propietarios join coches on propietarios.dni = coches.dni;";
            Statement st2 = miConexion.createStatement();
            ResultSet rs = st.executeQuery(instSQLSelect);

            while (rs.next()) {

                String dni_propietario = rs.getString("dni");
                int edad = rs.getInt("edad");
                String matricula = rs.getString("matricula");
                int precio = rs.getInt("precio");
                double seguro = calcularSeguro(edad, precio);

                String insertTablaSeguroCoche = "insert into segurocoche (dni,edad,matricula,seguro) values ('" + dni_propietario + "'," + edad + ",'" + matricula + "'," + seguro + ");";

                st2.executeUpdate(insertTablaSeguroCoche);

            }

            String instSQLSelect2 = "select  * from segurocoche";

            rs = st.executeQuery(instSQLSelect2);
            double porcetaje;
            while (rs.next()) {
                int id = rs.getInt("id");
                String dni_propietario = rs.getString("dni");
                int edad = rs.getInt("edad");
                String matricula = rs.getString("matricula");
                double seguro = rs.getDouble("seguro");
                if (seguro < 100) {
                    porcetaje = seguro * 5 / 100;
                    seguro = porcetaje + seguro;

                    String updateTablaSeguroCoche = "update segurocoche set seguro=" + seguro + "where matricula ='" + matricula + "'";

                    st2.executeUpdate(updateTablaSeguroCoche);
                }
                if (seguro > 400) {


                    String deleteTablaSeguroCoche = "delete from segurocoche where matricula ='" + matricula + "'";

                    st2.executeUpdate(deleteTablaSeguroCoche);
                }

            }

            rs = st.executeQuery(instSQLSelect2);

            while (rs.next()) {
                int id = rs.getInt("id");
                String dni_propietario = rs.getString("dni");
                int edad = rs.getInt("edad");
                String matricula = rs.getString("matricula");
                double seguro = rs.getDouble("seguro");
                System.out.println("DNI : " + dni_propietario + " EDAD : " + edad + " MATRICULA : " + matricula + " SEGURO : " + seguro);

            }


         /*   rs.close();
            miConexion.close();*/

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

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
