package demoapp.controller;

import demoapp.service.PalindromoService;
import demoapp.service.SaludoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
@Controller
public class PalindromeControllerForm {

    @Autowired
    private PalindromoService service;

    @GetMapping("/palindrome")
    public String palindromoForm(PalindromeData palindromeData) {
        return "palindromeForm";
    }

    @PostMapping("/palindrome")
    public String checkPersonInfo(@ModelAttribute @Valid PalindromeData palindromeData, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "palindromeForm";
        }
        String mensaje = "Es un palindromo";
        if(!service.isPalindrome(palindromeData.getPalabra())) mensaje = "No " + mensaje;
        model.addAttribute("resultado", mensaje);
        return "palindrome";
    }

}


