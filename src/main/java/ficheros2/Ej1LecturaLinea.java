package ficheros2;

import java.io.IOException;

public class Ej1LecturaLinea {

    public static void main(String[] args) {
       int c ,contador=0;


       while (true){
           try {
               if (!((c = System.in.read()) != '\n')) break;
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
           contador++;
           System.out.print((char)c);
       }
        System.out.println("\nNumero de caracteres introducidos : "+contador);
    }


}
