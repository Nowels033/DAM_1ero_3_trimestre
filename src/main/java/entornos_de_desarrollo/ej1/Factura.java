package entornos_de_desarrollo.ej1;

import java.time.LocalDate;

public class Factura {
    private int numero_factura;
    private LocalDate fechaFactura;
    private Cliente cliente;
    private double importe;
    private double IVA;

    public Factura(int numero_factura, LocalDate fechaFactura, Cliente cliente, double importe, double IVA) {
        this.numero_factura = numero_factura;
        this.fechaFactura = fechaFactura;
        this.cliente = cliente;
        this.importe = importe;
        this.IVA = IVA;
    }
    public Factura() {

    }

    public int getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(int numero_factura) {
        this.numero_factura = numero_factura;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(LocalDate fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "numero_factura=" + getNumero_factura() +
                ", fechaFactura=" + getFechaFactura() +
                ", cliente=" + getCliente() +
                ", importe=" + getImporte() +
                ", IVA=" + getIVA() +
                '}';
    }
}
