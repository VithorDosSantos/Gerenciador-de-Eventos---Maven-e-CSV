package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.io.FileReader;

import com.example.GestorDeEventos;
public class EventoCsv {

    private static String nomeArquivo="./dados/Eventos.csv";

    public static void addEvento(Evento evento, GestorDeEventos gerir){
        try{
            //verifica se o arquivo existe
            boolean arquivoExiste = new File(nomeArquivo).exists();
            // abre o escritor para escrver os dados
            FileWriter escritor = new FileWriter(nomeArquivo, StandardCharsets.ISO_8859_1,true);
            if(!arquivoExiste){
                escritor.write("Nome,Valor Pista,Ingressos Pista,Valor Vip,Ingressos Vip,Valor Camarote,Ingressos Camarote, Data,Local,Capacidade Evento\n");
            }
            //escrever os dados do evento no formato apropiado
            for (Evento evento1 : gerir.getEventos()) {
                if (evento1 != null) {
                    escritor.write(evento1.getNome() + "," + evento1.pista.getPreco() + "," + evento1.pista.getIngressos() + "," + evento1.vip.getPreco() + "," + evento1.vip.getIngressos() + "," + evento1.camarote.getPreco() + "," + evento1.camarote.getIngressos() + "," + evento1.getData() + "," + evento1.getLocal() + "," + evento1.getCapacidadeMaxima() + "\n");
                }
            }

            //escrever os dados do arquivo imediatamente
            escritor.flush();
            //fechar o recurso de escrita
            escritor.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Evento>listar(){
        ArrayList<Evento> listar = new ArrayList<>();

        try {
            // abrir um leitor para ler um arquivo
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            boolean primeiraLinha = true;

            while ((linha=leitor.readLine())!=null){
                //ignora a primeira linha(nome,valor e etc..)
                if(primeiraLinha){
                    primeiraLinha=false;
                    continue;
                }
                //dividir a linha em partes usando a virgula
                String[] partes = linha.split(",");

                String nome = partes[0];
                double valorPista =Double.parseDouble(partes[1]);
                int ingressosPista = Integer.parseInt(partes[2]);
                double valorVip =Double.parseDouble(partes[3]);
                int ingressosVip = Integer.parseInt(partes[4]);
                double valorCamarote =Double.parseDouble(partes[5]);
                int ingressosCamarote = Integer.parseInt(partes[6]);
                String data = partes[7];
                String local = partes[8];
                int capacidadeEvento =Integer.parseInt(partes[9]);

                //criar o objeto evento
                Evento ev = new Evento(nome,data,local,capacidadeEvento);
                ev.vip.setPreco(valorVip);
                ev.camarote.setPreco(valorCamarote);
                ev.pista.setPreco(valorPista);
                ev.vip.setIngressos(ingressosVip);
                ev.camarote.setIngressos(ingressosCamarote);
                ev.pista.setIngressos(ingressosCamarote);

                //adiciona na lista
                listar.add(ev);

                //imprimir informçaoes do evento
                System.out.println("Nome: "+ nome + "\n\tValor Pista: " + valorPista + "\n\tIngressos Pista: " + ingressosPista + "\n\tValor Vip: " + valorVip + "\n\tIngressos Vip: " + ingressosVip + "\n\tValor Camarote: " + valorCamarote + "\n\tIngressos Camarote: " + ingressosCamarote + "\n\tData: " + data + "\n\tLocal: " + local+ "\n\tCapacidade Evento: " + capacidadeEvento + "\n");
            }
            leitor.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return listar;
    }
    public String getNomeArquivo() {
        return nomeArquivo;
    }
}