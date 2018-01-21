package com.ci.track.persistance.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ci.track.persistance.domain.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String>{

}
