package ru.athena.validation.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RequestMapping("/feature/validation/parameters")
@RestController
public class ParametersValidationController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void validateParam(@NotBlank @RequestParam String param) {
        log.debug("Get request to validate param {}", param);
    }

    @GetMapping("/{path}")
    @ResponseStatus(HttpStatus.OK)
    public void validatePathVariable(@NotBlank @PathVariable String path) {
        log.debug("Get request to validate path variable {}", path);
    }

    /**
     * Added to handle {@link ConstraintViolationException} that will be thrown @Validated annotation.
     *
     * @param request request.
     * @param ex exception to handle.
     * @return response with bad request status.
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(HttpServletRequest request, Exception ex) {
        log.debug("Catch exception: {} with message: {}", ex.getClass().getSimpleName(), ex.getMessage());
        return ResponseEntity.badRequest().build();
    }
}
