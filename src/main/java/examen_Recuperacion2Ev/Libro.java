package examen_Recuperacion2Ev;

import java.time.LocalDate;

public class Libro extends FondoPrestable{

    private String autor;
    private int numPaginas;

    public Libro(String titulo, String ISBN, LocalDate fechaPublicacion,String autor,int numPaginas) {
        super(titulo, ISBN, fechaPublicacion);
        this.autor=autor;
        this.numPaginas=numPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autor='" + getAutor() + '\'' +
                ", numPaginas=" + getNumPaginas() +
                "} " + super.toString();
    }
}
