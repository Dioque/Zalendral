package org.example;

import org.example.Sistema.FpsSistema;

import javax.swing.*;
import java.awt.*;

public class Zalendral extends Canvas implements Runnable{
    static FpsSistema runFPS;
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GerenciadoCena gerenciadoCena = new GerenciadoCena();

               // CenaRenderizador cenaRenderizador = new CenaRenderizador();

              //  gerenciadoCena.add(cenaRenderizador);

                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                gerenciadoCena.getContentPane().setBackground(Color.BLACK);
                gerenciadoCena.setSize(dimension);
                //gerenciadoCena.setUndecorated(true);
                gerenciadoCena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gerenciadoCena.setLocationRelativeTo(null);
                gerenciadoCena.setVisible(true);
                gerenciadoCena.setResizable(false);

                runFPS;
              //  cenaRenderizador.start();
            }
        });
        }


    @Override
    public void run() {
        System.out.println("Run Zalendral.java Stat");
        this.runFPS = new FpsSistema(true, 60);
    }
}
