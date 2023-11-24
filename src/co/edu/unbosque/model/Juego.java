package co.edu.unbosque.model;

public class Juego {
    private String nombre;
    private String tipo;
    private double presupuesto;

    public Juego(String nombre, String tipo, double presupuesto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String toString() {
        return "Nombre: " + nombre + ", Tipo: " + tipo + ", Presupuesto: " + presupuesto;
    }
}