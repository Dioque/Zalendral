package org.example;

import javax.swing.*;

import org.example.Sistema.FpsSistema;

import java.awt.*;

public class Zalendral{
	
//    static FpsSistema runFPS;

	public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GerenciadoCena gerenciadoCena = new GerenciadoCena();

                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                gerenciadoCena.getContentPane().setBackground(Color.BLACK);
                gerenciadoCena.setSize(dimension);
                //gerenciadoCena.setUndecorated(true);
                gerenciadoCena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gerenciadoCena.setLocationRelativeTo(null);
                gerenciadoCena.setVisible(true);
                gerenciadoCena.setResizable(false);

                FpsSistema fpsSistema = new FpsSistema(true, 60);
                fpsSistema.mostrarFPS();

            }
        });
        }
}
