package demoapp.controller;

import demoapp.service.AnagramaService;
import demoapp.service.PalindromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnagramaController {

    @Autowired
    private AnagramaService anagramaService;


    @PostMapping("/anagrama/{palabra1}{parabra2}")
    public @ResponseBody boolean verificarAnagrama(@RequestParam String palabra1, @RequestParam String palabra2) {
        boolean esAnagrama = anagramaService.isAnagrama(palabra1, palabra2);
        return esAnagrama;
    }
}