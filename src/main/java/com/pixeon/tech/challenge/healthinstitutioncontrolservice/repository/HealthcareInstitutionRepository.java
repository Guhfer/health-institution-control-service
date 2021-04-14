package com.pixeon.tech.challenge.healthinstitutioncontrolservice.repository;

import com.pixeon.tech.challenge.healthinstitutioncontrolservice.entity.HealthcareInstitution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HealthcareInstitutionRepository extends JpaRepository<HealthcareInstitution, Long> {

    Optional<HealthcareInstitution> findByCnpj(final String cnpj);

    Optional<HealthcareInstitution> findByInstitutionToken(final String token);

    Boolean existsByCnpj(final String cnpj);

}
