package serializacion;

class Administrador extends Empleado{
    private double incentivo;
    public Administrador(String n, double s, int anho, int mes, int dia) {
        super(n,s,anho,mes,dia);
        incentivo=0;
    }
    public double getSueldo() {
        double sueldoBase = super.getSueldo();
        return sueldoBase + incentivo;
    }
    public void setIncentivo(double b) {
        incentivo=b;
    }
    @Override
    public String toString() {
        return super.toString() + ". Incentivo: " + incentivo;
    }
}