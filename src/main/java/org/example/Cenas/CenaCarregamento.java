package org.example.Cenas;

import java.awt.*;

public class CenaCarregamento extends Canvas {

    public CenaCarregamento(){
        setSize(600, 400);
        setBackground(Color.BLUE);

    }

    @Override
    public void paint(Graphics g) {
        System.out.println("Tela Inicial");
        g.setColor(Color.RED);
        g.drawRoundRect(30,30,30,30,30,30);
    }
}
