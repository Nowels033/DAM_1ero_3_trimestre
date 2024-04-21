package entornos_de_desarrollo.ej2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Piscina piscinaUno = new Piscina(01,14.5,false,"ainhoa C/isabale II");
        CampoFutbol campoFutbolUno = new CampoFutbol(02,30,false,"Campo luis aragones");
        CanchaBaloncesto canchaUno = new CanchaBaloncesto(03,25.8,true,"La cancha del barrio");
        Gimnasio gymUno = new Gimnasio(04,10.5,true,"El gym de paco");
        PistaTenis pistaUno = new PistaTenis(05,50,false,"Pista las dos tetas");

        List<Instalacion> comunidad = new ArrayList<>();
        comunidad.add(piscinaUno);
        comunidad.add(campoFutbolUno);
        comunidad.add(gymUno);
        comunidad.add(pistaUno);

        for (int i = 0; i < comunidad.size(); i++) {

            System.out.println(comunidad.get(i).toString());

        }

    }
}
