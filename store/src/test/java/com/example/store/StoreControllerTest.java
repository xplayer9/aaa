package com.example.store;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreControllerTest {

    @Value("${my.parameters.name}")
    String name;

    @Value("${my.parameters.addr}")
    String addr;

    @Test
    void simpleStringCheck() {
        //given

        //when
        Boolean result1 = name.equals("Justin");
        Boolean result2 = addr.equals("Cupertino");

        //then
        assertAll(
                ()->assertEquals(true,result1),
                ()->assertEquals(true,result2)
        );
    }

    @Test
    @Disabled
    void onetest(){
        assertEquals(1,2);
    }
}