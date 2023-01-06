package com.bolsaideas.springboot.form.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @Value("${texto.indexcontroller.index.titulo}")
    private String textindex;

    @GetMapping({"/","","/index"})
    public String index(Model model){
        Double SegidoresFacebook = 2.145;
        model.addAttribute("titulo",textindex);
        model.addAttribute("objeto", "Pruebaaa..");
        model.addAttribute("segidoresfacebook",SegidoresFacebook);

        return "index";
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("titulo",textindex + "Form");
        return "form";
    }

    @PostMapping("/form")
    public String procesar(Model model,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String email){
        model.addAttribute("titulo",textindex);
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("email", email);

        return "resultado";
    }

}
