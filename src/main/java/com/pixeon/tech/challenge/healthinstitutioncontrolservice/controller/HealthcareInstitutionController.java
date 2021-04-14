package com.pixeon.tech.challenge.healthinstitutioncontrolservice.controller;

import com.pixeon.tech.challenge.healthinstitutioncontrolservice.controller.resource.HealthcareInstitutionResource;
import com.pixeon.tech.challenge.healthinstitutioncontrolservice.service.HealthcareInstitutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;

@RestController
@RequestMapping("/healthcare-institutions")
public class HealthcareInstitutionController {

    private final HealthcareInstitutionService healthcareInstitutionService;

    public HealthcareInstitutionController(HealthcareInstitutionService healthcareInstitutionService) {
        this.healthcareInstitutionService = healthcareInstitutionService;
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody HealthcareInstitutionResource resource) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body((healthcareInstitutionService.saveHealthcareInstitution(resource)));
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode())
                    .body(e.getMessage());
        }
    }

}
