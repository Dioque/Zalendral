package org.example.Cenas;

import org.example.Componente.GerenciadoComponente;
import org.example.Componente.RenderizarComponente;
import org.example.Componente.Res.GalinhaTexturaComponente;
import org.example.Sistema.RenderizacaoSistema;

import java.awt.*;
import java.awt.image.ImageObserver;

public class CenaRendereziador extends Canvas {

    public CenaRendereziador(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dimension);
        setBackground(Color.DARK_GRAY);

    }
    GalinhaTexturaComponente galinhaTexturaComponente = new GalinhaTexturaComponente();
    RenderizarComponente textura = new RenderizarComponente(galinhaTexturaComponente.pixelArt, galinhaTexturaComponente.colors, 6, true);

    GerenciadoComponente gerenciadoComponente = new GerenciadoComponente();
    RenderizacaoSistema renderizacaoSistema = new RenderizacaoSistema(gerenciadoComponente);


    @Override
    public void paint(Graphics g) {
        textura.pixelArt.length
        g.drawImage(renderizacaoSistema.bufferedImage, 300, 300, re, 300, this);
    }
}
