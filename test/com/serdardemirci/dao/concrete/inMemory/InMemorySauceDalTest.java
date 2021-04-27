package com.serdardemirci.dao.concrete.inMemory;

import com.serdardemirci.domain.Sauce;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemorySauceDalTest {
    private InMemorySauceDal sauceDal;

    @BeforeEach
    void setUp(){
        sauceDal = new InMemorySauceDal();
    }

    @Test
    void getAll() {
        int size = 2;
        assertEquals(size, sauceDal.getAll().size());
    }

    @Test
    void getById() {
        Sauce sauce = new Sauce(1, "Tomatensauce", 0.0);
        int id = 1;
        assertEquals(sauce.id, sauceDal.getById(id).id);
    }
}