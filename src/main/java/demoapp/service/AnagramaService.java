package demoapp.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AnagramaService {
    public boolean isAnagrama(String palabra1, String palabra2) {
        if (palabra1 == null || palabra2 == null) return false;

        char[] array1 = palabra1.toLowerCase().replaceAll("\\s+", "").toCharArray();
        char[] array2 = palabra2.toLowerCase().replaceAll("\\s+", "").toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }
}
