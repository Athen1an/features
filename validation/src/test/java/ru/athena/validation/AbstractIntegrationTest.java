package ru.athena.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import ru.athena.utility.constant.SpringProfileConstant;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(SpringProfileConstant.TEST)
public abstract class AbstractIntegrationTest {

    @Autowired
    protected ApplicationContext applicationContext;

    @Autowired
    protected MockMvc mockMvc;
}