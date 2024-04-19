package reto6_archivos_aleatorio;

import java.io.*;

public class Ejercicio1 {

    public static void main(String[] args) {
        try {
            sustituir("C:\\dir1\\textoAvanzado.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void sustituir(String fichero) throws IOException {
        int read;
        StringBuilder pantalla = new StringBuilder();
        StringBuilder leer=new StringBuilder();
        String introducido="juan";
        String cambiar="noel";
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("C:\\dir1\\textoAvanzado.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        DataInputStream dis = new DataInputStream(fis);
        while (dis.available()>0){
            /*try {

                //if (!(dis.available() >0)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/
            try {
                read=dis.read();
                char caracter = (char) read;
                System.out.print(caracter);
                leer.append(caracter);

                if (caracter == ' ' || caracter == '\r'|| caracter == '\n'){

                    if (leer.toString().equalsIgnoreCase(introducido+" ")||leer.toString().equalsIgnoreCase(introducido)){

                        pantalla.append(cambiar);
                        pantalla.append(" ");
                        leer.delete(0,leer.length());

                    }
                    if (leer.toString().equalsIgnoreCase(introducido+"\r")||leer.toString().equalsIgnoreCase(introducido+"\n")){


                        pantalla.append(cambiar);

                        leer.delete(0,leer.length());

                    }
                    else {
                        pantalla.append(leer);
                        leer.delete(0,leer.length());
                    }
                }
                else {
                    //pantalla.append(leer);

                }
            } catch (IOException e) {
                //throw new RuntimeException(e);
                System.out.println("FIN DE FICHERO TEXTO" );
            }

        }
        try {

            dis.close();
            fis.close();

            System.out.println("\n"+pantalla.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

}
