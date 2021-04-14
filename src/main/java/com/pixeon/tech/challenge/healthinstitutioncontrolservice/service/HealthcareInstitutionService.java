package com.pixeon.tech.challenge.healthinstitutioncontrolservice.service;

import com.pixeon.tech.challenge.healthinstitutioncontrolservice.controller.resource.HealthcareInstitutionResource;
import com.pixeon.tech.challenge.healthinstitutioncontrolservice.entity.HealthcareInstitution;
import com.pixeon.tech.challenge.healthinstitutioncontrolservice.repository.HealthcareInstitutionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class HealthcareInstitutionService {

    private final HealthcareInstitutionRepository healthcareInstitutionRepository;

    public HealthcareInstitutionService(HealthcareInstitutionRepository healthcareInstitutionRepository) {
        this.healthcareInstitutionRepository = healthcareInstitutionRepository;
    }

    public HealthcareInstitution saveHealthcareInstitution(HealthcareInstitutionResource resource) {
        if (healthcareInstitutionRepository.existsByCnpj(resource.getCnpj())) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Healthcare Institution already registered");
        }

        return healthcareInstitutionRepository.save(new HealthcareInstitution(resource));
    }

    public HealthcareInstitution findByToken(String token) {
        return healthcareInstitutionRepository.findByInstitutionToken(token)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "HealthcareInstitution not found for InstitutionToken: " + token));
    }


    private void verifyAmountCoins(Integer pixeonCoins) {
        if(pixeonCoins <= 0) {
            throw new HttpClientErrorException(HttpStatus.PRECONDITION_FAILED, "Insufficient amount of Pixeon Coins");
        }
    }

    protected void updatePixeonCoins(HealthcareInstitution healthcareInstitution) {
        verifyAmountCoins(healthcareInstitution.getPixeonCoins());
        healthcareInstitution.setPixeonCoins(healthcareInstitution.getPixeonCoins() - 1);
        healthcareInstitutionRepository.save(healthcareInstitution);
    }

    protected void updateIfNotConsumedResource(HealthcareInstitution healthcareInstitution, Long examId) {
        if(!healthcareInstitution.getUsedResources().contains(examId)) {
            healthcareInstitution.getUsedResources().add(examId);
            updatePixeonCoins(healthcareInstitution);
        }

    }

}
