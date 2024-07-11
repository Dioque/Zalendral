package org.example.Sistema;

import org.example.Componente.GerenciadoComponente;
import org.example.Componente.PosicaoComponente;
import org.example.Componente.RenderizarComponente;
import org.example.Componente.Res.GalinhaTexturaComponente;
import org.example.Entidades.Entidade;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class RenderizacaoSistema {
    private GerenciadoComponente gerenciadoComponente;

    public RenderizacaoSistema(GerenciadoComponente gerenciadoComponente){
        this.gerenciadoComponente = gerenciadoComponente;
    }

    public BufferedImage bufferedImage;
    //Renderiza a entidade na tela
    public void renderizador(Graphics g, List<Entidade> entidades, double angular){

        for(Entidade entidade : entidades){

            PosicaoComponente posicao = gerenciadoComponente.getPosicaoComponente(entidade);
            RenderizarComponente renderizar = gerenciadoComponente.getRenderizarComponente(entidade);


            int[][] pixelArt = renderizar.pixelArt;
            Color[] colors = renderizar.colors; //tabela de cores
            int tamanhoPixel = renderizar.tamanhoPixel;
            boolean espelhar = renderizar.espelhar;


            if (posicao != null && renderizar != null){
                BufferedImage textura = new BufferedImage(
                        pixelArt[0].length * tamanhoPixel,
                        pixelArt.length * tamanhoPixel,
                        BufferedImage.TYPE_INT_ARGB
                );
                bufferedImage = textura;

                Graphics2D g2d = textura.createGraphics();
                for(int altura = 0; altura < pixelArt.length; altura++){
                    for (int largura = 0; largura < pixelArt[altura].length; largura++) {
                        int getPixel = pixelArt[altura][largura];
                        if (getPixel < colors.length && getPixel != 0){
                            g2d.setColor(colors[getPixel]);
                        } else if (getPixel == 0) {
                            continue;
                        } else {
                            System.err.println("Cor '"+getPixel+"' não existe na tabela de cores!");
                        }
                        g2d.fillRect(largura * tamanhoPixel, altura * tamanhoPixel, tamanhoPixel, tamanhoPixel);
                    }
                }
                g2d.dispose();

                //double angulo = 23;

 /*               Graphics2D g2dOriginal = (Graphics2D) g.create();
                g2dOriginal.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
                g2dOriginal.translate(posicao.x + pixelArt[0].length * tamanhoPixel / 2, posicao.y + pixelArt.length * tamanhoPixel / 2);
                g2dOriginal.rotate(Math.toRadians(angular));
                g2dOriginal.translate(-pixelArt[0].length * tamanhoPixel / 2, -pixelArt.length * tamanhoPixel / 2);

                if (espelhar) {
                    g2dOriginal.scale(-1, 1);
                    g2dOriginal.translate(-pixelArt[0].length * tamanhoPixel, 0);
                }

                g2dOriginal.drawImage(textura, 0, 0, null);
                g2dOriginal.dispose();
*/

                if(espelhar){
                    g.drawImage(textura, posicao.posX + pixelArt[0].length * tamanhoPixel, posicao.posY,
                            -textura.getWidth(), textura.getHeight(), null);
                }else {
                    g.drawImage(textura, posicao.posX, posicao.posY, null);
                }

            }


            public BufferedImage getTexturaG(){
                return bufferedImage;
            }
        }
    }
}
