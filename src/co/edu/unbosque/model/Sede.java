package co.edu.unbosque.model;

public class Sede {
    // Atributos de la clase Sede
    private String nombre;
    private String direccion;
    private int capacidadMaxima;
    private int numeroEmpleados;
    
    public Sede(String nombre, String direccion, int capacidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidadMaxima = capacidad;


    // Constructor
    String ubicacion = obtenerUbicacion();{
    System.out.println("Ubicación: " + ubicacion);
}
    }

public String obtenerUbicacion() {
    // Lógica para obtener la ubicación, por ejemplo, concatenar nombre y dirección
    return nombre + ", " + direccion;
}

    // Métodos de la clase Sede
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }
    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }
    public void realizarAlgunaOperacion() {
        System.out.println("Número de empleados: " + numeroEmpleados);
    }
    
    public static void main(String[] args) {
        // Crear una nueva sede
        Sede nuevaSede = new Sede("Sede Principal", "Calle Principal 123", 100);
    }

    @Override
    public String toString() {
        return "Sede [nombre=" + nombre + ", direccion=" + direccion + ", capacidadMaxima=" + capacidadMaxima + "]";
    }	
 
}
