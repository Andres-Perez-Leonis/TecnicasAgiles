package demoapp.controller;

import demoapp.service.PalindromoService;
import demoapp.service.SaludoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PalindromeController {

    @Autowired
    private PalindromoService service;

    @RequestMapping("/saludo/{nombre}")
    public @ResponseBody boolean saludo(@PathVariable(value="palabra") String palabra) {
        return service.isPalindrome(palabra);
    }
}
