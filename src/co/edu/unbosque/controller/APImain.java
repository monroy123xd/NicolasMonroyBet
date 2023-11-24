package co.edu.unbosque.controller;



import co.edu.unbosque.view.InterfazUsuario;

public class APImain {
    public static void main(String[] args) {
        Controlador controlador = new Controlador(null, null);
        controlador.iniciar();
        InterfazUsuario interfazUsuario = new InterfazUsuario(controlador);
       
       

    }
}

