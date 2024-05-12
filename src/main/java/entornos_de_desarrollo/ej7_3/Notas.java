package entornos_de_desarrollo.ej7_3;

public class Notas {
    private Asignatura asignatura;
    private double  nota;

    public Notas(Asignatura asignatura, double nota) {
        this.asignatura = asignatura;
        this.nota = nota;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "asignatura=" + asignatura +
                ", nota=" + nota +
                '}';
    }
}
