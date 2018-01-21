package com.ci.track.persistance.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ci.track.persistance.domain.Prescription;

@Repository
public interface PrescriptionRepository extends MongoRepository<Prescription, String>{
	List<Prescription> findByPatientId(String id);
}
