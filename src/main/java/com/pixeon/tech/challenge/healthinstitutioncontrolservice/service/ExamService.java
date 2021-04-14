package com.pixeon.tech.challenge.healthinstitutioncontrolservice.service;

import com.pixeon.tech.challenge.healthinstitutioncontrolservice.controller.resource.ExamResource;
import com.pixeon.tech.challenge.healthinstitutioncontrolservice.controller.resource.ExamUpdateResource;
import com.pixeon.tech.challenge.healthinstitutioncontrolservice.entity.Exam;
import com.pixeon.tech.challenge.healthinstitutioncontrolservice.entity.HealthcareInstitution;
import com.pixeon.tech.challenge.healthinstitutioncontrolservice.repository.ExamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class ExamService {

     private final ExamRepository examRepository;

     private final HealthcareInstitutionService healthcareInstitutionService;

    public ExamService(ExamRepository examRepository, HealthcareInstitutionService healthcareInstitutionService) {
        this.examRepository = examRepository;
        this.healthcareInstitutionService = healthcareInstitutionService;
    }

    public Exam saveExam(ExamResource resource, String token) {
        HealthcareInstitution healthcareInstitution = healthcareInstitutionService.findByToken(token);
        healthcareInstitutionService.updatePixeonCoins(healthcareInstitution);
        return examRepository.save(new Exam(resource, healthcareInstitution));
    }

    public Exam getExam(Long id, String token) {
        HealthcareInstitution healthcareInstitution = healthcareInstitutionService.findByToken(token);
        Exam exam = findById(id);

        checkIfExamBelongToHealthInstitution(healthcareInstitution, exam);

        healthcareInstitutionService.updateIfNotConsumedResource(healthcareInstitution, id);

        return exam;
    }

    public Exam updateExam(ExamUpdateResource updateResource, Long id, String token) {
        HealthcareInstitution healthcareInstitution = healthcareInstitutionService.findByToken(token);
        Exam exam = findById(id);

        checkIfExamBelongToHealthInstitution(healthcareInstitution, exam);

        exam.setPatientName(updateResource.getPatientName() != null ? updateResource.getPatientName(): exam.getPatientName());
        exam.setPatientAge(updateResource.getPatientAge() != null ? updateResource.getPatientAge() : exam.getPatientAge());
        exam.setPatientGender(updateResource.getPatientGender() != null ? updateResource.getPatientGender() : exam.getPatientGender());
        exam.setPhysicianName(updateResource.getPhysicianName() != null ? updateResource.getPhysicianName() : exam.getPhysicianName());
        exam.setPhysicianCrm(updateResource.getPhysicianCrm() != null ? updateResource.getPhysicianCrm() : exam.getPhysicianCrm());
        exam.setProcedureName(updateResource.getProcedureName() != null ? updateResource.getProcedureName() : exam.getProcedureName());

        return examRepository.save(exam);
    }


    private void checkIfExamBelongToHealthInstitution(HealthcareInstitution healthcareInstitution, Exam exam) {
        if(!exam.getHealthcareInstitution().equals(healthcareInstitution)) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "You dont have access to this feature");
        }
    }

    public Exam findById(Long id) {
        return examRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Exam not found"));
    }

    public void deleteById(Long id) {
        findById(id);
        examRepository.deleteById(id);

    }
}
