package org.example.Cenas;

import org.example.Componente.GerenciadoComponente;
import org.example.Componente.PosicaoComponente;
import org.example.Entidades.Entidade;
import org.example.Sistema.RenderizacaoSistema;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CenaLogin extends Canvas {

    public CenaLogin(){
        setSize(600, 400);
        setBackground(Color.RED);


        GerenciadoComponente gerenciadoComponente = new GerenciadoComponente();;
        RenderizacaoSistema renderizacaoSistema = new RenderizacaoSistema(gerenciadoComponente);;


        PosicaoComponente posicaoComponente = new PosicaoComponente(100,100);

        List<Entidade> entidades;
        entidades = new ArrayList<>();
        Entidade login = new Entidade("Login");

        entidades.add(login);

        GerenciadoComponente posicao = gerenciadoComponente.getPosicaoComponente(entidades);

    }

    @Override
    public void paint(Graphics g) {

        //Fazer o processo de Autenticação na tela...
        System.out.println("Tela Login");
        g.setColor(Color.blue);
        g.drawString("LOGIN! ", posicaoComponente.posX,posicaoComponente.posY);
    }
}
