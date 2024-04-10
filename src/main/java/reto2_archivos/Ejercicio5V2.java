package reto2_archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio5V2 {

    public static void main(String[] args) {
        leer("C:\\dir1\\leer.txt");
    }

    public static void leer(String ruta) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una palabra:");
        String palabraBuscada = sc.nextLine().toLowerCase(); // Convertir la palabra introducida a minúsculas
        sc.close();

        ArrayList<String> palabrasEnArchivo = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while (true) {
                try {
                    if (!((linea = br.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String[] palabras = linea.split("\\s+"); // Dividir la línea en palabras
                for (String palabra : palabras) {
                    palabrasEnArchivo.add(palabra.toLowerCase()); // Convertir la palabra a minúsculas y agregarla al ArrayList
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());

        }

        int contador = 0;
        for (String palabra : palabrasEnArchivo) {
            if (palabra.equals(palabraBuscada)) {
                contador++;
            }
        }

        System.out.println("La palabra '" + palabraBuscada + "' aparece " + contador + " veces en el archivo.");
    }
}
