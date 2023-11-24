package co.edu.unbosque.model;

//EventoDeportivo.java

import java.util.Date;

public class EventoDeportivo {
 private String nombre;
 private Date fecha;
 private String ubicacion;

 // Constructor
 public EventoDeportivo(String nombre, Date fecha, String ubicacion) {
     this.nombre = nombre;
     this.fecha = fecha;
     this.ubicacion = ubicacion;
 }

 // Métodos getter y setter
 public String getNombre() {
     return nombre;
 }

 public void setNombre(String nombre) {
     this.nombre = nombre;
 }

 public Date getFecha() {
     return fecha;
 }

 public void setFecha(Date fecha) {
     this.fecha = fecha;
 }

 public String getUbicacion() {
     return ubicacion;
 }

 public void setUbicacion(String ubicacion) {
     this.ubicacion = ubicacion;
 }

 // Otros métodos según sea necesario
}

