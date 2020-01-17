package com.mrn.sfgpetclinic.controllers;

import com.mrn.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/index", "/index.html"})
    public String owners(Model model) {
        // this is called by spring mvc and will inject the model to it. when will run will return the allOwners find by the service
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

}
