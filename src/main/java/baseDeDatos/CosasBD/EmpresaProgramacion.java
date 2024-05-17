package baseDeDatos.CosasBD;

import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class EmpresaProgramacion {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/empresa_programacion";
    private static final String USER = "root";
    private static final String PASS = "admin";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            // Procesar el fichero binario
            procesarFichero(conn, "datos.dat");
            // Generar el informe
            generarInforme(conn);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void procesarFichero(Connection conn, String nombreFichero) throws IOException, SQLException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(nombreFichero))) {
            while (dis.available() > 0) {
                char operacion = dis.readChar();
                switch (operacion) {
                    case 'A': // Alta
                        altaEmpleado(conn, dis);
                        break;
                    case 'B': // Baja
                        bajaEmpleado(conn, dis);
                        break;
                    case 'M': // Modificación
                        modificarEmpleado(conn, dis);
                        break;
                }
            }
        }
    }

    private static void altaEmpleado(Connection conn, DataInputStream dis) throws IOException, SQLException {
        int empNo = dis.readInt();
        String apellido = dis.readUTF();
        String oficio = dis.readUTF();
        int dir = dis.readInt();
        String fechaAlt = dis.readUTF();
        float salario = dis.readFloat();
        float comision = dis.readFloat();
        int deptNo = dis.readInt();

        String sql = "INSERT INTO empleados VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, empNo);
            pstmt.setString(2, apellido);
            pstmt.setString(3, oficio);
            pstmt.setInt(4, dir);
            pstmt.setDate(5, Date.valueOf(fechaAlt));
            pstmt.setFloat(6, salario);
            pstmt.setFloat(7, comision);
            pstmt.setInt(8, deptNo);
            pstmt.executeUpdate();
        }
    }

    private static void bajaEmpleado(Connection conn, DataInputStream dis) throws IOException, SQLException {
        int empNo = dis.readInt();

        String sql = "DELETE FROM empleados WHERE emp_no = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, empNo);
            pstmt.executeUpdate();
        }
    }

    private static void modificarEmpleado(Connection conn, DataInputStream dis) throws IOException, SQLException {
        int empNo = dis.readInt();
        float porcentaje = dis.readFloat();

        String sql = "UPDATE empleados SET salario = salario * ? WHERE emp_no = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setFloat(1, 1 + porcentaje / 100);
            pstmt.setInt(2, empNo);
            pstmt.executeUpdate();
        }
    }

    private static void generarInforme(Connection conn) throws SQLException {
        String sql = "SELECT e.emp_no, e.apellido, e.salario, d.dnombre " +
                "FROM empleados e " +
                "JOIN departamentos d ON e.dept_no = d.dept_no " +
                "ORDER BY e.emp_no";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.printf("%-10s %-15s %-10s %-15s%n", "Nº Empleado", "Nombre Empleado", "Salario", "Nombre Departamento");
            while (rs.next()) {
                int empNo = rs.getInt("emp_no");
                String apellido = rs.getString("apellido");
                float salario = rs.getFloat("salario");
                String dnombre = rs.getString("dnombre");
                System.out.printf("%-10d %-15s %-10.2f %-15s%n", empNo, apellido, salario, dnombre);
            }
        }
    }
}