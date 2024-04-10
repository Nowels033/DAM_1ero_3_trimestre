package binario;

import java.io.*;
import java.util.Scanner;

public class BinarioIOV2 {


    public static void main(String[] args) {

        String nM;
        String nota;
        Scanner sc = new Scanner(System.in);
        try {
            FileOutputStream fos = new FileOutputStream( "C:\\dir1\\notas.dat",true);
            DataOutputStream dos = new DataOutputStream(fos);
            System.out.println("ingrese sttring");
            nM=sc.nextLine();
            while (!nM.equalsIgnoreCase("0")){
                dos.writeUTF(nM);
                System.out.println("ingrese sttring");
                nota = sc.nextLine();
                dos.writeUTF(nota);
                System.out.println("ingrese sttring(0 para acabar)");
                nM=sc.nextLine();
            }
            dos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("C:\\dir1\\notas.dat");
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() >0){
                nM = dis.readUTF();
                nota = dis.readUTF();
                System.out.println(nM+"\t"+nota);
            }
            dis.close();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
