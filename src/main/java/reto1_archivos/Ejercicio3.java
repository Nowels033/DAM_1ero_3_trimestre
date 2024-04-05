package reto1_archivos;



//Ejercicio 3
//
//        Escribir un programa Java que le pida al usuario el nombre de un directorio y de un fichero.
//
//        Compruebe si el fichero existe dentro del directorio. Si no existe devuelve un mensaje de error y sale.
//
//        Listar los subdirectorios del directorio
//
//        Listar los ficheros del directorio
//
//        Calcular el tamaño total de los ficheros de un directorio
//
//        Listar los ficheros de un directorio que empiecen por una letra en particular (utilizar el método charAt())

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un directorio :");
        String directorio = sc.nextLine();
        System.out.println("introduce el nombre de un elemento");
        String elemento = sc.nextLine();
        File dir1 = new File(directorio, elemento);
        File dir2 = new File(directorio);
        File [] directorios = dir2.listFiles();

        if (dir1.exists()){


//            for (int i = 0; i < directorios.length; i++) {
//
//                if (directorios[i].isDirectory() && (directorios[i] != null)){
//
//
//                    System.out.println(directorios[i].getAbsoluteFile());
//
//                    for (int j = 0; (j < directorios.length) && (directorios[i] != null) && directorios[j].isDirectory(); j++) {
//
//                        System.out.println(directorios[j].getAbsoluteFile());
//                    }
//                }
//            }
            System.out.println("directorios dentro de :"+directorio);
            //listarDirectorio(directorios);




            System.out.println("introduce un caracter para sacar los ficheros de los directorio que empiezen por ese caracter");
            char filtro = sc.nextLine().toLowerCase().charAt(0);
            listarDirectorioFiltro(dir2,filtro);

        }
        else{
            System.out.println(dir1.getName()+ "NO EXISTE");
        }

    }
    public static void listarDirectorio(File[] arrayFile ){
        int contadorFich =0;

        if (arrayFile != null && arrayFile.length > 0)  {

            for (int i = 0; i < arrayFile.length; i++) {

                if (arrayFile[i].isFile()){

                    System.out.println("Fichero : "+arrayFile[i].getAbsoluteFile());
                    contadorFich += arrayFile[i].length();


                }
                if (arrayFile[i].isDirectory() ){

                    System.out.println("Directorio : "+arrayFile[i].getAbsoluteFile());


                        listarDirectorio(arrayFile[i].listFiles());



                }

            }
            System.out.println("El tamaño de los ficheros del directorio : "+arrayFile[0].getParent()+ " \nEs de : "+contadorFich);

        }
        else {
            System.out.println(" El direcorio esta vacio o no contiene archivos");
        }
    }

    //        Listar los ficheros de un directorio que empiecen por una letra en particular (utilizar el método charAt())

    public static void listarDirectorioFiltro(File dir2 ,char filtro){
        Scanner sc = new Scanner(System.in);
        int contadorFich =0;
        String nombre = " ";

        File [] arrayFile = dir2.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.toLowerCase().charAt(0) == filtro ){
                    return true;
                }
                else{
                    return false;
                }
            }
        });
        if (arrayFile != null && arrayFile.length > 0)  {

            for (int i = 0; i < arrayFile.length; i++) {

                if (arrayFile[i].isFile()){

                    System.out.println("Fichero : "+arrayFile[i].getAbsoluteFile());
                    contadorFich += arrayFile[i].length();


                }
                if (arrayFile[i].isDirectory() ){

                    System.out.println("Directorio : "+arrayFile[i].getAbsoluteFile());

                    nombre = arrayFile[i].getName();

                    listarDirectorioFiltro(arrayFile[i],filtro);


                }

            }
            System.out.println("El tamaño de los ficheros del directorio : "+arrayFile[0].getParent()+"\\"+nombre+ " \nEs de : "+contadorFich);

        }
        else {
            System.out.println(" El direcorio esta vacio o no contiene archivos");
        }
    }

}
