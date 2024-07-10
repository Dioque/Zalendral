package org.example.Entidades;

public class Entidade {
    public static int nextId = 0;
    public int id;
    public String nome;

    public Entidade(String nome){
        this.id = nextId++;
        this.nome = nome;
    }

    public int getId(){
        return id;
    }
}
