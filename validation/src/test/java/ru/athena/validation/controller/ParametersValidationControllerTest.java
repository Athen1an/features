package ru.athena.validation.controller;

import org.junit.jupiter.api.Test;
import ru.athena.test.util.TestRandomUtil;
import ru.athena.utility.util.StringUtil;
import ru.athena.validation.AbstractIntegrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ParametersValidationControllerTest extends AbstractIntegrationTest {

    @Test
    void validParameterTest() throws Exception {
        mockMvc.perform(get("/feature/validation/parameters")
                        .param("param", TestRandomUtil.randomString()))
                .andExpect(status().isOk());
    }

    @Test
    void invalidParameterTest() throws Exception {
        mockMvc.perform(get("/feature/validation/parameters")
                        .param("param", StringUtil.BLANK_STRING))
                .andExpect(status().isBadRequest());
    }

    @Test
    void validPathVariableTest() throws Exception {
        mockMvc.perform(get("/feature/validation/parameters/{path}", TestRandomUtil.randomString()))
                .andExpect(status().isOk());
    }

    @Test
    void invalidPathVariableTest() throws Exception {
        mockMvc.perform(get("/feature/validation/parameters/{path}", StringUtil.BLANK_STRING))
                .andExpect(status().isBadRequest());
    }

}