package com.mrn.sfgpetclinic.controllers;

import com.mrn.sfgpetclinic.model.Vet;
import com.mrn.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@RequestMapping()
@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String list(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index"; // correspond with the thymeleaf html file from templates/vets/index.html
    }


    @RequestMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJSON() {
        return vetService.findAll();
    }
}
