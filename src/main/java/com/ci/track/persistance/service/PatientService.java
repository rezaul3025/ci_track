package com.ci.track.persistance.service;

import java.util.List;

import com.ci.track.persistance.domain.Patient;

public interface PatientService {
	Patient add(Patient patient);
	
	List<Patient> getAll();
	
	Patient findById(String id);
}
