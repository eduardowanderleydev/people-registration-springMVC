package br.com.eduardowanderley.personregistration.controller;

import br.com.eduardowanderley.personregistration.model.Person;
import br.com.eduardowanderley.personregistration.model.Phone;
import br.com.eduardowanderley.personregistration.service.PersonService;
import br.com.eduardowanderley.personregistration.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/phones")
public class PhoneController {

    @Autowired
    PhoneService phoneService;

    @Autowired
    PersonService personService;

    @GetMapping("/{personid}")
    public String loadPhonePage(@PathVariable("personid") Long personid, Model model) {
        model.addAttribute("phones", phoneService.findByPerson(personid));
        Person person = personService.findById(personid);
        model.addAttribute("person", person);
        return "register/phoneregistration";
    }

    @PostMapping("/save/{idperson}")
    public String addPhoneUser(Phone phone, @PathVariable("idperson") Long personid) {

        Person person = personService.findById(personid);
        phone.setPerson(person);
        phoneService.save(phone);

        return "redirect:/phones/" + person.getId();
    }

}
