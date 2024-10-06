package com.example;

public class Area {
    private String nome;
    private double preco;
    private int ingressos;
    private int compra = 0;

    public Area(String nome, double preco, int ingressos, int compra) {
        this.nome = nome;
        this.preco = preco;
        this.ingressos = ingressos;
        this.compra = compra;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Area(String nome) {
        this.nome = nome;
    }

    public int getIngressos() {
        return ingressos;
    }

    public void setIngressos(int ingressos) {
        this.ingressos = ingressos;
    }

    public int getCompra() {
        return compra;
    }

    public void setCompra(int compra) {
        this.compra = compra;
    }

    
}

