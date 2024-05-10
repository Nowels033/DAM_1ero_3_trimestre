package entornos_de_desarrollo.ej1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private List<Reserva> reservas = new ArrayList<>();

    public Cliente(String nombre, String apellido, String correo, String contraseña) {
        super(nombre, apellido, correo, contraseña);

    }


    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void aniadirReserva(Reserva reserva) {

        reservas.add(reserva);

    }

    public void verReservas() {


        if (!this.reservas.isEmpty()) {
            for (int i = 0; i < this.reservas.size(); i++) {

                System.out.println("Reserva " + (i + 1) + reservas.get(i).toString());

            }
        } else {
            System.out.println("no tienes reservas realizadas");
        }

    }

    public void verReservasAdmin() {



        if (!this.reservas.isEmpty()) {
            for (int i = 0; i < this.reservas.size(); i++) {

                System.out.println("Reserva  : " + reservas.get(i).toString());

            }
        }

    }
    public void verReservasAdminDelDia() {


        if (!this.reservas.isEmpty()) {
            for (int i = 0; i < this.reservas.size(); i++) {
                if (this.reservas.get(i).getFechaEntrada().equals(LocalDate.now())) {
                    {
                        System.out.println("Reserva  : " + reservas.get(i).toString());

                    }

                }
            }

        }
    }

    public void borrarReserva(Reserva reserva) {
        this.reservas.remove(reserva);
    }

    public void cancelarReserva(Reserva reserva) {
        this.reservas.remove(reserva);
    }

    public void realizarReserva() {

        Reserva reserva = new Reserva();

        this.aniadirReserva(reserva);

    }

    @Override
    public String toString() {
        return "Cliente{" +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", correo='" + getCorreo() + '\'' + '}';
    }
}
