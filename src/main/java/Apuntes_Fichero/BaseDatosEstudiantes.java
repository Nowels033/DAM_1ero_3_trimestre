package Apuntes_Fichero;

import java.util.Scanner;


/*Claro, aquí tienes un ejercicio de ejemplo para un examen de primero de Desarrollo de Aplicaciones Multiplataforma (DAM). Este ejercicio cubre el uso de archivos en Java, incluyendo flujos de entrada y salida, acceso aleatorio y manejo de excepciones.

        Ejercicio:

Escribir un programa en Java que gestione una base de datos de estudiantes de una clase.
Cada estudiante tendrá un número de identificación, nombre, apellidos y nota.
El programa debe proporcionar las siguientes funcionalidades:a) Añadir estudiante:
Permitir al usuario introducir los datos de un nuevo estudiante y añadirlos a la base de datos.
b) Mostrar estudiantes: Mostrar todos los estudiantes almacenados en la base de datos.c) Buscar estudiante: Permitir al usuario buscar un estudiante por su número de identificación y mostrar su información.d) Actualizar nota: Permitir al usuario actualizar la nota de un estudiante por su número de identificación.e) Eliminar estudiante: Permitir al usuario eliminar un estudiante por su número de identificación.f) Guardar y cargar base de datos: Permitir al usuario guardar la base de datos en un archivo y cargarla desde un archivo.
Utiliza archivos de acceso aleatorio para almacenar los datos de los estudiantes.
Cada registro de estudiante en el archivo debe tener el siguiente formato:

Número de identificación: entero (4 bytes)
Nombre: cadena (20 caracteres, UTF-16)
Apellidos: cadena (30 caracteres, UTF-16)
Nota: double (8 bytes)
Asegúrate de manejar todas las posibles excepciones que puedan ocurrir durante la ejecución del programa.*/

public class BaseDatosEstudiantes {
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
                    // Añadir estudiante
                    break;
                case 2:
                    // Mostrar estudiantes
                    break;
                case 3:
                    // Buscar estudiante
                    break;
                case 4:
                    // Actualizar nota de estudiante
                    break;
                case 5:
                    // Eliminar estudiante
                    break;
                case 6:
                    // Guardar base de datos
                    break;
                case 7:
                    // Cargar base de datos
                    break;
                case 8:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    // Métodos adicionales
}
/*
nstrucciones:

Completa los métodos en la clase BaseDatosEstudiantes para implementar todas las funcionalidades requeridas.
Utiliza un archivo de acceso aleatorio para almacenar los datos de los estudiantes.
Implementa la lógica para manejar las excepciones que puedan ocurrir durante la ejecución del programa.
Asegúrate de que el programa sea fácil de usar para el usuario, proporcionando mensajes claros y opciones intuitivas en el menú.
Testea el programa con diferentes casos de uso para asegurarte de que funciona correctamente y maneja correctamente todas las situaciones.*/
