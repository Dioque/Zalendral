package org.example.Componente;

import org.example.Entidades.Entidade;

import java.util.HashMap;
import java.util.Map;

public class GerenciadoComponente {
    private Map<Integer, PosicaoComponente> posicoes = new HashMap<>();
    private Map<Integer, RenderizarComponente> renderizadores = new HashMap<>();
    private Map<Integer, VelocidadeComponete> velocidades = new HashMap<>();

    public void addPosicaoComponente(Entidade entidade, PosicaoComponente posicao){
        posicoes.put(entidade.getId(), posicao);
    }

    public PosicaoComponente getPosicaoComponente(Entidade entidade){
        return posicoes.get(entidade.getId());
    }

    public void addVelocidadeComponente(Entidade entidade, VelocidadeComponete velocidade){
        velocidades.put(entidade.getId(), velocidade);
    }

    public VelocidadeComponete getVelocidadeComponente(Entidade entidade){
        return velocidades.get(entidade.getId());
    }

    public void addRenderizarComponente(Entidade entidade, RenderizarComponente renderizar){
        renderizadores.put(entidade.getId(), renderizar);
    }

    public RenderizarComponente getRenderizarComponente(Entidade entidade){
        return renderizadores.get(entidade.getId());
    }

}
