package entornos_de_desarrollo.ej1;

import java.time.LocalDate;

public class Reserva {

    private int numero_reserva;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Habitacion habitacion;
    private int numero_personas;

    public Reserva(int numero_reserva, LocalDate fechaEntrada, LocalDate fechaSalida, Habitacion habitacion, int numero_personas) {
        this.numero_reserva = numero_reserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.habitacion = habitacion;
        this.numero_personas = numero_personas;
    }
    public Reserva() {

    }

    public int getNumero_reserva() {
        return numero_reserva;
    }

    public void setNumero_reserva(int numero_reserva) {
        this.numero_reserva = numero_reserva;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public int getNumero_personas() {
        return numero_personas;
    }

    public void setNumero_personas(int numero_personas) {
        this.numero_personas = numero_personas;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "numero_reserva=" + getNumero_reserva() +
                ", fechaEntrada=" + getFechaEntrada() +
                ", fechaSalida=" + getFechaSalida() +
                ", habitacion=" + getHabitacion() +
                ", numero_personas=" + getNumero_personas() +
                '}';
    }
}
