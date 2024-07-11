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
    private CenaRendereziador cenaRendereziador;
    private JPanel painelBotao;

    public GerenciadoCena(){
        setTitle("Zaledral");
        setSize(900,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cenaCarregamento = new CenaCarregamento();
        cenaLogin = new CenaLogin();
        cenaRendereziador = new CenaRendereziador();

        painelBotao = new JPanel();
        JButton botaoCenaInicial = new JButton("Inicial");
        JButton botaoCenaLogin = new JButton("Login");

        botaoCenaInicial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCena(cenaCarregamento);
            }
        });

        botaoCenaLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCena(cenaLogin);
            }
        });

        painelBotao.add(botaoCenaInicial);
        painelBotao.add(botaoCenaLogin);

        add(painelBotao, BorderLayout.NORTH);
        add(cenaRendereziador);

      //

        setVisible(true);
    }

    private void mostrarCena(Canvas cenas){
        getContentPane().removeAll();
        add(painelBotao, BorderLayout.NORTH);
        add(cenas);

        revalidate();
        repaint();
    }
}
