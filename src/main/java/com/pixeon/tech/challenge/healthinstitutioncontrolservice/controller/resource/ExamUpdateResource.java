package com.pixeon.tech.challenge.healthinstitutioncontrolservice.controller.resource;

import com.pixeon.tech.challenge.healthinstitutioncontrolservice.enums.PatientGender;


public class ExamUpdateResource {

    private String patientName;

    private Integer patientAge;

    private PatientGender patientGender;

    private String physicianName;

    private String physicianCrm;

    private String procedureName;

    public ExamUpdateResource(String patientName, Integer patientAge, PatientGender patientGender,
                              String physicianName, String physicianCrm, String procedureName) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.physicianName = physicianName;
        this.physicianCrm = physicianCrm;
        this.procedureName = procedureName;
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
