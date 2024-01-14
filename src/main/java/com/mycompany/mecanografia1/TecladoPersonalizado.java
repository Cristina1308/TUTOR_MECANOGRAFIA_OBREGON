package com.mycompany.mecanografia1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TecladoPersonalizado extends JPanel {
    private JButton[] botonesTeclado;
    private boolean mayusculasActivadas;
    private JTextField campoEntrada;
    private InterfazDesafio interfaz;

    public TecladoPersonalizado(JTextField campoEntrada, InterfazDesafio interfaz) {
        this.campoEntrada = campoEntrada;
        this.interfaz = interfaz;
        setLayout(new GridLayout(4, 10));
        inicializarTeclado();
    }

    private void inicializarTeclado() {
        String[] letras = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
                           "A", "S", "D", "F", "G", "H", "J", "K", "L", ";",
                           "Z", "X", "C", "V", "B", "N", "M", "Ñ", ",", ".", "/",
                           "Caps", "Space", "Enter", "Borrar"};

        botonesTeclado = new JButton[letras.length];

        for (int i = 0; i < letras.length; i++) {
            botonesTeclado[i] = new JButton(letras[i]);
            final int index = i;
            botonesTeclado[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String tecla = letras[index];
                    procesarTecla(tecla);
                }
            });
            add(botonesTeclado[i]);
        }
    }

    private void procesarTecla(String tecla) {
        switch (tecla) {
            case "Caps":
                mayusculasActivadas = !mayusculasActivadas;
                actualizarEstadoTeclado();
                break;
            case "Space":
                interfaz.procesarCaracter(" ");
                break;
            case "Enter":
                // Lógica para manejar la tecla Enter si es necesaria
                break;
            case "Borrar":
                interfaz.procesarCaracter("Borrar");
                break;
            default:
                interfaz.procesarCaracter(mayusculasActivadas ? tecla.toUpperCase() : tecla.toLowerCase());
                break;
        }
    }

    private void actualizarEstadoTeclado() {
        for (JButton boton : botonesTeclado) {
            String texto = boton.getText();
            if (!texto.equals("Caps") && !texto.equals("Space") && !texto.equals("Enter") && !texto.equals("Borrar")) {
                boton.setText(mayusculasActivadas ? texto.toUpperCase() : texto.toLowerCase());
            }
        }
    }
}
