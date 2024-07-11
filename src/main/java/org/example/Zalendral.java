package org.example;

import org.example.Sistema.FpsSistema;

import javax.swing.*;
import java.awt.*;

public class Zalendral extends Canvas implements Runnable{
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GerenciadoCena gerenciadoCena = new GerenciadoCena();

                CenaRenderizador cenaRenderizador = new CenaRenderizador();

                gerenciadoCena.add(cenaRenderizador);

                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                gerenciadoCena.getContentPane().setBackground(Color.BLACK);
                gerenciadoCena.setSize(dimension);
                gerenciadoCena.setUndecorated(true);
                gerenciadoCena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gerenciadoCena.setLocationRelativeTo(null);
                gerenciadoCena.setVisible(true);
                gerenciadoCena.setResizable(false);

                cenaRenderizador.start();
            }
        });
        }

    @Override
    public void run() {
        new FpsSistema(true, 60);
    }
}
