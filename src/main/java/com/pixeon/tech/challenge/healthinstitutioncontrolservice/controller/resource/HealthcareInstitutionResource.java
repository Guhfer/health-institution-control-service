package com.pixeon.tech.challenge.healthinstitutioncontrolservice.controller.resource;

import org.hibernate.validator.constraints.br.CNPJ;
import javax.validation.constraints.NotBlank;

public class HealthcareInstitutionResource {

    @NotBlank(message = "Field name is mandatory")
    private String name;

    @CNPJ(message = "Field CNPJ is invalid")
    @NotBlank(message = "Field name is mandatory")
    private String cnpj;

    public HealthcareInstitutionResource(@NotBlank(message = "Field name is mandatory") String name,
                                         @CNPJ(message = "Field CNPJ is invalid") @NotBlank(message = "Field name is mandatory") String cnpj) {
        this.name = name;
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
