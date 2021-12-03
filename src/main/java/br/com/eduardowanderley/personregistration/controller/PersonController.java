package br.com.eduardowanderley.personregistration.controller;

import br.com.eduardowanderley.personregistration.controller.dto.person.PersonFormDTO;
import br.com.eduardowanderley.personregistration.service.OccupationService;
import br.com.eduardowanderley.personregistration.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    OccupationService occupationService;

    @GetMapping("/register")
    public String loadRegisterPage(Model model) {
        model.addAttribute("person", new PersonFormDTO());
        model.addAttribute("peoplelist", personService.findAll());
        model.addAttribute("occupations", occupationService.findAll());
        return "register/personregistration";
    }

    @PostMapping("/save")
    public String save(PersonFormDTO personDTO) {

        personService.save(personDTO);
        return "redirect:/person/register";
    }

    @GetMapping("/edit/{personid}")
    public String edit(@PathVariable("personid") Long personId, Model model) {
        model.addAttribute("person", personService.findPersonToEditById(personId));
        model.addAttribute("peoplelist", personService.findAll());
        model.addAttribute("occupations", occupationService.findAll());
        return "register/personregistration";
    }

    @GetMapping("/delete/{personid}")
    public String delete(@PathVariable("personid") Long personId) {
        personService.deleteById(personId);
        return "redirect:/person/register";
    }

}
