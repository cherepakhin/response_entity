package ru.perm.v.simple;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SimpleObjControllerTest {
    @Autowired
    SimpleObjRestController simpleObjRestController;

    @Test
    void echo() {
        ResponseEntity<?> result = simpleObjRestController.echo("TEST_MESSAGE");

        assertEquals(200, result.getStatusCodeValue());
        assertEquals(new SimpleObj("TEST_MESSAGE"), result.getBody());
    }

    @Test
    void echoForNull() {
        ResponseEntity<?> result = simpleObjRestController.echo(null);

        assertEquals(502, result.getStatusCodeValue());
        assertEquals("message is empty", result.getBody());
    }

    @Test
    void echoForShortMessage() {
        ResponseEntity<?> result = simpleObjRestController.echo("A");

        assertEquals(502, result.getStatusCodeValue());
        assertEquals("message is too short", result.getBody());
    }
}