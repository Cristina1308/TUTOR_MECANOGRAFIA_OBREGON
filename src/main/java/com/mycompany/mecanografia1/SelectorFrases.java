package com.mycompany.mecanografia1;

import java.util.Random;

public class SelectorFrases {
    private String[] frases;
    private Random random;

    public SelectorFrases() {
        random = new Random();
        cargarFrases();
    }

    private void cargarFrases() {
        frases = new String[]{
            "Frase 1:",
            "Frase 2:",
            // ... Agrega más frases aquí ...
        };
    }

    public String obtenerFraseAleatoria() {
        return frases[random.nextInt(frases.length)];
    }
}

