package br.com.eduardowanderley.personregistration.controller;

import br.com.eduardowanderley.personregistration.controller.dto.person.PersonFormDTO;
import br.com.eduardowanderley.personregistration.service.OccupationService;
import br.com.eduardowanderley.personregistration.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public String save(@Valid PersonFormDTO personDTO, BindingResult br, Model model) {

        if (br.hasErrors()) {
            model.addAttribute("peoplelist", personService.findAll());
            model.addAttribute("person", personDTO); // keeps the object on the screen

            List<String> msg = new ArrayList<String>();
            for (ObjectError obj : br.getAllErrors()) {
                msg.add(obj.getDefaultMessage());
            }

            model.addAttribute("msg", msg);
            model.addAttribute("occupations", occupationService.findAll());
            return "register/personregistration";
        }

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
