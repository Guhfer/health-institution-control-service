package com.pixeon.tech.challenge.healthinstitutioncontrolservice.enums;

public enum PatientGender {
    MALE,
    FEMALE,
    OTHERS;

    public String getGender() {
        return this.name();
    }
}
