package ru.athena.validation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.athena.validation.group.WithAddressValidationGroup;
import ru.athena.validation.model.User;

@Slf4j
@RequestMapping("/feature/validation/group")
@RestController
public class GroupValidationController {

    @PutMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void validate(@Validated(WithAddressValidationGroup.class) @RequestBody User user) {
        log.debug("Get request to group validate user {}", user);
    }
}
