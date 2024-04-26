package Apuntes_Fichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Encriptar {

    public static void main(String[] args) {
        String nombreArchivoEntrada = "texto.txt";
        String nombreArchivoSalida = "texto_encriptado.txt";

        // Leer el contenido del archivo y encriptarlo
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoSalida))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String lineaEncriptada = encriptarLinea(linea);
                bw.write(lineaEncriptada);
                bw.newLine();
            }
            System.out.println("Se ha encriptado el archivo correctamente. El resultado se encuentra en el archivo '" + nombreArchivoSalida + "'.");
        } catch (IOException e) {
            System.err.println("Error al leer/escribir el archivo: " + e.getMessage());
        }
    }

    // Método para encriptar una línea de texto
    private static String encriptarLinea(String linea) {
        StringBuilder lineaEncriptada = new StringBuilder();
        for (int i = 0; i < linea.length(); i++) {
            char c = linea.charAt(i);
            if (Character.isLetter(c)) {
                char nuevoCaracter = (char) (c + 3); // Avanzar tres posiciones en el alfabeto
                if (nuevoCaracter > 'z') {
                    nuevoCaracter -= 26; // Regresar al principio del alfabeto si se pasa de 'z'
                }
                if (nuevoCaracter > 'Z' && nuevoCaracter < 'a') {
                    nuevoCaracter -= 26; // Regresar al principio del alfabeto si se pasa de 'Z'
                }
                lineaEncriptada.append(nuevoCaracter);
            } else {
                lineaEncriptada.append(c); // Conservar caracteres no alfabéticos sin encriptar
            }
        }
        return lineaEncriptada.toString();
    }
}