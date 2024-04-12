package examen_Recuperacion2Ev;

import java.time.LocalDate;

public class Video extends FondoPrestable{

    private String director;
    private int duracion;

    public Video(String titulo, String ISBN, LocalDate fechaPublicacion,String director,int duracion) {
        super(titulo, ISBN, fechaPublicacion);
        this.director=director;
        this.duracion=duracion;

    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Video{" +
                "director='" + getDirector() + '\'' +
                ", duracion=" + getDuracion() +
                "} " + super.toString();
    }
}
