package org.example;

import org.example.Cenas.CenaCarregamento;
import org.example.Cenas.CenaLogin;
import org.example.Cenas.CenaRendereziador;
import org.example.Sistema.FpsSistema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciadoCena extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private CenaCarregamento cenaCarregamento;
    private CenaLogin cenaLogin;
    private CenaRenderizador cenaRenderizador;
    private JPanel painelBotao;
    

    public GerenciadoCena(){
    	cenaCarregamento = new CenaCarregamento();
        cenaLogin = new CenaLogin();
        cenaRenderizador = new CenaRenderizador();
        painelBotao = new JPanel();
    	
    	this.init();
    }
    
    private void init() {
    	setTitle("Zaledral");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        this.adicionarBotoes();
        
        add(painelBotao, BorderLayout.NORTH);
        add(cenaLogin);

        setVisible(true);
    }
    
    private void adicionarBotoes(){
    	
    	JButton botaoCenaInicial = new JButton("Inicial");
        JButton botaoCenaLogin = new JButton("Renderizador");
        
      //criar listener externo
        botaoCenaInicial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCena(cenaCarregamento);
            }
        });

        //criar listener externo
        botaoCenaLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	FpsSistema fpsSistema = new FpsSistema(true, 24);
                fpsSistema.mostrarFPS();
                mostrarCena(cenaRenderizador);
            }
        });
        
        painelBotao.add(botaoCenaInicial);
        painelBotao.add(botaoCenaLogin);
        
    }
    

    private void mostrarCena(Canvas cenas){
        getContentPane().removeAll();
        add(painelBotao, BorderLayout.NORTH);
        add(cenas);

        revalidate();
        repaint();
        System.out.println("Achei o Bug");
    }

	public CenaCarregamento getCenaCarregamento() {
		return cenaCarregamento;
	}

	public CenaLogin getCenaLogin() {
		return cenaLogin;
	}

	public CenaRenderizador getCenaRenderizador() {
		return cenaRenderizador;
	}

	public void setCenaCarregamento(CenaCarregamento cenaCarregamento) {
		this.cenaCarregamento = cenaCarregamento;
	}

	public void setCenaLogin(CenaLogin cenaLogin) {
		this.cenaLogin = cenaLogin;
	}

	public void setCenaRenderizador(CenaRenderizador cenaRenderizador) {
		this.cenaRenderizador = cenaRenderizador;
	}

	public JPanel getPainelBotao() {
		return painelBotao;
	}

	public void setPainelBotao(JPanel painelBotao) {
		this.painelBotao = painelBotao;
	}
	
}
