package demoapp;

import demoapp.service.AnagramaService;
import demoapp.service.PalindromoService;
import demoapp.service.SaludoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ServiceTest {

    @Autowired
    SaludoService saludo;


    @Autowired
    PalindromoService palindromoService;


    @Autowired
    AnagramaService anagramaService;

    @Test
    public void contexLoads() throws Exception {
        assertThat(saludo).isNotNull();
        assertThat(palindromoService).isNotNull();
        assertThat(anagramaService).isNotNull();
    }

    @Test
    public void serviceSaludo() throws Exception {
        assertThat(saludo.saluda("Juan")).isEqualTo("Hola Juan");
    }


    @Test
    public void shouldDetectPalindrome() {
        assertThat(palindromoService.isPalindrome("reconocer")).isTrue();
        assertThat(palindromoService.isPalindrome("Anita lava la tina")).isTrue();
    }

    @Test
    public void shouldDetectNonPalindrome() {
        assertThat(palindromoService.isPalindrome("mundo")).isFalse();
    }

    @Test
    public void shouldDetectAnagrama() {
        assertThat(anagramaService.isAnagrama("amor", "roma")).isTrue();
        assertThat(anagramaService.isAnagrama("Listen", "Silent")).isTrue();
    }

    @Test
    public void shouldDetectNonAnagrama() {
        assertThat(anagramaService.isAnagrama("perro", "gato")).isFalse();
    }

}
