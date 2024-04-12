package examen_Recuperacion2Ev;

import java.time.LocalDate;

public class Fondo {

    private String titulo;
    private String ISBN;
    private LocalDate fechaPublicacion;

    public Fondo(String titulo, String ISBN, LocalDate fechaPublicacion) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        return "Fondo{" +
                "titulo='" + getTitulo() + '\'' +
                ", ISBN='" + getISBN() + '\'' +
                ", fechaPublicacion=" + getFechaPublicacion() +
                '}';
    }
}
