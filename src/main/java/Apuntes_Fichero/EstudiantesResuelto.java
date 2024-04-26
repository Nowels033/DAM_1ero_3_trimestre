package Apuntes_Fichero;

import java.io.*;
import java.util.Scanner;

public class EstudiantesResuelto {
    private static final int TAMANO_REGISTRO = 66; // Tamaño total de un registro en bytes

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombreArchivo = "estudiantes.dat";

        // Menú principal
        while (true) {
            System.out.println("1. Añadir estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Buscar estudiante");
            System.out.println("4. Actualizar nota de estudiante");
            System.out.println("5. Eliminar estudiante");
            System.out.println("6. Guardar base de datos");
            System.out.println("7. Cargar base de datos");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    añadirEstudiante(scanner, nombreArchivo);
                    break;
                case 2:
                    mostrarEstudiantes(nombreArchivo);
                    break;
                case 3:
                    buscarEstudiante(scanner, nombreArchivo);
                    break;
                case 4:
                    actualizarNotaEstudiante(scanner, nombreArchivo);
                    break;
                case 5:
                    eliminarEstudiante(scanner, nombreArchivo);
                    break;
                case 6:
                    guardarBaseDatos(nombreArchivo);
                    break;
                case 7:
                    cargarBaseDatos(nombreArchivo);
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    // Método para añadir un estudiante a la base de datos
    public static void añadirEstudiante(Scanner scanner, String nombreArchivo) {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw")) {
            // Mover el puntero al final del archivo
            raf.seek(raf.length());

            // Solicitar los datos del estudiante al usuario
            System.out.print("Introduzca el número de identificación del estudiante: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            System.out.print("Introduzca el nombre del estudiante: ");
            String nombre = scanner.nextLine();
            System.out.print("Introduzca los apellidos del estudiante: ");
            String apellidos = scanner.nextLine();
            System.out.print("Introduzca la nota del estudiante: ");
            double nota = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea

            // Escribir los datos del estudiante en el archivo
            raf.writeInt(id);
            raf.writeUTF(padRight(nombre, 20));
            raf.writeUTF(padRight(apellidos, 30));
            raf.writeDouble(nota);

            System.out.println("Estudiante añadido correctamente.");
        } catch (IOException e) {
            System.err.println("Error al añadir estudiante: " + e.getMessage());
        }
    }

    // Método para mostrar todos los estudiantes en la base de datos
    public static void mostrarEstudiantes(String nombreArchivo) {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "r")) {
            System.out.println("Lista de estudiantes:");
            while (raf.getFilePointer() < raf.length()) {
                int id = raf.readInt();
                String nombre = raf.readUTF().trim();
                String apellidos = raf.readUTF().trim();
                double nota = raf.readDouble();
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Nota: " + nota);
            }
        } catch (IOException e) {
            System.err.println("Error al mostrar estudiantes: " + e.getMessage());
        }
    }

    // Método para buscar un estudiante por su número de identificación
    public static void buscarEstudiante(Scanner scanner, String nombreArchivo) {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "r")) {
            System.out.print("Introduzca el número de identificación del estudiante a buscar: ");
            int idBusqueda = scanner.nextInt();
            boolean encontrado = false;

            while (raf.getFilePointer() < raf.length()) {
                int id = raf.readInt();
                String nombre = raf.readUTF().trim();
                String apellidos = raf.readUTF().trim();
                double nota = raf.readDouble();

                if (id == idBusqueda) {
                    encontrado = true;
                    System.out.println("Estudiante encontrado:");
                    System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Nota: " + nota);
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Estudiante con ID " + idBusqueda + " no encontrado.");
            }
        } catch (IOException e) {
            System.err.println("Error al buscar estudiante: " + e.getMessage());
        }
    }

    // Método para actualizar la nota de un estudiante por su número de identificación
    public static void actualizarNotaEstudiante(Scanner scanner, String nombreArchivo) {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw")) {
            System.out.print("Introduzca el número de identificación del estudiante cuya nota desea actualizar: ");
            int idBusqueda = scanner.nextInt();
            boolean encontrado = false;

            while (raf.getFilePointer() < raf.length()) {
                long posicionInicio = raf.getFilePointer();
                int id = raf.readInt();
                String nombre = raf.readUTF().trim();
                String apellidos = raf.readUTF().trim();
                double nota = raf.readDouble();

                if (id == idBusqueda) {
                    encontrado = true;
                    System.out.println("Introduzca la nueva nota para el estudiante:");
                    double nuevaNota = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea

                    // Mover el puntero al inicio del registro para actualizar la nota
                    raf.seek(posicionInicio + 54); // Posición del campo "nota" en el registro (20 + 30 + 4)
                    raf.writeDouble(nuevaNota);

                    System.out.println("Nota actualizada correctamente.");
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Estudiante con ID " + idBusqueda + " no encontrado.");
            }
        } catch (IOException e) {
            System.err.println("Error al actualizar nota del estudiante: " + e.getMessage());
        }
    }

    // Método para eliminar un estudiante por su número de identificación
    public static void eliminarEstudiante(Scanner scanner, String nombreArchivo) {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw")) {
            System.out.print("Introduzca el número de identificación del estudiante que desea eliminar: ");
            int idBusqueda = scanner.nextInt();
            boolean encontrado = false;

            while (raf.getFilePointer() < raf.length()) {
                int id = raf.readInt();
                if (id == idBusqueda) {
                    encontrado = true;
                    // Mover el puntero al principio del registro a eliminar
                    long posicionInicio = raf.getFilePointer() - 4; // Retroceder 4 bytes para apuntar al inicio del ID
                    raf.seek(posicionInicio);

                    // Sobreescribir el registro con los datos del siguiente registro
                    byte[] buffer = new byte[TAMANO_REGISTRO];
                    while (raf.read(buffer) == TAMANO_REGISTRO) {
                        raf.seek(posicionInicio);
                        raf.write(buffer);
                        posicionInicio = raf.getFilePointer();
                    }
                    raf.setLength(raf.length() - TAMANO_REGISTRO); // Acortar el archivo eliminando el último registro
                    System.out.println("Estudiante eliminado correctamente.");
                    break;
                } else {
                    // Avanzar al siguiente registro
                    raf.readUTF();
                    raf.readUTF();
                    raf.readDouble();
                }
            }

            if (!encontrado) {
                System.out.println("Estudiante con ID " + idBusqueda + " no encontrado.");
            }
        } catch (IOException e) {
            System.err.println("Error al eliminar estudiante: " + e.getMessage());
        }
    }

    // Método para guardar la base de datos en un archivo
    public static void guardarBaseDatos(String nombreArchivo) {
        // No es necesario hacer nada, la base de datos ya está guardada en el archivo
        System.out.println("Base de datos guardada correctamente en el archivo '" + nombreArchivo + "'.");
    }

    // Método para cargar la base de datos desde un archivo
    public static void cargarBaseDatos(String nombreArchivo) {
        // No es necesario hacer nada, los datos se cargan automáticamente al acceder al archivo
        System.out.println("Base de datos cargada correctamente desde el archivo '" + nombreArchivo + "'.");
    }

    // Método auxiliar para rellenar una cadena con espacios hasta una longitud específica
    private static String padRight(String input, int length) {
        return String.format("%-" + length + "s", input);
    }
}
