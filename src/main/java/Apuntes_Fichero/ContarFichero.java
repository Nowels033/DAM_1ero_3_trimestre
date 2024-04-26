package Apuntes_Fichero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ContarFichero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario el nombre del archivo
        System.out.println("Introduce el nombre del archivo:");
        String nombreArchivo = scanner.nextLine();

        // Contadores para líneas, caracteres y palabras
        int numLineas = 0;
        int numCaracteres = 0;
        int numPalabras = 0;

        // Verificar si el archivo existe
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                numLineas++;
                numCaracteres += linea.length();
                numPalabras += contarPalabras(linea);
            }
            // Agregar 1 al número de palabras para la última línea si no está vacía
            if (linea != null && !linea.isEmpty()) {
                numPalabras++;
            }

            // Mostrar los resultados
            System.out.println("Número de líneas: " + numLineas);
            System.out.println("Número de caracteres: " + numCaracteres);
            System.out.println("Número de palabras: " + numPalabras);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Método para contar palabras en una línea
    private static int contarPalabras(String linea) {
        String[] palabras = linea.split("\\s+");
        return palabras.length;
    }
}