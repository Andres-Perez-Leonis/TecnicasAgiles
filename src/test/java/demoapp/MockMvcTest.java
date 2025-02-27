package demoapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    // Hacemos una petición GET a un end point y comprobamos que
    // el HTML resultante es correcto
    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }

    // Podemos hacer también una petición POST y pasar los datos
    // del formulario con el método .param
    @Test
    public void postShoudReturnCorrectResponse() throws Exception {
        this.mockMvc.perform(post("/saludoform")
                .param("nombre", "Juan"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hola Juan")));
    }

    @Test
    public void postShouldCheckIfWordIsPalindrome() throws Exception {
        this.mockMvc.perform(post("/palindrome")
                        .param("palabra", "reconocer"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Es un palindromo")));
    }

    @Test
    public void postShouldCheckIfWordIsNotPalindrome() throws Exception {
        this.mockMvc.perform(post("/palindrome")
                        .param("palabra", "mundo"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("No Es un palindromo")));
    }

    @Test
    public void postShouldCheck2WordsIsAnagrama() throws Exception {
        this.mockMvc.perform(post("/anagrama")
                .param("palabra1", "lalo")
                .param( "palabra2", "lola"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Es un anagrama")));
    }
    @Test
    public void postShouldCheck2WordsIsNotAnagrama() throws Exception {
        this.mockMvc.perform(post("/anagrama")
                .param("palabra1", "pato")
                .param( "palabra2", "gato"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("No Es un anagrama")));
    }
}
