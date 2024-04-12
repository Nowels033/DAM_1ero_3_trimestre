package examen_Recuperacion2Ev;

import java.time.LocalDate;

public class FondoPrestable extends Fondo{

    private boolean disponible;
    private LocalDate fechaDisponibilidad;


    public FondoPrestable(String titulo, String ISBN, LocalDate fechaPublicacion) {
        super(titulo, ISBN, fechaPublicacion);

        disponible= true;
        fechaDisponibilidad=null;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public LocalDate getFechaDisponibilidad() {
        return fechaDisponibilidad;
    }

    public void setFechaDisponibilidad(LocalDate fechaDisponibilidad) {
        this.fechaDisponibilidad = fechaDisponibilidad;
    }

    public boolean prestar (){
        if (this.isDisponible()){

            this.setDisponible(false);
            setFechaDisponibilidad(LocalDate.now().plusDays(15));
            System.out.println("Se presto :"+this.getTitulo());
            return true;
        }
        System.out.println(this.getTitulo()+" esta no disponible");
            return false;
    }

    public boolean devolver(){

        if (!this.isDisponible()){

            this.setDisponible(true);
            setFechaDisponibilidad(null);
            System.out.println("Se devolvio :"+this.getTitulo());
            return true;
        }
        System.out.println(this.getTitulo()+" esta disponible no se puede devolver");
        return false;
    }

    @Override
    public String toString() {
        return "FondoPrestable{" +
                "disponible=" + isDisponible() +
                ", fechaDisponibilidad=" + getFechaDisponibilidad() +
                "} " + super.toString();
    }
}
