package Apuntes_Fichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrecuenciaDeNumeros {

    public static void main(String[] args) {
        String nombreArchivoEntrada = "numeros.txt";
        String nombreArchivoSalida = "estadistica.txt";

        // Arreglo para contar las frecuencias de cada número
        int[] frecuencias = new int[10];

        // Variables para calcular la media
        int suma = 0;
        int cantidadNumeros = 0;

        // Leer el contenido del archivo y contar las frecuencias de los números
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivoEntrada))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] numerosStr = linea.split("\\s+");
                for (String numStr : numerosStr) {
                    int num = Integer.parseInt(numStr);
                    suma += num;
                    cantidadNumeros++;
                    frecuencias[num]++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        // Calcular la moda (el número con mayor frecuencia)
        int moda = -1;
        int maxFrecuencia = 0;
        for (int i = 0; i < frecuencias.length; i++) {
            if (frecuencias[i] > maxFrecuencia) {
                moda = i;
                maxFrecuencia = frecuencias[i];
            }
        }

        // Calcular la media
        double media = (double) suma / cantidadNumeros;

        // Escribir la información en el archivo de estadísticas
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoSalida))) {
            for (int i = 0; i < frecuencias.length; i++) {
                bw.write("Número " + i + " - " + frecuencias[i] + " veces");
                bw.newLine();
            }
            bw.write("Moda: " + moda);
            bw.newLine();
            bw.write("Media: " + media);
            System.out.println("Se ha generado el archivo de estadísticas correctamente. El resultado se encuentra en el archivo '" + nombreArchivoSalida + "'.");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}