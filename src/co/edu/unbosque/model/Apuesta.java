package co.edu.unbosque.model;

//Apuesta.java

public class Apuesta {
    private Apostador apostador;
    private EventoDeportivo eventoDeportivo;
    private double monto;

    // Constructor
    public Apuesta(Apostador apostador, EventoDeportivo eventoDeportivo, double monto) {
        this.apostador = apostador;
        this.eventoDeportivo = eventoDeportivo;
        this.monto = monto;
    }

    // Getter y setter para apostador
    public Apostador getApostador() {
        return apostador;
    }

    public void setApostador(Apostador apostador) {
        this.apostador = apostador;
    }

    // Getter y setter para eventoDeportivo
    public EventoDeportivo getEventoDeportivo() {
        return eventoDeportivo;
    }

    public void setEventoDeportivo(EventoDeportivo eventoDeportivo) {
        this.eventoDeportivo = eventoDeportivo;
    }

    // Getter y setter para monto
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
