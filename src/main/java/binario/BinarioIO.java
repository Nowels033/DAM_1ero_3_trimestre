package binario;

import java.io.*;
import java.util.Scanner;

public class BinarioIO {


    public static void main(String[] args) {

        int nM;
        double nota;
        Scanner sc = new Scanner(System.in);
        try {
            FileOutputStream fos = new FileOutputStream( "C:\\dir1\\notas.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            System.out.println("ingrese un codigo de asignatura(0 para acabar)");
            nM=sc.nextInt();
            while (nM != 0){
                dos.writeInt(nM);
                System.out.println("ingrese una nota");
                nota = sc.nextDouble();
                dos.writeDouble(nota);
                System.out.println("ingrese un codigo de asignatura(0 para acabar)");
                nM=sc.nextInt();
            }
            dos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("C:\\dir1\\notas.dat");
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() >0){
                nM = dis.readInt();
                nota = dis.readDouble();
                System.out.println(nM+"\t"+nota);
            }
            dis.close();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println("FIN DE FICHERO");
        }


    }


}
