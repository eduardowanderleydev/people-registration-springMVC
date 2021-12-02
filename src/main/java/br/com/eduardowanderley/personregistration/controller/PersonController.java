package br.com.eduardowanderley.personregistration.controller;

import br.com.eduardowanderley.personregistration.model.Person;
import br.com.eduardowanderley.personregistration.service.OccupationService;
import br.com.eduardowanderley.personregistration.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    OccupationService occupationService;

    @GetMapping("/register")
    public String loadRegisterPage(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("peoplelist", personService.findAll());
        model.addAttribute("occupations", occupationService.findAll());
        return "register/personregistration";
    }

    @PostMapping("/save")
    public String save(Person person) {

        personService.save(person);
        return "redirect:/person/register";
    }

}
