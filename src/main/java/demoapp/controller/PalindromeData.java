package demoapp.controller;

import javax.validation.constraints.Size;

public class PalindromeData {
    @Size(min=3, max=30)
    String palabra;

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPalabra() {
        return palabra;
    }
}
