package org.example;

import org.example.Cenas.CenaCarregamento;
import org.example.Cenas.CenaLogin;
import org.example.Cenas.CenaRendereziador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciadoCena extends JFrame {
    private CenaCarregamento cenaCarregamento;
    private CenaLogin cenaLogin;
    private CenaRenderizador cenaRenderizador;
    private JPanel painelBotao;

    public GerenciadoCena(){
        setTitle("Zaledral");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cenaCarregamento = new CenaCarregamento();
        cenaLogin = new CenaLogin();
        cenaRenderizador = new CenaRenderizador();

        painelBotao = new JPanel();
        JButton botaoCenaInicial = new JButton("Inicial");
        JButton botaoCenaLogin = new JButton("Renderizador");

        botaoCenaInicial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCena(cenaCarregamento);
            }
        });

        botaoCenaLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCena(cenaRenderizador);
            }
        });

        painelBotao.add(botaoCenaInicial);
        painelBotao.add(botaoCenaLogin);

        add(painelBotao, BorderLayout.NORTH);
        add(cenaLogin);

      //

        setVisible(true);
    }

    private void mostrarCena(Canvas cenas){
        getContentPane().removeAll();
        add(painelBotao, BorderLayout.NORTH);
        add(cenas);

        revalidate();
        repaint();
        System.out.println("Achei o Bug");
    }
}
