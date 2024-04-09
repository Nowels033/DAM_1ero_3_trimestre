package buffered;

import java.io.*;
import java.util.Scanner;

public class BufferedPrintWriter {

    public static void main(String[] args) {
        String texto;
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fw = new FileWriter("C:\\dir1\\salida.txt",true);
            PrintWriter escribir = new  PrintWriter(fw);

            do {
                System.out.println("introducir texto");
                texto = sc.nextLine();
                if (!texto.isEmpty()){

                    escribir.println(texto);
                }

            }while (!texto.isBlank());
            escribir.close();

            FileReader fr = new FileReader("C:\\dir1\\salida.txt");
            BufferedReader leer = new BufferedReader(fr);
            System.out.println("SALIDA");
            do {

                texto = leer.readLine();
                if (texto != null) {
                    System.out.println(texto);
                }
            }while(texto != null);
            leer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
