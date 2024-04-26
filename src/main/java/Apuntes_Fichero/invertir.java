package Apuntes_Fichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class invertir {

    public static void main(String[] args) {
        String nombreArchivoEntrada = "texto.txt";
        String nombreArchivoSalida = "invertido.txt";

        // Leer el contenido del archivo original y escribir las frases invertidas en el nuevo archivo
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoSalida))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String fraseInvertida = invertirFrase(linea);
                bw.write(fraseInvertida);
                bw.newLine();
            }
            System.out.println("Se ha invertido el texto correctamente. El resultado se encuentra en el archivo '" + nombreArchivoSalida + "'.");
        } catch (IOException e) {
            System.err.println("Error al leer/escribir el archivo: " + e.getMessage());
        }
    }

    // Método para invertir una frase
    private static String invertirFrase(String frase) {
        StringBuilder fraseInvertida = new StringBuilder();
        String[] palabras = frase.split("\\s+"); // Separar la frase en palabras usando espacios como delimitador
        for (int i = palabras.length - 1; i >= 0; i--) {
            fraseInvertida.append(palabras[i]).append(" ");
        }
        return fraseInvertida.toString().trim(); // Eliminar el espacio extra al final y devolver la frase invertida
    }
}
