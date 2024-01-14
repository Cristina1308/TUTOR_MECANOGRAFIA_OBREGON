package com.mycompany.mecanografia1;

import javax.swing.SwingUtilities;

public class AplicacionRecuerdoFrases {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazDesafio().setVisible(true);
            }
        });
    }
}
