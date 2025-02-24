package demoapp.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromoService {
    public boolean isPalindrome(String palabra) {
        String invertida = new StringBuilder(palabra).reverse().toString();
        return palabra.equalsIgnoreCase(invertida);
    }
}
