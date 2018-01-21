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
		
		/*List<Patient> patients = patientRepo.findAll().stream().filter(p->p.getDob().equals(patient.getDob())
				&& p.getFirstName().equals(patient.getFirstName()) 
						&& p.getLastName().equals(patient.getLastName())).collect(Collectors.toList());*/
		boolean validPatient = patient.getFirstName() != null && !patient.getFirstName().isEmpty()
							&& patient.getLastName() !=null && !patient.getLastName().isEmpty()
							&& patient.getAge() != null 
							&& patient.getAddress() != null && !patient.getAddress().isEmpty();
		if(validPatient){
			patientRepo.save(patient);
		}
		
		return patient;
	}

	@Override
	public List<Patient> getAll() {
		return patientRepo.findAll();
	}

	@Override
	public Patient findById(String id) {
		return patientRepo.findOne(id);
	}

}
