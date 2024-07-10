package org.example.Componente.Res;

import java.awt.Color;
import java.util.Random;

public class GalinhaTexturaComponente {

    public int[][] pixelArt = {
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 3, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 3, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 4, 9, 9, 9, 4, 1, 0},
            {0, 1, 1, 0, 0, 0, 0, 1, 9, 9, 7, 9, 4, 1, 0},
            {1, 9, 9, 1, 1, 0, 0, 1, 9, 9, 7, 4, 5, 5, 1},
            {1, 9, 4, 9, 9, 1, 1, 4, 9, 9, 9, 9, 1, 1, 0},
            {0, 1, 6, 4, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 1},
            {1, 4, 9, 1, 1, 4, 9, 9, 4, 9, 9, 9, 9, 9, 1},
            {1, 6, 4, 1, 9, 9, 9, 9, 1, 9, 4, 9, 4, 9, 1},
            {0, 1, 4, 1, 1, 1, 1, 1, 4, 4, 9, 4, 9, 4, 1},
            {0, 0, 1, 6, 6, 6, 4, 4, 4, 4, 4, 4, 6, 1, 0},
            {0, 0, 0, 1, 1, 6, 1, 4, 4, 4, 6, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 8, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 8, 5, 1, 1, 5, 1, 0, 0, 0}
    };

    public int r = 0, g = 0, b = 0;

    public void setRGB(int r, int g, int b) {
        this.r = clamp(r, 0, 255);
        this.g = clamp(g, 0, 255);
        this.b = clamp(b, 0, 255);
        updateColors();
    }
    public int getR(){
        return r;
    }
    public int getG(){
        return g;
    }
    public int getB(){
        return b    ;
    }

    private int clamp(int value, int min, int max) {
        return Math.min(Math.max(value, min), max);
    }

    public Color[] colors = new Color[10];

    //tabela de cores
    public void updateColors() {
        colors[0] = Color.BLACK; // 0 //fundo
        colors[1] = new Color(returnMax(92+r), returnMax(64 + g), returnMax(24 + b)); // 1
        colors[2] = new Color(returnMax(187+r) , returnMax(5 + g), returnMax(4 + b)); // 2
        colors[3] = new Color(returnMax(207+r) , returnMax(53 + g), returnMax(25 + b)); // 3
        colors[4] = new Color(returnMax(217 + r) , returnMax(170 + g), returnMax(116 + b)); // 4
        colors[5] = new Color(returnMax(234 + r) , returnMax(209 + g), returnMax(20 + b)); // 5
        colors[6] = new Color(returnMax(153 + r) , returnMax(99 + g), returnMax(37 + b)); // 6
        colors[7] = new Color( 0, 0, 0); // 7
        colors[8] = new Color(returnMax(138 + r) , returnMax(88 + g), returnMax(29 + b)); // 8
        colors[9] = new Color(returnMax(246 + r) , returnMax(222 + g), returnMax(194 + b)); // 9
    }
    public int returnMax(int n){
       return n;
       //return random.nextInt(255);
        /*if(n >+ 255){
            return 255;
        }
        return n;*/
    }
    public GalinhaTexturaComponente() {
        updateColors(); // Atualiza as cores quando o objeto é criado
    }

}
