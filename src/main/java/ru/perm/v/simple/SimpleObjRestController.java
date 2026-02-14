package ru.perm.v.simple;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple")
public class SimpleObjRestController {

    @GetMapping("/502")
    public ResponseEntity<?> bad502() {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("message 502");
    }

    @GetMapping("/503")
    public ResponseEntity<?> bad503() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("message 503");
    }

    @GetMapping("/{message}")
    public ResponseEntity<?> echo(@PathVariable("message") String message) {
        if (message == null || message.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("message is empty");
        }

        if (message.length() < 2) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("message is too short");
        }
        return ResponseEntity.ok(new SimpleObj(message));
    }
}
