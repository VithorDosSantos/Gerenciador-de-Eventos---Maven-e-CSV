package com.example;

public class GestorDeEventos {
    private Evento[] eventos = new Evento[10];

    public boolean verificarEventos(){
        int flag= 0;

        for (Evento evento : eventos) {
            if (evento == null) {
                flag = 1;
            }
            if(flag == 1){
                return false;
            }
        }
        return true;
   }

    public Evento[] getEventos() {
        return eventos;
    }

    public void setEventos(Evento[] eventos) {
        this.eventos = eventos;
    }
}

