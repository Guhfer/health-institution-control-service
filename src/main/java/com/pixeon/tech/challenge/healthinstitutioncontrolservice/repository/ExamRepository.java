package com.pixeon.tech.challenge.healthinstitutioncontrolservice.repository;

import com.pixeon.tech.challenge.healthinstitutioncontrolservice.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
