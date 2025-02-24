package demoapp;

import demoapp.service.AnagramaService;
import demoapp.service.PalindromoService;
import demoapp.service.SaludoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MockServiceTest {

    @Autowired
    private MockMvc mockMvc;

    // Podemos también mockear el servicio
    @MockBean
    private SaludoService service;
    @Autowired
    private AnagramaService anagramaService;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {

        // Y especificar lo que debe devolver una llamada a uno de sus métodos
        when(service.saluda("Juan")).thenReturn("Hola Mock Juan");

        this.mockMvc.perform(get("/saludo/Juan"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hola Mock Juan")));
    }

    @MockBean
    private PalindromoService servicePalindromo;

    @Test
    public void shouldReturnMockPalindromeResponse() throws Exception {
        when(servicePalindromo.isPalindrome("reconocer")).thenReturn(true);
        when(servicePalindromo.isPalindrome("hola")).thenReturn(false);

        this.mockMvc.perform(post("/palindrome").param("palabra", "reconocer"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Es un palindromo")));

        this.mockMvc.perform(post("/palindrome").param("palabra", "hola"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("No Es un palindromo")));
    }


    @MockBean
    private AnagramaService serviceAnagrama;

    @Test
    public void shouldReturnMockAnagramaResponse() throws Exception {
        when(anagramaService.isAnagrama("amor", "roma")).thenReturn(true);
        when(anagramaService.isAnagrama("pato", "gato")).thenReturn(false);

        this.mockMvc.perform(post("/anagrama").param("palabra1", "lalo", "palabra2", "lola"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Es un anagrama")));

        this.mockMvc.perform(post("/anagrama").param("palabra1", "pato", "palabra2", "gato"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("No Es un anagrama")));
    }

}
