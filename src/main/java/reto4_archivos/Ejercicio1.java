package reto4_archivos;

public class Ejercicio1 {

   /* 1. Escribir un método que reciba por parámetro un array de valores enteros correspondientes a referencias a artículos y un array de valores reales
    correspondientes a los precios de los artículos anteriores. Se podrá usar también ArrayList.
    El método recibirá también el nombre de un fichero sobre el que se escribirá cada referencia de artículo seguida de su precio.*/
    public static void main(String[] args) {
        int[] refencias = {0, 1, 2, 3, 4, 5, 6};
        double[] precios = {5.66, 4.55, 15.90, 100.5, 900, 50.99, 1.20};

        String fichero = "C:\\dir1\\ejercicioAleatorio.data";

        ej1(refencias, precios, fichero);


    }

    public static void ej1(int[] referencia,double[] precios,String fichero){




    }


}
