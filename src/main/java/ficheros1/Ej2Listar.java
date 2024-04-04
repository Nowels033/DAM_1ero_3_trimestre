package ficheros1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class Ej2Listar implements FilenameFilter {

    String extension ;

    Ej2Listar(String extension){
        this.extension=extension;
    }

    public static void main(String[] args) {

        String rutaDirectorio = "C:/dir1/";

        Scanner sc = new Scanner(System.in);
        System.out.println("introducir extension");
        String extension=sc.nextLine();

        File directorio = new File(rutaDirectorio);
        Ej2Listar filtro = new Ej2Listar(extension);

        File [] archivosTxt = directorio.listFiles(filtro);

        for (File archivo : archivosTxt) {

            System.out.println(archivo.getAbsoluteFile());

        }
    }



    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(extension);
    }
}
