package org.example.Componente;

import java.awt.*;

public class RenderizarComponente {
    public int[][] pixelArt;
    public Color[] colors;
    public int tamanhoPixel;
    public boolean espelhar;

    public RenderizarComponente(int[][] pixelArt, Color[] colors, int tamanhoPixel, boolean espelhar){
        this.pixelArt = pixelArt;
        this.colors = colors;
        this.tamanhoPixel = tamanhoPixel;
        this.espelhar = espelhar;
    }


}
