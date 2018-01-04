package com.ci.track.persistance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.track.persistance.domain.Patient;
import com.ci.track.persistance.repo.PatientRepository;

@Service
public class PatientServiceHandler implements PatientService {

	@Autowired
	private PatientRepository patientRepo;
	
	@Override
	public Patient add(Patient patient) {
		
		patientRepo.saveAndFlush(patient);
		
		return patient;
	}

	@Override
	public List<Patient> getAll() {
		return patientRepo.findAll();
	}

	@Override
	public Patient findById(Integer id) {
		return patientRepo.findOne(id);
	}

}
