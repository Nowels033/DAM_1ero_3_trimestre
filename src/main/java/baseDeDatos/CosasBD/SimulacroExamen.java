package baseDeDatos.CosasBD;

import java.sql.*;
import java.util.Scanner;

public class SimulacroExamen {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/Escuela";
        String user = "root";
        String password = "admin";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión exitosa a la base de datos");


            String sql = "CREATE TABLE Estudiantes (" +
                    "ID INT PRIMARY KEY AUTO_INCREMENT, " +
                    "Nombre VARCHAR(50), " +
                    "Apellido VARCHAR(50), " +
                    "FechaNacimiento DATE)";
            Statement statement = connection.createStatement();

            System.out.println("Quiere crear la tabla Estudiantes? (s/n)");

            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                statement.executeUpdate(sql);
                System.out.println("La tabla Estudiantes ha sido creada exitosamente");
            }
            else {
                System.out.println("No se ha creado la tabla Estudiantes");
            }



            menuSQL();


            // Cerramos la conexión
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public static void menuSQL() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear estudiante");
            System.out.println("2. Leer estudiantes");
            System.out.println("3. Actualizar estudiante");
            System.out.println("4. Eliminar estudiante");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); // reiniciar scanner

            switch (opcion) {
                case 1:
                    crearEstudiante(scanner);
                    break;
                case 2:
                    leerEstudiantes();
                    break;
                case 3:
                    actualizarEstudiante();
                    break;
                case 4:
                    eliminarEstudiante(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    private static void crearEstudiante(Scanner scanner) {
        String url = "jdbc:mysql://localhost:3306/Escuela";
        String user = "root";
        String password = "admin";

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
        String fechaNacimiento = scanner.nextLine();

        String sql = "INSERT INTO Estudiantes (Nombre, Apellido, FechaNacimiento) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setDate(3, Date.valueOf(fechaNacimiento));
            preparedStatement.executeUpdate();
            System.out.println("Estudiante creado exitosamente");

        } catch (SQLException e) {
            System.out.println("Error al crear el estudiante: " + e.getMessage());
        }
    }

    private static void leerEstudiantes() {
        String url = "jdbc:mysql://localhost:3306/Escuela";
        String user = "root";
        String password = "admin";

        String sql = "SELECT * FROM Estudiantes";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nombre = resultSet.getString("Nombre");
                String apellido = resultSet.getString("Apellido");
                Date fechaNacimiento = resultSet.getDate("FechaNacimiento");
                System.out.println("ID: "+id+", Nombre: "+nombre+", Apellido: "+apellido+", Fecha de Nacimiento: "+fechaNacimiento);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer los estudiantes: " + e.getMessage());
        }
    }

    private static void actualizarEstudiante() {
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/Escuela";
        String user = "root";
        String password = "admin";

        System.out.print("ID del estudiante a actualizar: ");

        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();

        String sql = "UPDATE Estudiantes SET Nombre = ? WHERE ID = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Estudiante actualizado exitosamente");
            } else {
                System.out.println("No se encontró el estudiante con ID " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el estudiante: " + e.getMessage());
        }
    }

    private static void eliminarEstudiante(Scanner scanner) {

        String url = "jdbc:mysql://localhost:3306/Escuela";
        String user = "root";
        String password = "admin";

        System.out.print("ID del estudiante a eliminar: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM Estudiantes WHERE ID = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Estudiante eliminado exitosamente");
            } else {
                System.out.println("No se encontró el estudiante con ID " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el estudiante: " + e.getMessage());
        }
    }
    private static void mostrarEstudiantesPorApellido() {
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/Escuela";
        String user = "root";
        String password = "admin";

        String sql = "SELECT * FROM Estudiantes WHERE Apellido = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            System.out.print("Ingrese el apellido del estudiante para buscarlo en la BD: ");

            String apellido = scanner.nextLine();


            preparedStatement.setString(1, apellido);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nombre = resultSet.getString("Nombre");
                String ape = resultSet.getString("Apellido");
                Date fechaNacimiento = resultSet.getDate("FechaNacimiento");
                System.out.println("ID: "+id+", Nombre: "+nombre+", Apellido: "+apellido+", Fecha de Nacimiento: "+fechaNacimiento);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los estudiantes: " + e.getMessage());
        }
    }

    private static void contarEstudiantesNacidosDespuesDe2000() {
        String url = "jdbc:mysql://localhost:3306/Escuela";
        String user = "root";
        String password = "admin";

        String sql = "SELECT COUNT(*) AS total FROM Estudiantes WHERE FechaNacimiento > '2000-01-01'";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                int total = resultSet.getInt("total");
                System.out.println("Número de estudiantes nacidos después del año 2000: " + total);
            }
        } catch (SQLException e) {
            System.out.println("Error al contar los estudiantes: " + e.getMessage());
        }
    }

    private static void mostrarEstudiantesOrdenadosPorFechaNacimiento() {
        String URL = "jdbc:mysql://localhost:3306/Escuela";
        String USER = "root";
        String PASSWORD = "admin";

        String sql = "SELECT Nombre, Apellido FROM Estudiantes ORDER BY FechaNacimiento ASC";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String nombre = resultSet.getString("Nombre");
                String apellido = resultSet.getString("Apellido");
                Date fechaNacimiento = resultSet.getDate("FechaNacimiento");
                System.out.println("Nombre: "+nombre+", Apellido: "+apellido+", Fecha de Nacimiento: "+fechaNacimiento);

            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los estudiantes: " + e.getMessage());
        }
    }

}
