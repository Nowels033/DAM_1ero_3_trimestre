package entornos_de_desarrollo.ej1;

import java.util.List;

public class Cliente extends Usuario{

    private List<Reserva> reservas;

    public Cliente(String nombre, String apellido, String correo, String contraseña) {
        super(nombre, apellido, correo, contraseña);
    }


    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    public void añadirReserva(Reserva reserva){

        reservas.add(reserva);

    }

    public void verReservas(){

        if (!this.reservas.isEmpty()) {
            for (int i = 0; i < this.reservas.size(); i++) {

                System.out.println("Reserva " + (i + 1) + reservas.get(i).toString());

            }
        }
        else {
            System.out.println("no tienes reservas realizadas");
        }

    }
    @Override
    public String toString() {
        return "Cliente{" +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", correo='" + getCorreo() + '\'' + '}';
    }
}
