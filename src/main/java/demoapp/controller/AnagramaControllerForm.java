package demoapp.controller;

import demoapp.service.AnagramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
@Controller
public class AnagramaControllerForm {

    @Autowired
    private AnagramaService service;


    @GetMapping("/anagrama")
    public String palindromoForm(AnagramaData anagramaData) {
        return "anagramaForm";
    }

    @PostMapping("/anagrama")
    public String checkPersonInfo(@ModelAttribute @Valid AnagramaData anagramaData, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "anagramaForm";
        }
        String mensaje = "Es un anagrama";
        if(!service.isAnagrama(anagramaData.getPalabra1(), anagramaData.getPalabra2())) mensaje = "No " + mensaje;
        model.addAttribute("resultado", mensaje);
        return "anagrama";
    }

}


