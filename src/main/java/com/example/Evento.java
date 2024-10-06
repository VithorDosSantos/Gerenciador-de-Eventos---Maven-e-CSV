package com.example;

import java.util.Scanner;

public class Evento {
    private String nome;
    private String data;
    private String local;
    private int capacidadeMaxima;
    private int numeroDePessoas = 0;
    Area vip = new Area("Vip");
    Area camarote = new Area("Camarote");
    Area pista = new Area("Pista");
    Scanner sc = new Scanner(System.in);

    
    public Evento(String nome, String data, String local, int capacidadeMaxima) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidadeMaxima = capacidadeMaxima;
    }
    public Evento() {
    }
    public boolean inscrever(Area a){
         if(verificarIngresso(a) == true){
            System.out.println("Os ingressos estão esgotados");
            return false;
         }else{
            System.out.println("Ingresso comprado. Volte Sempre!\ns");
            this.numeroDePessoas++;
            a.setCompra(a.getCompra() + 1);
            return true;
         } 
    }
    public boolean verificarCapacidade(){
        return this.numeroDePessoas == this.capacidadeMaxima;
    }
    public boolean verificarIngresso(Area a){
        return a.getCompra() == a.getIngressos();
    }
       
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }
    public int getNumeroDePessoas() {
        return numeroDePessoas;
    }
    public void setNumeroDePessoas(int numeroDePessoas) {
        this.numeroDePessoas = numeroDePessoas;
    }    
}