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
        StringBuilder builder = new StringBuilder();
        String str="";
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
                str+=caracter;

                if (caracter == ' ' || caracter == '\n'){

                    if (str.equalsIgnoreCase(introducido+' ')){

                        builder.append(cambiar);
                        builder.append(" ");
                        str="";

                    }
                    if (str.equalsIgnoreCase(introducido+"\n")){

                        builder.append(cambiar);

                        str="";

                    }
                    else {
                        builder.append(str);
                        str="";
                    }
                }
            } catch (IOException e) {
                //throw new RuntimeException(e);
                System.out.println("FIN DE FICHERO TEXTO" );
            }

        }
        try {

            dis.close();
            fis.close();

            System.out.println(builder.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

}
