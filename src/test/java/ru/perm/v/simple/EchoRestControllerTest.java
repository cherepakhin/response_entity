package ru.perm.v.simple;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EchoRestControllerTest {
    @Autowired
    EchoRestController echoRestController;

    @Test
    void echo() {
        ResponseEntity<String> result = echoRestController.echo("TEST_MESSAGE");

        assertEquals("TEST_MESSAGE", result.getBody());
    }
}