package ru.my.petclinic.dummy.mypetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.my.petclinic.dummy.mypetclinic.services.VetService;

@Controller
public class VetsController {

    private VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }


    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String index(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
