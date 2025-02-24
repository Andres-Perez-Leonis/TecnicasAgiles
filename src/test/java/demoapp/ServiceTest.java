package demoapp;

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

    @Test
    public void contexLoads() throws Exception {
        assertThat(saludo).isNotNull();
    }

    @Test
    public void serviceSaludo() throws Exception {
        assertThat(saludo.saluda("Juan")).isEqualTo("Hola Juan");
    }

    @Autowired
    PalindromoService palindromoService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(palindromoService).isNotNull();
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
}
