package ru.my.petclinic.dummy.mypetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.my.petclinic.dummy.mypetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String index(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "/owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(){
        return "/notimplemented";
    }

}
