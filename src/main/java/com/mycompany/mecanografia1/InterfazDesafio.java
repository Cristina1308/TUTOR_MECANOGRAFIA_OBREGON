package com.mycompany.mecanografia1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazDesafio extends JFrame {
    private JTextField campoEntrada;
    private JButton botonIniciar, botonVerificar;
    private JLabel etiquetaFrase, etiquetaEstado;
    private GestorDesafio gestor;
    private TecladoPersonalizado teclado;

    public InterfazDesafio() {
        gestor = new GestorDesafio();
        configurarComponentes();
    }

    private void configurarComponentes() {
        setTitle("Desafío de Recuerdo de Frases");
        setSize(500, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        campoEntrada = new JTextField(20);
        botonIniciar = new JButton("Iniciar Desafío");
        botonVerificar = new JButton("Verificar");
        etiquetaFrase = new JLabel("Presiona 'Iniciar Desafío' para comenzar");
        etiquetaEstado = new JLabel("");

        botonIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String frase = gestor.iniciarNuevoDesafio();
                etiquetaFrase.setText(frase);
                campoEntrada.setText("");
            }
        });

        botonVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String intento = campoEntrada.getText();
                boolean correcto = gestor.verificarFrase(intento);
                etiquetaEstado.setText(correcto ? "¡Correcto!" : "Incorrecto. Intenta de nuevo.");
            }
        });

        teclado = new TecladoPersonalizado(campoEntrada, this);

        add(botonIniciar);
        add(etiquetaFrase);
        add(campoEntrada);
        add(botonVerificar);
        add(etiquetaEstado);
        add(teclado);
    }

    public void procesarCaracter(String caracter) {
        if (caracter.equals("Borrar")) {
            // Lógica de borrado (opcional)
        } else if (caracter.length() == 1 && gestor.verificarCaracter(caracter.charAt(0))) {
            campoEntrada.setText(campoEntrada.getText() + caracter);
        }
    }
}

