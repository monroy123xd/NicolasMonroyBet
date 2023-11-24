package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

public class CasaDeApuestas {
    private static final String JUEGOS_FILE = "juegos.dat";
    private List<Juego> juegos;
    private List<Apostador> listaApostadores = new ArrayList<>();


    public CasaDeApuestas() {
        this.juegos = new ArrayList<>();
    }

    public void agregarJuego(Juego juego) {
        this.juegos.add(juego);
    }

    public List<Juego> obtenerJuegos() {
        return this.juegos;
    }
    public void agregarApostador(Apostador apostador) {
        listaApostadores.add(apostador);
    } public void borrarApostador(Apostador apostador) {
        if (listaApostadores != null) {
            listaApostadores.remove(apostador);
        }
    }

    public double obtenerPresupuestoTotalJuegos() {
        double presupuestoTotal = 0;
        for (Juego juego : juegos) {
            presupuestoTotal += juego.getPresupuesto();
        }
        return presupuestoTotal;
    }
    public Apostador buscarApostadorPorCedula(String cedula) {
        // Lógica para buscar un apostador por su cédula en la lista de apostadores
        for (Apostador apostador : this.listaApostadores) {
            if (apostador.getCedula().equals(cedula)) {
                return apostador;
            }
        }
        return null;  // No se encontró ningún apostador con la cédula dada
    }

    public boolean validarPresupuestoTotal() {
        double presupuestoTotalJuegos = obtenerPresupuestoTotalJuegos();
        double presupuestoTotalCasa = Configuracion.obtenerPresupuestoTotal();
        return presupuestoTotalJuegos == presupuestoTotalCasa;
    }
}
