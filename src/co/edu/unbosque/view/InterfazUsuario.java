package co.edu.unbosque.view;

import javax.swing.*;
import java.util.Scanner;


import co.edu.unbosque.controller.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazUsuario {

    private JFrame frame;
    private Controlador controlador;
    private Scanner scanner;

    public InterfazUsuario(Controlador controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
        initialize();
       
    }
    public String leerEntrada() {
        return scanner.nextLine();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnGestionarSedes = new JButton("Gestionar Sedes");
        btnGestionarSedes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.gestionarMenuSedes();
            }
        });
        btnGestionarSedes.setBounds(147, 38, 150, 23);
        frame.getContentPane().add(btnGestionarSedes);

        JButton btnGestionarApostadores = new JButton("Gestionar Apostadores");
        btnGestionarApostadores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.gestionarMenuApostadores();
            }
        });
        btnGestionarApostadores.setBounds(147, 72, 200, 23);
        frame.getContentPane().add(btnGestionarApostadores);

        // Otros botones y componentes visuales

        JLabel lblMenuPrincipal = new JLabel("===== Menú Principal =====");
        lblMenuPrincipal.setBounds(147, 11, 150, 14);
        frame.getContentPane().add(lblMenuPrincipal);
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void mostrarMensaje(String mensaje) {
        // Implementa la lógica para mostrar el mensaje en la interfaz de usuario
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
    public void mostrarMenuApostadores() {
        // Puedes utilizar JOptionPane u otro componente según tus necesidades
        // Ejemplo:
        JOptionPane.showMessageDialog(null, "Mostrando menú de apostadores...");
    }
    public void mostrarMenuPrincipal() {
        // Implementa la lógica para mostrar el menú principal
    }
}
