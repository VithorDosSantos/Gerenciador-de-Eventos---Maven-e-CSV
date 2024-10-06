package com.example;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Evento[] eventos = new Evento[10];
        GestorDeEventos gerirEventos = new GestorDeEventos();
        Scanner sc = new Scanner(System.in);
        int i = 0;
        int j;
        int indice = 0;
        int flag = 0;

        gerirEventos.setEventos(eventos);

        while(true){
            System.out.println("Menu principal: ");
            System.out.println("\na) Comprar ingresso");
            System.out.println("b) Cadastrar evento");
            System.out.println("c) Salvar eventos em CSV");
            System.out.println("d) Ler arquivo csv");
            System.out.println("x) Sair");
            char c = sc.next().charAt(0);

            if(c == 'a'){
                if(gerirEventos.getEventos()[0] == null){
                    System.out.println("\nNao ha nenhum evento cadastrado");
                    System.exit(0);
                }else{
                    System.out.println("\nCompra: ");
                    System.out.println("a) Pesquisar evento por nome");
                    System.out.println("b) Listar eventos");
                    System.out.println("x) Sair");
                    char a = sc.next().charAt(0);

                    if(a == 'a'){
                        sc.nextLine();
                        System.out.println("\nEscolha o evento: ");
                        String nome = sc.nextLine();

                        for(j = 0; j < gerirEventos.getEventos().length; j++){
                            if(nome.equals(gerirEventos.getEventos()[j].getNome()) == true && gerirEventos.getEventos()[j] != null){
                                indice = j;
                                System.out.println("\n\tNome: " + gerirEventos.getEventos()[j].getNome());
                                System.out.println("\tData: " + gerirEventos.getEventos()[j].getData());
                                System.out.println("\tLocal: " + gerirEventos.getEventos()[j].getLocal());
                                System.out.println("\tNumero de ingressos disponiveis: " + (gerirEventos.getEventos()[j].getCapacidadeMaxima() - gerirEventos.getEventos()[j].getNumeroDePessoas()));
                                System.out.println("\n");
                                flag = 1;
                            }else{
                                System.out.println("Digite um nome valido na proxima");
                            }
                        }

                        if(flag == 1){
                            System.out.println("Gostaria de ver os ingressos disponiveis nesse evento (S/N)? ");
                            char b = sc.next().charAt(0);

                            if(b == 'S'){
                                Evento e = new Evento();
                                e = eventos[indice];

                                System.out.println("Detalhes do evento: \n");
                                System.out.println("Area " + e.vip.getNome() + ":");
                                System.out.println("\tPreco: " + e.vip.getPreco());
                                System.out.println("\tIngressos disponiveis: " + (e.vip.getIngressos() - e.vip.getCompra()));

                                System.out.println("\nArea " + e.camarote.getNome() + ":");
                                System.out.println("\tPreco: " + e.camarote.getPreco());
                                System.out.println("\tIngressos disponiveis: " + (e.camarote.getIngressos() - e.vip.getCompra()));

                                System.out.println("\nArea " + e.pista.getNome() + ":");
                                System.out.println("\tPreco: " + e.pista.getPreco());
                                System.out.println("\tIngressos disponiveis: " + (e.pista.getIngressos() - e.pista.getCompra()));

                                e.verificarCapacidade();

                                System.out.println("\nGostaria de comprar algum ingresso (S/N)?");
                                b = sc.next().charAt(0);

                                if(b == 'S'){
                                    sc.nextLine();
                                    System.out.println("\nDigite Vip, Camarote ou Pista: ");
                                    String area = sc.nextLine();

                                    if(area.equals(e.vip.getNome())){
                                        e.inscrever(e.vip);
                                        if(e.inscrever(e.vip) == false){
                                            break;
                                        }
                                    }
                                    if(area.equals(e.camarote.getNome())){
                                        e.inscrever(e.camarote);
                                        if(e.inscrever(e.camarote) == false){
                                            break;
                                        }
                                    }
                                    if(area.equals(e.pista.getNome())){
                                        e.inscrever(e.pista);
                                        if(e.inscrever(e.pista) == false){
                                            break;
                                        }
                                    }
                                }
                                if(b == 'N'){
                                    System.out.println("\nObrigado por visitar o gestor de eventos!");
                                }
                            }
                            if(b == 'N'){
                                System.out.println("\nObrigado por visitar o gestor de eventos!");
                            }
                        }
                    }
                    if(a == 'b'){
                        System.out.println("\nEventos Disponiveis:\n");
                        for(j = 0; j < gerirEventos.getEventos().length; j++){
                            if(gerirEventos.getEventos()[j] != null){
                                System.out.println("\tNome: " + gerirEventos.getEventos()[j].getNome());
                                System.out.println("\tData: " + gerirEventos.getEventos()[j].getData());
                                System.out.println("\tLocal: " + gerirEventos.getEventos()[j].getLocal());
                                System.out.println("\tNumero de ingressos disponiveis: " + (gerirEventos.getEventos()[j].getCapacidadeMaxima() - gerirEventos.getEventos()[j].getNumeroDePessoas()));
                                System.out.println("\n");
                            }
                        }

                        System.out.println("\nGostaria de ver os ingressos disponiveis nesse evento (S/N)? ");
                        char b = sc.next().charAt(0);

                        if(b == 'S'){
                            Evento e = new Evento();
                            e = gerirEventos.getEventos()[indice];

                            System.out.println("Detalhes do evento: \n");
                            System.out.println("Area " + e.vip.getNome() + ":");
                            System.out.println("\tPreco: " + e.vip.getPreco());
                            System.out.println("\tIngressos disponiveis: " + (e.vip.getIngressos() - e.vip.getCompra()));

                            System.out.println("\nArea " + e.camarote.getNome() + ":");
                            System.out.println("\tPreco: " + e.camarote.getPreco());
                            System.out.println("\tIngressos disponiveis: " + (e.camarote.getIngressos() - e.vip.getCompra()));

                            System.out.println("\nArea " + e.pista.getNome() + ":");
                            System.out.println("\tPreco: " + e.pista.getPreco());
                            System.out.println("\tIngressos disponiveis: " + (e.pista.getIngressos() - e.pista.getCompra()));

                            e.verificarCapacidade();

                            System.out.println("\nGostaria de comprar algum ingresso (S/N)?");
                            b = sc.next().charAt(0);

                            if(b == 'S'){
                                sc.nextLine();
                                System.out.println("\nDigite Vip, Camarote ou Pista: ");
                                String area = sc.nextLine();

                                if(area.equals(e.vip.getNome())){
                                    e.inscrever(e.vip);
                                    if(e.inscrever(e.vip) == false){
                                        break;
                                    }
                                }
                                if(area.equals(e.camarote.getNome())){
                                    e.inscrever(e.camarote);
                                    if(e.inscrever(e.camarote) == false){
                                        break;
                                    }
                                }
                                if(area.equals(e.pista.getNome())){
                                    e.inscrever(e.pista);
                                    if(e.inscrever(e.pista) == false){
                                        break;
                                    }
                                }
                            }
                            if(b == 'N'){
                                System.out.println("\nObrigado por visitar o gestor de eventos!");
                            }
                        }
                        if(b == 'N'){
                            System.out.println("\nObrigado por visitar o gestor de eventos!");
                        }
                    }
                    if(a == 'x'){
                        System.exit(0);
                    }
                }
            }
            if(c == 'b'){
                if(gerirEventos.verificarEventos() == true){
                    System.out.println("\nO numero maximo de eventos foi atingido!");
                    flag = 1;
                }

                if(flag == 0){
                    Evento evento = new Evento();

                    sc.nextLine();
                    System.out.println("\nInforme o nome do evento: ");
                    String nome = sc.nextLine();

                    System.out.println("\nInforme o local do evento: ");
                    String local = sc.nextLine();

                    System.out.println("\nInfomre a data do evento: ");
                    String data = sc.nextLine();

                    System.out.println("\nInforme a capacidade maxima do evento: ");
                    int cap = sc.nextInt();

                    System.out.println("\nAreas do evento: \n\nInforme o preco da area vip: ");
                    double p1 = sc.nextDouble();

                    System.out.println("\nInforme sua quantidade de ingressos: ");
                    int q1 = sc.nextInt();

                    System.out.println("\nInforme o preco do camarote: ");
                    double p2 = sc.nextDouble();

                    System.out.println("\nInforme sua quantidade de ingressos: ");
                    int q2 = sc.nextInt();

                    System.out.println("\nInforme o preco da pista: ");
                    double p3 = sc.nextDouble();

                    System.out.println("\nInforme sua quantidade de ingressos: ");
                    int q3 = sc.nextInt();

                    Evento e = new Evento(nome, data, local, cap);
                    e.vip.setPreco(p1);
                    e.vip.setIngressos(q1);
                    e.camarote.setPreco(p2);
                    e.camarote.setIngressos(q2);
                    e.pista.setPreco(p3);
                    e.pista.setIngressos(q3);

                    eventos[i] = e;
                    gerirEventos.setEventos(eventos);
                    System.out.println("\nEvento cadastrado!\n");
                    i++;
                }
            }
            if(c == 'c'){
                if(gerirEventos.getEventos()[0] == null){
                    System.out.println("\nNao ha eventos cadastrados para salvar.");
                } else {
                    EventoCsv.addEvento(gerirEventos.getEventos()[0], gerirEventos);
                    System.out.println("\nEventos salvos no arquivo CSV com sucesso!");
                }
            }
            if(c=='d'){
                EventoCsv.listar();
            }
            if(c == 'x'){
                System.exit(0);
            }
        }
    }
}
