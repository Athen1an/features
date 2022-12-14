package ru.athena.validation.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.athena.validation.model.User;

@Slf4j
@RequestMapping("/feature/validation/base")
@RestController
public class BaseValidationController {

    @PutMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void validate(@Valid @RequestBody User user) {
        log.debug("Get request to base validate user {}", user);
    }
}
