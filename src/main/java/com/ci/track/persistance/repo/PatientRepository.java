package com.ci.track.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ci.track.persistance.domain.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
