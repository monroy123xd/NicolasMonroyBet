package co.edu.unbosque.model;

public class Apostador {
    private String nombre;
    private String cedula;
    private String sede;
    private String direccion;
    private String celular;

    public Apostador(String nombre, String cedula, String sede, String direccion, String celular) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.sede = sede;
        this.direccion = direccion;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Apostador{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", sede='" + sede + '\'' +
                ", direccion='" + direccion + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }
}
