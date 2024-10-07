package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


class AppTest {
    private GestorDeEventos gerirEventos = new GestorDeEventos();
    private Evento evento = new Evento("Rock doido", "27/04/2025", "Mangueirão", 8000);
    private Area a = new Area("Vip", 50, 100, 0);
    private EventoCsv eCsv = new EventoCsv();

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

    @Test
    public void testarCaminhoDoCsv(){
        assertEquals("./dados/Eventos.csv", eCsv.getNomeArquivo());
    }
}
