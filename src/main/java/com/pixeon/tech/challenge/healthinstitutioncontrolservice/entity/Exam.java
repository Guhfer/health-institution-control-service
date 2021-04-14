package com.pixeon.tech.challenge.healthinstitutioncontrolservice.entity;

import com.pixeon.tech.challenge.healthinstitutioncontrolservice.controller.resource.ExamResource;
import com.pixeon.tech.challenge.healthinstitutioncontrolservice.enums.PatientGender;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "healthcare_institution_id", nullable = false)
    private HealthcareInstitution healthcareInstitution;

    @Column(nullable = false)
    private String patientName;

    @Column(nullable = false)
    private Integer patientAge;

    @Column(nullable = false)
    private PatientGender patientGender;

    @Column(nullable = false)
    private String physicianName;

    @Column(nullable = false)
    private String physicianCrm;

    @Column(nullable = false)
    private String procedureName;

    public Exam(ExamResource examResource, HealthcareInstitution healthcareInstitution) {
        this.patientName = examResource.getPatientName();
        this.patientAge = examResource.getPatientAge();
        this.patientGender = examResource.getPatientGender();
        this.physicianName = examResource.getPhysicianName();
        this.physicianCrm = examResource.getPhysicianCrm();
        this.procedureName = examResource.getProcedureName();
        this.healthcareInstitution = healthcareInstitution;
    }

    public Exam() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HealthcareInstitution getHealthcareInstitution() {
        return healthcareInstitution;
    }

    public void setHealthcareInstitution(HealthcareInstitution healthcareInstitution) {
        this.healthcareInstitution = healthcareInstitution;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public PatientGender getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(PatientGender patientGender) {
        this.patientGender = patientGender;
    }

    public String getPhysicianName() {
        return physicianName;
    }

    public void setPhysicianName(String physicianName) {
        this.physicianName = physicianName;
    }

    public String getPhysicianCrm() {
        return physicianCrm;
    }

    public void setPhysicianCrm(String physicianCrm) {
        this.physicianCrm = physicianCrm;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }
}
