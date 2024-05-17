package baseDeDatos.CosasBD;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CrearDatosBinarios {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("C\\dir1\\datos.dat"))) {
            // Ejemplo de alta de empleado
            dos.writeChar('A'); // Operación Alta
            dos.writeInt(7935); // emp_no
            dos.writeUTF("PÉREZ"); // apellido
            dos.writeUTF("ANALISTA"); // oficio
            dos.writeInt(7566); // dir
            dos.writeUTF("2023-05-01"); // fecha_alt
            dos.writeFloat(3500.00f); // salario
            dos.writeFloat(500.00f); // comision
            dos.writeInt(20); // dept_no

            // Ejemplo de baja de empleado
            dos.writeChar('B'); // Operación Baja
            dos.writeInt(7900); // emp_no

            // Ejemplo de modificación de salario de empleado
            dos.writeChar('M'); // Operación Modificación
            dos.writeInt(7839); // emp_no
            dos.writeFloat(10.0f); // Porcentaje de aumento
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
