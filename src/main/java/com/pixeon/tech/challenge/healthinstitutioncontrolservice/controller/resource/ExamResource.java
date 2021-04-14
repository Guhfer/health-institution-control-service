package com.pixeon.tech.challenge.healthinstitutioncontrolservice.controller.resource;

import com.pixeon.tech.challenge.healthinstitutioncontrolservice.enums.PatientGender;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ExamResource {

    @NotBlank(message = "Field patientName is mandatory")
    private String patientName;

    @NotNull(message = "Field patientAge is mandatory")
    private Integer patientAge;

    @NotNull(message = "Field patientAge is mandatory")
    private PatientGender patientGender;

    @NotBlank(message = "Field physicianName is mandatory")
    private String physicianName;

    @NotBlank(message = "Field physicianCrm is mandatory")
    private String physicianCrm;

    @NotBlank(message = "Field procedureName is mandatory")
    private String procedureName;

    public ExamResource(@NotBlank(message = "Field patientName is mandatory") String patientName,
                        @NotNull(message = "Field patientAge is mandatory") Integer patientAge,
                        @NotNull(message = "Field patientAge is mandatory") PatientGender patientGender,
                        @NotBlank(message = "Field physicianName is mandatory") String physicianName,
                        @NotBlank(message = "Field physicianCrm is mandatory") String physicianCrm,
                        @NotBlank(message = "Field procedureName is mandatory") String procedureName) {
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
