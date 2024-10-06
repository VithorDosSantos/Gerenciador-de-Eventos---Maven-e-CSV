package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;


class AppTest {
    private GestorDeEventos gerirEventos = new GestorDeEventos();
    private Evento evento = new Evento("Rock doido", "27/04/2025", "Mangueirão", 8000);
    private Area a = new Area("Vip", 50, 100, 0);


    @Test
    public void testarCapacidade(){
        assertEquals(false, evento.verificarCapacidade());
    }

    @Test
    public void testarIngresso(){
        assertEquals(false, evento.verificarIngresso(a));
    }

    @Test
    public void testarInscricao(){
        assertEquals(true, evento.inscrever(a));
    }

    @Test
    public void testarVerificarEventos(){
        assertEquals(false, gerirEventos.verificarEventos());
    }

}
