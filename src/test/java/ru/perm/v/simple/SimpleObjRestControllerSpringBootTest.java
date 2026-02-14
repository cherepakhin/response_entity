package ru.perm.v.simple;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SimpleObjRestControllerSpringBootTest {
    @Autowired
    SimpleObjRestController simpleObjRestController;

    @Test
    void echo() {
        ResponseEntity<?> result = simpleObjRestController.echo("TEST_MESSAGE"); // returned OBJECT !!! get object by getBody()

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

        assertEquals(503, result.getStatusCodeValue());
        assertEquals("message is too short", result.getBody());
    }

    @Test
    void bad502() {
        ResponseEntity<?> result = simpleObjRestController.bad502();

        assertEquals(502, result.getStatusCodeValue());
        assertEquals("message 502", result.getBody());
    }

    @Test
    void bad503() {
        ResponseEntity<?> result = simpleObjRestController.bad503();

        assertEquals(503, result.getStatusCodeValue());
        assertEquals("message 503", result.getBody());
    }
}