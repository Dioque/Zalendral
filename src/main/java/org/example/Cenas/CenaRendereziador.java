package org.example.Cenas;

import org.example.Componente.GerenciadoComponente;
import org.example.Componente.PosicaoComponente;
import org.example.Componente.RenderizarComponente;
import org.example.Componente.Res.GalinhaTexturaComponente;
import org.example.Componente.VelocidadeComponete;
import org.example.Entidades.Entidade;
import org.example.Sistema.RenderizacaoSistema;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

public class CenaRendereziador extends Canvas {

    public CenaRendereziador(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dimension);
        setBackground(Color.DARK_GRAY);


    }

    private List<Entidade> entidades;
    @Override
    public void paint(Graphics g) {
        GerenciadoComponente gerenciadoComponente = new GerenciadoComponente();
        RenderizacaoSistema renderizacaoSistema = new RenderizacaoSistema(gerenciadoComponente);

        GalinhaTexturaComponente galinhaTexturaComponente = new GalinhaTexturaComponente();
        RenderizarComponente textura = new RenderizarComponente(galinhaTexturaComponente.pixelArt, galinhaTexturaComponente.colors, 6, true);
        Entidade galinha = new Entidade("Galinha");
        gerenciadoComponente.addPosicaoComponente(galinha, new PosicaoComponente(200, 400));
        gerenciadoComponente.addVelocidadeComponente(galinha, new VelocidadeComponete(4));
        gerenciadoComponente.addRenderizarComponente(galinha, textura);
        entidades = new ArrayList<>();

        entidades.add(galinha);

    }
}
