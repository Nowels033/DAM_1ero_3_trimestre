package Apuntes_Fichero;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ManejoFicherosRamdom {

    // Método para escribir referencias de artículo seguidas de sus precios en un archivo
    public static void escribirReferenciasYPrecios(int[] referencias, double[] precios, String nombreArchivo) {
        if (referencias.length != precios.length) {
            System.err.println("Los arrays de referencias y precios deben tener la misma longitud.");
            return;
        }

        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw")) {
            for (int i = 0; i < referencias.length; i++) {
                raf.writeInt(referencias[i]);
                raf.writeDouble(precios[i]);
            }
            System.out.println("Se ha escrito la información en el archivo correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Método para leer y mostrar el contenido de un archivo de referencias y precios
    public static void mostrarContenido(String nombreArchivo) {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "r")) {
            while (raf.getFilePointer() < raf.length()) {
                int referencia = raf.readInt();
                double precio = raf.readDouble();
                System.out.println("Referencia: " + referencia + ", Precio: " + precio);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Método para actualizar los precios de un archivo de referencias y precios
    public static void actualizarPrecios(String nombreArchivo) {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw")) {
            while (raf.getFilePointer() < raf.length()) {
                int referencia = raf.readInt();
                double precio = raf.readDouble();
                if (precio > 100) {
                    precio *= 0.5; // Decrementar en un 50%
                } else {
                    precio *= 1.5; // Incrementar en un 50%
                }
                // Volver al inicio del registro para actualizar el precio
                raf.seek(raf.getFilePointer() - 8);
                raf.writeDouble(precio);
            }
            System.out.println("Se han actualizado los precios correctamente.");
        } catch (IOException e) {
            System.err.println("Error al actualizar los precios: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int[] referencias = {1, 2, 3};
        double[] precios = {50.0, 120.0, 80.0};
        String nombreArchivo = "articulos.dat";

        // Escribir las referencias y precios en el archivo
        escribirReferenciasYPrecios(referencias, precios, nombreArchivo);

        // Mostrar el contenido del archivo
        System.out.println("Contenido del archivo:");
        mostrarContenido(nombreArchivo);

        // Actualizar los precios del archivo
        actualizarPrecios(nombreArchivo);

        // Mostrar el contenido actualizado del archivo
        System.out.println("Contenido actualizado del archivo:");
        mostrarContenido(nombreArchivo);
    }
}
