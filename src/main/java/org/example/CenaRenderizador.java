package org.example;

import org.example.Componente.GerenciadoComponente;
import org.example.Componente.PosicaoComponente;
import org.example.Componente.RenderizarComponente;
import org.example.Componente.Res.GalinhaTexturaComponente;
import org.example.Componente.VelocidadeComponete;
import org.example.Entidades.Entidade;
import org.example.Sistema.RenderizacaoSistema;

import java.awt.*;
import java.awt.image.BufferStrategy;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CenaRenderizador extends Canvas implements Runnable{


    private GerenciadoComponente gerenciadoComponente;
    private RenderizacaoSistema renderizacaoSistema;
    private List<Entidade> entidades;
    private boolean correndo = false;

    double angular;

    private GalinhaTexturaComponente galinhaTexturaComponente;

    public CenaRenderizador(){
        gerenciadoComponente = new GerenciadoComponente();
        renderizacaoSistema = new RenderizacaoSistema(gerenciadoComponente);

        //Carregar Textura Entidade
        galinhaTexturaComponente = new GalinhaTexturaComponente();

        entidades = new ArrayList<>();

        RenderizarComponente textura = new RenderizarComponente(galinhaTexturaComponente.pixelArt, galinhaTexturaComponente.colors, 6, true);
        Entidade galinha1 = new Entidade("Galinha");
        gerenciadoComponente.addPosicaoComponente(galinha1, new PosicaoComponente(200, 250));
        gerenciadoComponente.addVelocidadeComponente(galinha1, new VelocidadeComponete(4));
        gerenciadoComponente.addRenderizarComponente(galinha1, textura);
        entidades.add(galinha1);

        Entidade galinha2 = new Entidade("Galinha");
        gerenciadoComponente.addPosicaoComponente(galinha2, new PosicaoComponente(400, 350));
        gerenciadoComponente.addVelocidadeComponente(galinha2, new VelocidadeComponete(4));
        gerenciadoComponente.addRenderizarComponente(galinha2, textura);
        entidades.add(galinha2);

    }
    JLabel label;
    private void update(){
        angular += 4;
        for (Entidade entidade : entidades){
            PosicaoComponente posicao = gerenciadoComponente.getPosicaoComponente(entidade);
            VelocidadeComponete velocidade = gerenciadoComponente.getVelocidadeComponente(entidade);
            RenderizarComponente textura = gerenciadoComponente.getRenderizarComponente(entidade);
            posicao.posX += velocidade.velocidade;
            if (posicao.posX >= getWidth() - textura.pixelArt[0].length){
                posicao.posX = 0 + textura.pixelArt[0].length;
            }
        }
    }

    private void renderizador(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        System.err.println("Carrego o Renderizador");
        renderizacaoSistema.renderizador(g, entidades, angular);

        g.dispose();
        bs.show();
    }

    public synchronized void start(){
        correndo = true;
        new Thread(this).start();
    }

    public synchronized void stop(){
        correndo = false;
    }

    @Override
    public void run() {
        this.setFocusable(true);
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int frames = 0;
        while (correndo) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                frames++;
                delta--;
                renderizador();
                update();
            }
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(frames);
                frames = 0;
            }
        }
    }


    public static void main(String[] args) {


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GerenciadoCena gerenciadoCena = new GerenciadoCena();

                CenaRenderizador cenaRenderizador = new CenaRenderizador();

                gerenciadoCena.add(cenaRenderizador);

                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                gerenciadoCena.getContentPane().setBackground(Color.BLACK);
                gerenciadoCena.setSize(dimension);
                gerenciadoCena.setUndecorated(true);
                gerenciadoCena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gerenciadoCena.setLocationRelativeTo(null);
                gerenciadoCena.setVisible(true);
                gerenciadoCena.setResizable(false);

                cenaRenderizador.start();
            }
        });


    }

}