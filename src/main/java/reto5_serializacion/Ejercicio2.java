package reto5_serializacion;


import java.util.ArrayList;
import java.util.List;

/*2. Gestión de un fichero binario

        MENU
 ------------------------------------------
1-Crear un fichero con datos (5 Clientes) Clientes.bin
-Codigo
-Nombre
-Direccion
2-Añadir cliente nuevo
3-Modificar un cliente (según el número de cliente, crear otro archivo auxiliar para hacer la modificación
y luego copiarlo en el original)
4-Borrar un cliente
5-Consultar los datos de un cliente
0-Salir

 Métodos
 -----------------
crearFichero
añadirCliente
consultarCliente
modificarCliente
borrarCliente*/
public class Ejercicio2 {
    public static void main(String[] args) {
        Cliente cl1 = new Cliente(01,"HULIO","C/PACO PORRAS");
        Cliente cl2 = new Cliente(02,"PACO","C/PIPO PORRAS");
        Cliente cl3 = new Cliente(03,"SEBASTIAN","C/ESPAÑA");
        Cliente cl4 = new Cliente(04,"BRAYA","C/EGIPTO");
        Cliente cl5 = new Cliente(05,"PABLO","C/RIVAS FUTURA");
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cl1);
        clientes.add(cl2);
        clientes.add(cl3);
        clientes.add(cl4);
        clientes.add(cl5);

    }
}
