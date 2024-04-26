package Apuntes_Fichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AñadirAsterisco {

    public static void main(String[] args) {
        String nombreArchivoEntrada = "texto.txt";
        String nombreArchivoSalida = "texto_modificado.txt";

        // Modificar el contenido del archivo original e insertar asteriscos delante de cada vocal
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoSalida))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String lineaModificada = insertarAsteriscos(linea);
                bw.write(lineaModificada);
                bw.newLine();
            }
            System.out.println("Se ha modificado el archivo correctamente. El resultado se encuentra en el archivo '" + nombreArchivoSalida + "'.");
        } catch (IOException e) {
            System.err.println("Error al leer/escribir el archivo: " + e.getMessage());
        }
    }

    // Método para insertar asteriscos delante de cada vocal en una línea
    private static String insertarAsteriscos(String linea) {
        StringBuilder lineaModificada = new StringBuilder();
        for (int i = 0; i < linea.length(); i++) {
            char c = linea.charAt(i);
            if (esVocal(c)) {
                lineaModificada.append("*");
            }
            lineaModificada.append(c);
        }
        return lineaModificada.toString();
    }

    // Método para verificar si un carácter es una vocal
    private static boolean esVocal(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}
