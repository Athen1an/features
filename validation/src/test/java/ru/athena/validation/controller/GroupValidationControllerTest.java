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

class GroupValidationControllerTest extends AbstractIntegrationTest {

    @Test
    void invalidUserAddressWithGroupTest() throws Exception {
        User user = new User()
                .setFirstName(TestRandomUtil.randomString())
                .setLastName(TestRandomUtil.randomString())
                .setAddress(new Address()
                        .setPostCode(TestRandomUtil.randomString())
                        .setFullAddress(StringUtil.BLANK_STRING)
                );

        mockMvc.perform(put("/feature/validation/group/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestMappingUtil.convertObjectToJsonString(user)))
                .andExpect(status().isBadRequest());
    }
}