package org.example.Cenas;

import java.awt.*;

public class CenaLogin extends Canvas {

    public CenaLogin(){
        setSize(600, 400);
        setBackground(Color.RED);
    }

    @Override
    public void paint(Graphics g) {

        //Fazer o processo de Autenticação na tela...
        System.out.println("Tela Login");
        g.setColor(Color.blue);
        g.drawString("LOGIN! ", 400,400);
    }
}
