package ru.my.petclinic.dummy.mypetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetsController {

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String index(){
        return "vets/index";
    }
}
