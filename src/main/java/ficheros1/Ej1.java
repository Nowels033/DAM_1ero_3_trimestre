package ficheros1;

import java.io.File;
import java.io.IOException;

public class Ej1 {

    public static void main(String[] args) {

        File miDir = new File("C:\\dir1\\dir2\\dir3\\dir4");

        if (miDir.exists()) {
            System.out.println("Dir existe");
        } else {
            System.out.println("Dir no existe");

            if (miDir.mkdirs()) {

                System.out.println("Dir Creado");


            } else {
                System.out.println("No se pudo crear el Dir");
            }

        }

        File miFich = new File(miDir, "fich1");
        File miFich2 = new File(miDir, "fich2");

        try {
            if (miFich.createNewFile()) {
                System.out.println("se creo el fichero");
                if (miFich.renameTo(miFich2)) {
                    System.out.println("fichero renombrado");
                } else {
                    System.out.println("fichero no renombrado");
                }

            } else {
                System.out.println("no se creo el fichero");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (miFich2.delete()){
            System.out.println("se borro el fichero : "+miFich2.getName());
        }
        else {
            System.out.println("no se borro el fichero");
        }

        File [] ficheros = miDir.listFiles();

        for (File f: ficheros) {

            if (f.isFile()){
                System.out.println(f.getName()+": es un fichero");
            }
            if (f.isDirectory()){
                System.out.println(f.getName()+" : es un directorio");
            }
            System.out.println(f.getAbsolutePath());
        }


    }

}
