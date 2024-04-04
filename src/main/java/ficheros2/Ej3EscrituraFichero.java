package ficheros2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ej3EscrituraFichero {

    public static void main(String[] args) {

        escribir();


    }

    public static void escribir() {

        String cadena = " \n hoal que ase pepemel";

        FileWriter escribiendo = null;
        try {
            escribiendo = new FileWriter("C:\\dir1\\f1.txt",true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < cadena.length(); i++) {

            try {
                escribiendo.write(cadena.charAt(i));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        try {
            escribiendo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
