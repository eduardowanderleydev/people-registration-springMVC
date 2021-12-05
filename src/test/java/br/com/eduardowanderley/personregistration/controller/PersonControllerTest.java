package br.com.eduardowanderley.personregistration.controller;

import br.com.eduardowanderley.personregistration.builder.PersonBuilder;
import br.com.eduardowanderley.personregistration.controller.dto.person.PersonFormDTO;
import br.com.eduardowanderley.personregistration.model.Person;
import br.com.eduardowanderley.personregistration.service.OccupationService;
import br.com.eduardowanderley.personregistration.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.io.IOException;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    private static final String PERSON_REGISTRATION_PAGE = "register/personregistration";

    @Mock
    private PersonService personService;

    @Mock
    private OccupationService occupationService;

    @Mock
    private Model model;

    @Mock
    private BindingResult br;

    @InjectMocks
    @Autowired
    private PersonController controller;

    @Test
    public void save_whenPersonHasInvalidFields_shouldReturnToRegistrationPage() throws IOException {
        Person person = PersonBuilder.onePerson().build();
        Mockito.when(br.hasErrors()).thenReturn(true);

        String saveResponse = controller.save(new PersonFormDTO(person), br, model, null);

        Assert.assertEquals(PERSON_REGISTRATION_PAGE, saveResponse);
    }

    @Test
    public void search_whenOnlyNameIsSend_shouldFilterByName() {
        final PageRequest page = PageRequest.of(0, 5);
        final String NAME_SEARCH = "Eduardo";
        controller.search(NAME_SEARCH, "", page, model);

        Mockito.verify(personService).findPersonByNamePage(NAME_SEARCH, page);
    }

    @Test
    public void search_whenOnlyGenderIsSend_shouldFilterByGender() {
        final PageRequest page = PageRequest.of(0, 5);
        final String GENDER = "FEMALE";
        controller.search("", GENDER, page, model);

        Mockito.verify(personService).findPersonByGenderPage(GENDER, page);
    }

    @Test
    public void search_whenNameAndGenderAreSend_shouldFilterByNameAndGender() {
        final PageRequest page = PageRequest.of(0, 5);
        final String NAME_SEARCH = "Eduardo";
        final String GENDER = "FEMALE";
        controller.search(NAME_SEARCH, GENDER, page, model);

        Mockito.verify(personService).findPersonByNameAndGenderPage(GENDER, NAME_SEARCH, page);
    }
}
