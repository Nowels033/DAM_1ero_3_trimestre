package Apuntes_Fichero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeerXLineas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario el número de líneas a mostrar
        System.out.println("Introduce el número de líneas a mostrar:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Nombre del archivo
        String nombreArchivo = "texto.txt";

        // Leer y mostrar las primeras n líneas del archivo
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null && contador < n) {
                System.out.println(linea);
                contador++;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}