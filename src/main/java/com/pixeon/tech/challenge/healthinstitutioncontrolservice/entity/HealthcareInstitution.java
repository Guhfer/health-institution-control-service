package com.pixeon.tech.challenge.healthinstitutioncontrolservice.entity;

import com.pixeon.tech.challenge.healthinstitutioncontrolservice.controller.resource.HealthcareInstitutionResource;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity(name = "healthcare_institution")
public class HealthcareInstitution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(columnDefinition = "integer default 20")
    private Integer pixeonCoins;

    @ElementCollection
    private List<Long> usedResources;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column(nullable = false)
    private String institutionToken;

    public HealthcareInstitution(HealthcareInstitutionResource resource) {
        this.name = resource.getName();
        this.cnpj = resource.getCnpj();
        this.institutionToken = UUID.randomUUID().toString();
        this.usedResources = new ArrayList<>();
        this.creationDate = LocalDate.now();
        this.pixeonCoins = 20;

    }

    public HealthcareInstitution() {
    }

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
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

    public Integer getPixeonCoins() {
        return pixeonCoins;
    }

    public void setPixeonCoins(Integer pixeonCoins) {
        this.pixeonCoins = pixeonCoins;
    }

    public List<Long> getUsedResources() {
        return usedResources;
    }

    public void setUsedResources(List<Long> usedResources) {
        this.usedResources = usedResources;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate createDate) {
        this.creationDate = createDate;
    }

    public String getInstitutionToken() {
        return institutionToken;
    }
}
