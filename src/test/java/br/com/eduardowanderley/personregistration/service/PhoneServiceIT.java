package br.com.eduardowanderley.personregistration.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneServiceIT {

    private static final String SHOULD_THROW_AN_EXCEPTION_MESSAGE = "Should throw an exception";

    @Autowired
    private PhoneService phoneService;

    @Test
    public void deleteById_whenIdDoesNotExists_shouldThrowPhoneNotFoundException() {
        final long ID = 999;

        try {
            phoneService.deleteById(ID);
            Assert.fail(SHOULD_THROW_AN_EXCEPTION_MESSAGE);
        } catch (Exception e) {
            Assert.assertEquals("Phone with id " + ID + "cannot be found", e.getMessage());
        }
    }

    @Test
    public void findPersonIdByPhone_whenPhoneDoesNotExists_shouldThrowPhoneNotFoundException() {
        final long ID = 222;

        try {
            phoneService.findPersonIdByPhone(ID);
            Assert.fail(SHOULD_THROW_AN_EXCEPTION_MESSAGE);
        } catch (Exception e) {
            Assert.assertEquals("Phone with id " + ID + "cannot be found", e.getMessage());
        }
    }

    @Test
    public void findById_whenPhoneDoesNotExists_shouldThrowPhoneNotFoundException() {
        final long ID = 555;

        try {
            phoneService.findById(ID);
            Assert.fail(SHOULD_THROW_AN_EXCEPTION_MESSAGE);
        } catch (Exception e) {
            Assert.assertEquals("Phone with id " + ID + "cannot be found", e.getMessage());
        }
    }
}
