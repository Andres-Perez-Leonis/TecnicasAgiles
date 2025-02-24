package demoapp.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromoService {
    public boolean isPalindrome(String palabra) {
        if(palabra == null || palabra.isEmpty()) return false;
        String limpia = palabra.replaceAll("\\s+", "").toLowerCase();
        String invertida = new StringBuilder(limpia).reverse().toString();
        return limpia.equals(invertida);
    }
}
