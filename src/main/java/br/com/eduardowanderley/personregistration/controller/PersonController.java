package br.com.eduardowanderley.personregistration.controller;

import br.com.eduardowanderley.personregistration.controller.dto.person.PersonDTO;
import br.com.eduardowanderley.personregistration.controller.dto.person.PersonFormDTO;
import br.com.eduardowanderley.personregistration.model.Person;
import br.com.eduardowanderley.personregistration.service.OccupationService;
import br.com.eduardowanderley.personregistration.service.PersonService;
import br.com.eduardowanderley.personregistration.util.ReportUtil;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private OccupationService occupationService;

    @Autowired
    private ReportUtil reportUtil;

    @GetMapping("/register")
    public String loadRegisterPage(Model model) {
        model.addAttribute("person", new PersonFormDTO());
        model.addAttribute("peoplelist", personService.findByPage(PageRequest.of(0, 5, Sort.by("name"))));
        model.addAttribute("occupations", occupationService.findAll());
        return "register/personregistration";
    }

    @GetMapping(value = {"/page"})
    public String listPerson(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("person", new PersonFormDTO());
        model.addAttribute("peoplelist", personService.findByPage(pageable));
        model.addAttribute("occupations", occupationService.findAll());
        return "register/personregistration";
    }

    @PostMapping("/search")
    public String search(@Param("research") String research, @Param("genderSearch") String genderSearch,
                         @PageableDefault(size = 5, sort = {"name"}) Pageable pageable, Model model) {

        Page<Person> list = null;

        if (genderSearch != null && !genderSearch.equals("") && research != null && !research.equals("")) {
            list = personService.findPersonByNameAndGenderPage(genderSearch, research, pageable);
        } else if (genderSearch == null || genderSearch.equals("") && research != null && !research.equals("")) {
            list = personService.findPersonByNamePage(research, pageable);
        } else if (genderSearch != null && !genderSearch.equals("") && research == null || research.equals("")) {
            list = personService.findPersonByGenderPage(genderSearch, pageable);
        } else {
            list = personService.findByPage(pageable);
        }

        model.addAttribute("peoplelist", list);
        model.addAttribute("person", new PersonFormDTO());
        model.addAttribute("research", research);
        model.addAttribute("genderSearch", genderSearch);
        model.addAttribute("occupations", occupationService.findAll());
        return "register/personregistration";
    }

    @PostMapping(value = "/save", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String save(@Valid PersonFormDTO personDTO, BindingResult br, Model model, final MultipartFile file) throws IOException {

        if (br.hasErrors()) {
            model.addAttribute("peoplelist", personService.findByPage(PageRequest.of(0, 5, Sort.by("name"))));
            model.addAttribute("person", personDTO); // keeps the object on the screen

            List<String> msg = new ArrayList<>();
            for (ObjectError obj : br.getAllErrors()) {
                msg.add(obj.getDefaultMessage());
            }

            model.addAttribute("msg", msg);
            model.addAttribute("occupations", occupationService.findAll());
            return "register/personregistration";
        }

        // if have some file information, set information
        if (file.getSize() > 0) {
            personDTO.setCurriculum(file.getBytes());
            personDTO.setFileCurriculumName(file.getOriginalFilename());
            personDTO.setFileCurriculumType(file.getContentType());
        } else { // if file dont have any content
            if (personDTO.getId() != null && personDTO.getId() > 0) { // and the person already exists, set information about already registered curriculum
                PersonDTO tempPerson = personService.findById(personDTO.getId());
                personDTO.setCurriculum(tempPerson.getCurriculum());
                personDTO.setFileCurriculumName(tempPerson.getFileCurriculumName());
                personDTO.setFileCurriculumType(tempPerson.getFileCurriculumType());
            }
        }

        personService.save(personDTO);
        return "redirect:/person/register";
    }

    @GetMapping("/edit/{personid}")
    public String edit(@PathVariable("personid") Long personId, Model model) {
        model.addAttribute("person", personService.findPersonToEditById(personId));
        model.addAttribute("peoplelist", personService.findByPage(PageRequest.of(0, 5, Sort.by("name"))));
        model.addAttribute("occupations", occupationService.findAll());
        return "register/personregistration";
    }

    @GetMapping("/delete/{personid}")
    public String delete(@PathVariable("personid") Long personId) {
        personService.deleteById(personId);
        return "redirect:/person/register";
    }

    @GetMapping("/search")
    public void downloadPdf(@RequestParam("research") String research,
                            @RequestParam("genderSearch") String genderSearch, HttpServletRequest request, HttpServletResponse response)
            throws IOException, JRException {

        List<PersonFormDTO> list = new ArrayList<>();

        if (genderSearch != null && !genderSearch.equals("") && research != null && !research.equals("")) {
            list = personService.findByNameAndGender(research, genderSearch);
        } else if (genderSearch == null || genderSearch.equals("") && research != null && !research.equals("")) {
            list = personService.findByName(research);
        } else if (genderSearch != null && !genderSearch.equals("") && research == null || research.equals("")) {
            list = personService.findByGender(genderSearch);
        } else {
            list.clear();
        }

        /* Pdf Generation */
        byte[] pdf = reportUtil.reportGenerator(list, "Person", request.getServletContext());

        /* Answer size */
        response.setContentLength(pdf.length);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=\"relatorio.pdf\" ");

        /* End answer */
        response.getOutputStream().write(pdf);
    }

    @GetMapping("/downloadcv/{idperson}")
    public void curriculumDownload(@PathVariable("idperson") Long idperson, HttpServletResponse response) throws IOException {

        PersonDTO person = personService.findById(idperson);

        if (person != null) {
            response.setContentLength(person.getCurriculum().length);
            response.setContentType(person.getFileCurriculumType());
            response.setHeader("Content-Disposition", "attachment; filename = \"" + person.getFileCurriculumName() + " \" ");

            response.getOutputStream().write(person.getCurriculum());
        }
    }

}
