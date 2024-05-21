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
import java.util.Scanner;

public class EJ4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String url = "jdbc:mysql://localhost:3306";
        final String usuario = "root";
        final String contrasenia = "admin";
        final String instSqlUseDB = "use personal";
        final String instSqlCreateTable = "create table oficinasEmpleados (id int auto_increment primary key, nombreEmpleado varchar(30), nombreDepartamento varchar(30), salario int, comision double)";
        final String insSqlJoinDosTablas = "select empleado.nombre as 'empleado',departamento.nombre as 'departamento',empleado.salario from empleado join departamento on empleado.dept_no= departamento.dept_no";
        final String insertarDatosOficinasEmpleado = "insert into oficinasEmpleados (nombreEmpleado, nombreDepartamento, salario, comision) values (?,?,?,?)";
        final String selectComisiones="select id,comision from oficinasEmpleados";
        final String selectFinal="select * from oficinasEmpleados";
        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contrasenia);
            Statement st = conexion.createStatement();
            st.execute(instSqlUseDB);

            System.out.println("Quieres crear la tabla oficinasEmpleados?");
            char respuesta = sc.nextLine().toLowerCase().charAt(0);

            if (respuesta == 's') {
                st.execute(instSqlCreateTable);
                System.out.println("La tabla ha sido creada");
            } else {
                System.out.println("no se creo la tabla oficinasEmpleados");
            }

            System.out.println("Quieres ingresar datos en la tabla OFICINASEMPLEADOS?");
            respuesta = sc.nextLine().toLowerCase().charAt(0);
            if (respuesta == 's') {
                ResultSet rs = st.executeQuery(insSqlJoinDosTablas);
                while (rs.next()) {
                    String nombreEmpleado = rs.getString("empleado");
                    String nombreDepartamento = rs.getString("departamento");
                    int sueldo = rs.getInt("salario");
                    double comision = calcularComision(sueldo, nombreDepartamento);

                    PreparedStatement ps = conexion.prepareStatement(insertarDatosOficinasEmpleado);
                    ps.setString(1, nombreEmpleado);
                    ps.setString(2, nombreDepartamento);
                    ps.setInt(3, sueldo);
                    ps.setDouble(4, comision);
                    ps.execute();
                }
            } else {
                System.out.println("no se insertaron datos en la tabla oficinasEmpleados");
            }

            System.out.println("QUieres actualizar las comisiones de los empleados??");
            respuesta=sc.nextLine().toLowerCase().charAt(0);
            if (respuesta=='s'){

                st.execute(selectComisiones);
                ResultSet rs=st.executeQuery(selectComisiones);

                while (rs.next()){
                    int id = rs.getInt("id");
                    double comision=rs.getDouble("comision");
                    double comisionActualizada=incrementarComision(comision);
                    PreparedStatement ps=conexion.prepareStatement("update  oficinasEmpleados set comision=? where id = ?");
                    ps.setDouble(1,comisionActualizada);
                    ps.setInt(2,id);
                    ps.execute();
                }



            }
            else {
                System.out.println("no se actualizaron las comisiones");
            }
            st.execute(selectFinal);
            ResultSet rs=st.executeQuery(selectFinal);

            while (rs.next()){
                int id = rs.getInt("id");
                String nombreEmp =rs.getString("nombreEmpleado");
                String nombreDep =rs.getString("nombreDepartamento");
                int salario=rs.getInt("salario");
                double comision=rs.getDouble("comision");

                System.out.println("ID : "+id+", Nombre de Empleado: "+nombreEmp+", Nombre Departamento : "+nombreDep+", Salario : "+salario+", Comision : "+comision);


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static double calcularComision(int sueldo, String departamento) {
        /*Si pertenece a 'Contabilidad', será el 10% del salario.
                Si pertenece a 'Investigación', será el 20% del salario.
                Si pertenece a 'Ventas', será el 5% del salario.
                Si pertenece a 'Producción', será el 15% del salario.*/
        if (departamento.equalsIgnoreCase("contabilidad")) {
            double porcentaje = sueldo * 10 / 100;
            return porcentaje;
        } else if (departamento.equalsIgnoreCase("investigacion")) {
            double porcentaje = sueldo * 20 / 100;
            return porcentaje;

        } else if (departamento.equalsIgnoreCase("ventas")) {
            double porcentaje = sueldo * 5 / 100;
            return porcentaje;

        } else if (departamento.equalsIgnoreCase("produccion")) {
            double porcentaje = sueldo * 15 / 100;
            return porcentaje;

        } else {
            return 0;
        }

    }
    public static double incrementarComision(double comision){

      /*  Posteriormente, se actualizara la tabla según la comisión. Las condiciones son:

        Si la comisión es menor de 300, este se incrementará en un 10%
                Si está comprendida entre 400 y 600, se incrementará en un 5%
                Si es mayor de 600 se quedará igual.*/
        if (comision < 300){
            double nuevaComision=(comision*10/100)+comision;
            return nuevaComision;
        }else if(comision>=400 && comision<=600){
            double nuevaComision=(comision*5/100)+comision;
            return nuevaComision;
        }else{
            return comision;
        }



    }

}



