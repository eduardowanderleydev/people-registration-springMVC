package br.com.eduardowanderley.personregistration.service;

import br.com.eduardowanderley.personregistration.builder.OccupationBuilder;
import br.com.eduardowanderley.personregistration.controller.dto.occupation.OccupationDTO;
import br.com.eduardowanderley.personregistration.model.Occupation;
import br.com.eduardowanderley.personregistration.repository.OccupationRepository;
import br.com.eduardowanderley.personregistration.service.exceptions.OccupationNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OccupationServiceTest {

    @Autowired
    private OccupationService service;

    @Autowired
    private OccupationRepository repository;

    @Before
    public void insertOccupationsInDb() {
        repository.deleteAll();
        Occupation oc1 = OccupationBuilder.OneOccupation().withId(1l).build();
        Occupation oc2 = OccupationBuilder.OneOccupation().withId(2l).build();
        repository.saveAll(Arrays.asList(oc1, oc2));
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
    public void findAll_whenOccupationTableIsNotEmpty_shouldGetAllOccupationsFromDatabase() {
        List<OccupationDTO> list = service.findAll();

        Assert.assertEquals(2, list.size());
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
    public void findById_whenIdDoesNotExists_shouldThrowOccupationNotFoundException() {
        Assert.assertThrows(OccupationNotFoundException.class, () -> service.findById(999999999l));
    }

}
