package ficheros1;

import java.io.File;
import java.util.Scanner;

public class Ej3Listar {

    public static void main(String[] args) {

        String rutaDirectorio = "C:/dir1/";

        Scanner sc = new Scanner(System.in);

        File directorio = new File(rutaDirectorio);

        String extension;

        //System.out.println("Introduce la extension");
        //extension=sc.nextLine();
        /*
        File [] archivosTxt = directorio.listFiles(

                new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.toLowerCase().endsWith(extension);
                    }
                }
        );*/

        File [] archivosTxt = directorio.listFiles(((dir, name) -> name.toLowerCase().endsWith("txt")));

        for (File archivo : archivosTxt) {

            System.out.println(archivo.getAbsoluteFile());

        }

    }
}
