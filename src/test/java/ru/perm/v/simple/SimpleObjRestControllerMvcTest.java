package ru.perm.v.simple;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SimpleObjRestController.class)
public class SimpleObjRestControllerMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void echo() throws Exception {
        mockMvc.perform(
                        get("/simple/test_message")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("{\"message\":\"test_message\"}"))
                .andDo(print())
        ;
        // print:
        // MockHttpServletRequest:
        // HTTP Method = GET
        // Request URI = /simple/test_message
        // Parameters = {}
        // Headers = []
        // Body = <no character encoding set>
        // Session Attrs = {}

        // Handler:
        // Type = ru.perm.v.simple.SimpleObjRestController
        // Method = ru.perm.v.simple.SimpleObjRestController#echo(String)

        // Async:
        // Async started = false
        // Async result = null

        // Resolved Exception:
        // Type = null

        // ModelAndView:
        // View name = null
        // View = null
        // Model = null

        // FlashMap:
        // Attributes = null

        // MockHttpServletResponse:
        // Status = 200
        // Error message = null
        // Headers = [Content-Type:"application/json"]
        // Content type = application/json
        // Body = {"message":"test_message"}
        // Forwarded URL = null
        // Redirected URL = null
        // Cookies = []

    }

    @Test
    void testMessageWithJsonPath() throws Exception {
        mockMvc.perform(
                        get("/simple/test_message")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("test_message"));
    }

    @Test
    void testLengthMessage() throws Exception {
        mockMvc.perform(
                        get("/simple/test_message")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("test_message"));
    }

    @Test
    void checkError502() throws Exception {
        String shortMessage = "a";
        mockMvc.perform(
                        get("/simple/" + shortMessage)
                )
                .andExpect(status().isServiceUnavailable())
                .andExpect(content().string("message is too short"));
    }
}
