package com.pixeon.tech.challenge.healthinstitutioncontrolservice.controller;

import com.pixeon.tech.challenge.healthinstitutioncontrolservice.controller.resource.ExamResource;
import com.pixeon.tech.challenge.healthinstitutioncontrolservice.controller.resource.ExamUpdateResource;
import com.pixeon.tech.challenge.healthinstitutioncontrolservice.service.ExamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;

@RestController
@RequestMapping("/exams")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ExamResource resource,
                                 @RequestHeader("health-institution-token") String token) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(examService.saveExam(resource, token));
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode())
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getTaskById(@PathVariable Long id,
                                      @RequestHeader("health-institution-token") String token) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(examService.getExam(id, token));
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode())
                    .body(e.getMessage());
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateById(@PathVariable Long id,
                                     @Valid @RequestBody ExamUpdateResource resource,
                                     @RequestHeader("health-institution-token") String token) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(examService.updateExam(resource, id, token));
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode())
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {

        try {
            examService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
    }

}
