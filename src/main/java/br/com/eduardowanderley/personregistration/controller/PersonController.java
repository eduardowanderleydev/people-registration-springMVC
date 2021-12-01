package br.com.eduardowanderley.personregistration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/register")
    public String loadRegisterPage(){
        return "register/personregistration";
    }

}
