package serializacion;

import java.io.*;

public class PersonaMain {
    public static void main(String[] args) {
        Persona p1 ;


        try {
            FileOutputStream fos = new FileOutputStream("C:\\dir1\\datos.obj");
            ObjectOutputStream oos =new ObjectOutputStream(fos);

            p1=new Persona("Alejadra",22);
            oos.writeObject(p1);
            p1=new Persona("Pablo",33);
            oos.writeObject(p1);
            oos.close();
            fos.close();

            File f2 = new File("C:\\dir1\\auxiliar.obj");

            fos = new FileOutputStream("C:\\dir1\\auxiliar.obj");
            oos =new ObjectOutputStream(fos);

            p1=new Persona("Juan Jose",22);
            oos.writeObject(p1);
            p1=new Persona("Carol",20);
            oos.writeObject(p1);


            File f1 = new File("C:\\dir1\\datos.obj");

            FileInputStream fis = new FileInputStream(f1);
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
            while (true){


                    p1= (Persona) ois.readObject();
                    //System.out.println("Nombre: "+p1.nombre+" Edad : "+p1.edad);
                    oos.writeObject(p1);
                }

            }catch (EOFException e){} catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            oos.close();
            fos.close();
            ois.close();
            fis.close();



            f1.delete();
            f2.renameTo(f1);

            fis = new FileInputStream(f1);
            ois = new ObjectInputStream(fis);

            try {
                while (true){


                    p1= (Persona) ois.readObject();
                    System.out.println("Nombre: "+p1.nombre+" Edad : "+p1.edad);

                }

            }catch (EOFException | ClassNotFoundException e){}

            ois.close();
            fis.close();

        } catch (IOException e ) {
            throw new RuntimeException(e);
        }



    }
}
