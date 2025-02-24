package demoapp.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PalindromeData {
    @Size(min=3, max=30)
    @NotBlank(message = "La palabra no puede estar vacia")
    private String palabra;

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPalabra() {
        return palabra;
    }
}
