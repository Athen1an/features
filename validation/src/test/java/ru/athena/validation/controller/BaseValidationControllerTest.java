package ru.athena.validation.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import ru.athena.test.util.TestMappingUtil;
import ru.athena.test.util.TestRandomUtil;
import ru.athena.utility.util.StringUtil;
import ru.athena.validation.AbstractIntegrationTest;
import ru.athena.validation.model.Address;
import ru.athena.validation.model.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BaseValidationControllerTest extends AbstractIntegrationTest {

    @Test
    void validUserTest() throws Exception {
        User user = new User()
                .setFirstName(TestRandomUtil.randomString())
                .setLastName(TestRandomUtil.randomString());

        mockMvc.perform(put("/feature/validation/base/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestMappingUtil.convertObjectToJsonString(user)))
                .andExpect(status().isCreated());
    }

    @Test
    void invalidUserTest() throws Exception {
        User user = new User()
                .setFirstName(TestRandomUtil.randomString())
                .setLastName(StringUtil.BLANK_STRING);

        mockMvc.perform(put("/feature/validation/base/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestMappingUtil.convertObjectToJsonString(user)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void notValidateInvalidUserAddressWithoutGroupTest() throws Exception {
        User user = new User()
                .setFirstName(TestRandomUtil.randomString())
                .setLastName(TestRandomUtil.randomString())
                .setAddress(new Address()
                        .setPostCode(TestRandomUtil.randomString())
                        .setFullAddress(StringUtil.BLANK_STRING)
                );

        mockMvc.perform(put("/feature/validation/base/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestMappingUtil.convertObjectToJsonString(user)))
                .andExpect(status().isCreated());
    }
}