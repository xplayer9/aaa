package com.example.apple;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AppleControllerTest {

    @Autowired
    AppleRepository rep;

    @AfterEach
    void tearDown() {
        rep.deleteAll();
    }

    @BeforeEach
    void setUp() {
        AppleTableData data = AppleTableData.builder()
                .model("iPhone")
                .price(799.99)
                .quantity(10)
                .build();
        rep.save(data);
    }

    @Test
    void list() {
        //given

        //when
        AppleTableData one = rep.findAll().iterator().next();

        //then
        assertEquals(one.getModel(), "iPhone");
        assertEquals(one.getPrice(), 799.99);
        assertEquals(one.getQuantity(), 10);
    }

    @Test
    void add() {
        //given
        AppleTableData iPad = AppleTableData.builder()
                .model("iPad")
                .price(599.99)
                .quantity(20)
                .build();
        rep.save(iPad);
        //when
        long count = rep.count();

        //then
        assertEquals(2, count);
    }

    @Test
    void del() {
        //given
        //when
        rep.deleteById(rep.findAll().iterator().next().getId());
        long count = rep.count();
        //then
        assertEquals(0, count);
    }
}