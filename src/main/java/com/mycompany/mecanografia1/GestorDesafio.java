package com.mycompany.mecanografia1;

import java.util.HashMap;
import java.util.Map;

public class GestorDesafio {
    private SelectorFrases selector;
    private String fraseActual;
    private int posicionActual;
    private Map<Character, Integer> erroresPorLetra;
    private int totalPulsaciones;

    public GestorDesafio() {
        selector = new SelectorFrases();
        erroresPorLetra = new HashMap<>();
        totalPulsaciones = 0;
    }

    public String iniciarNuevoDesafio() {
        fraseActual = selector.obtenerFraseAleatoria();
        posicionActual = 0;
        erroresPorLetra.clear();
        totalPulsaciones = 0;
        return fraseActual;
    }

    public boolean verificarCaracter(char caracter) {
        totalPulsaciones++;
        if (posicionActual < fraseActual.length() && caracter == fraseActual.charAt(posicionActual)) {
            posicionActual++;
            return true;
        } else {
            erroresPorLetra.put(caracter, erroresPorLetra.getOrDefault(caracter, 0) + 1);
            return false;
        }
    }

    public boolean verificarFrase(String frase) {
        boolean esCorrecta = frase.equalsIgnoreCase(fraseActual);
        if (esCorrecta) {
            mostrarInforme();
        }
        return esCorrecta;
    }

    public void mostrarInforme() {
        System.out.println("Informe de Errores y Pulsaciones:");
        erroresPorLetra.forEach((letra, errores) -> System.out.println("Letra '" + letra + "': " + errores + " errores"));
        System.out.println("Total de pulsaciones: " + totalPulsaciones);
    }

    public String getFraseActual() {
        return fraseActual;
    }
}
