package reto2_archivos;

/*
Ejercicio 6.-

        Hacer un programa que lea los valores del fichero de texto “numeros.txt” (0 al 9) y cree el fichero “estadistica.txt”,
        donde se guarde las frecuencias, la moda (el número que aparece con mayor frecuencia) y la media.

        Ejemplo:

        numeros.txt 4 5 2 1 6 2 1 1 3 5 5 9

        estadistica.txt Número 0 – 0 veces

        Número 1 – 3 veces

        …………………………..

        Número 9 – 1 vez

        Moda: 1 y 5 Media:3.66
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Character.isDigit;

public class Ejercicio6 {

    public static void main(String[] args) {


        //System.out.println(leer("C:\\dir1\\numeros.txt"));
        escribir(leer("C:\\dir1\\numeros.txt"));


    }

    public static String leer(String ruta) {
        String retorno = "";
        FileReader entrada = null;
        String añadir = "";
        ArrayList<Character> array = new ArrayList<>();
        try {
            entrada = new FileReader(ruta);
            try {
                int c;
                char j;
                do {
                    c = entrada.read();
                    j = (char) c;
                    if (c != -1) {
                        if (isDigit(j)) {
                            //System.out.println(j);
                            array.add(j);
                        }

                    }

                } while (c != -1);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                entrada.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        /*System.out.println("ARRAY");
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }*/
        int cero = 0, uno = 0, dos = 0, tres = 0, cuatro = 0, cinco = 0, seis = 0, siete = 0, ocho = 0, nueve = 0;
        double suma = 0.0;
        String string = "";
        int moda = 0;
        for (int i = 0; i < array.size(); i++) {


            if (array.get(i) == '0') {
                cero++;
            }
            if (array.get(i) == '1') {
                uno++;
            }
            if (array.get(i) == '2') {
                dos++;
            }
            if (array.get(i) == '3') {
                tres++;
            }
            if (array.get(i) == '4') {
                cuatro++;
            }
            if (array.get(i) == '5') {
                cinco++;
            }

            if (array.get(i) == '6') {
                seis++;
            }
            if (array.get(i) == '7') {
                siete++;
            }
            if (array.get(i) == '8') {
                ocho++;
            }
            if (array.get(i) == '9') {
                nueve++;
            }
            string = String.valueOf(array.get(i));
            suma += Double.parseDouble(string);
            /*System.out.println("ARRAY "+i+" "+(double)array.get(i));
            System.out.println(array.size());*/

        }
        ArrayList<Integer> array2 = new ArrayList<>();
        array2.add(cero);
        array2.add(uno);
        array2.add(dos);
        array2.add(tres);
        array2.add(cuatro);
        array2.add(cinco);
        array2.add(seis);
        array2.add(siete);
        array2.add(ocho);
        array2.add(nueve);
        for (int i = 0; i < array2.size() ; i++) {
            System.out.println(i+"-"+array2.get(i));
        }
        for (int i = 0; i < array2.size(); i++) {

            if (array2.get(i) >= array2.get(moda)) {
                moda = i;
            }

        }
        System.out.println("numero de moda es :");
        System.out.println(moda);
        return "El numero 0 aparece " + cero + " veces\n " +
                "El numero 1 aparece " + uno + " veces\n  " +
                "El numero 2 aparece " + dos + " veces\n  " +
                "El numero 3 aparece " + tres + " veces\n  " +
                "El numero 4 aparece " + cuatro + " veces\n  " +
                "El numero 5 aparece " + cinco + " veces\n  " +
                "El numero 6 aparece " + seis + " veces\n  " +
                "El numero 7 aparece " + siete + " veces\n  " +
                "El numero 8 aparece " + ocho + " veces\n  " +
                "El numero 9 aparece " + nueve + " veces\n  " +
                "El numero de moda es :" + moda + "\n" +
                "La media total de los numeros del archivo es :" + (suma / array.size());
    }

    public static void escribir(String cadena) {


        FileWriter escribiendo = null;
        try {
            escribiendo = new FileWriter("C:\\dir1\\estadistica.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            escribiendo.write(cadena);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            escribiendo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
