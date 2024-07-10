package org.example.Componente;

import java.awt.*;

public class PixelComponente extends Component {
    private RenderizarComponente[][] pixels;

    public PixelComponente(int width, int height) {
        pixels = new RenderizarComponente[width][height];
    }

    public void setPixel(int x, int y, RenderizarComponente pixel) {
        pixels[x][y] = pixel;
    }

    public RenderizarComponente getPixel(int x, int y) {
        return pixels[x][y];
    }

    public int getWidth() {
        return pixels.length;
    }

    public int getHeight() {
        return pixels[0].length;
    }
}
