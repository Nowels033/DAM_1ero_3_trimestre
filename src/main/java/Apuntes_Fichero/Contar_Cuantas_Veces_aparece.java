package Apuntes_Fichero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Contar_Cuantas_Veces_aparece {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario la palabra a buscar
        System.out.println("Introduce la palabra a buscar:");
        String palabraBuscar = scanner.nextLine();

        // Nombre del archivo
        String nombreArchivo = "parrafo.txt";

        // Contador de ocurrencias de la palabra
        int contadorOcurrencias = 0;

        // Leer el contenido del archivo y contar las ocurrencias de la palabra
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contadorOcurrencias += contarPalabraEnLinea(linea, palabraBuscar);
            }

            // Mostrar el resultado
            System.out.println("La palabra '" + palabraBuscar + "' aparece " + contadorOcurrencias + " veces en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Método para contar la ocurrencia de una palabra en una línea
    private static int contarPalabraEnLinea(String linea, String palabra) {
        int contador = 0;
        String[] palabras = linea.split("\\s+");
        for (String p : palabras) {
            if (p.equalsIgnoreCase(palabra)) {
                contador++;
            }
        }
        return contador;
    }
}
