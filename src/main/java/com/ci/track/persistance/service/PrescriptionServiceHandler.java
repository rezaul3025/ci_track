package com.ci.track.persistance.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.track.persistance.domain.Prescription;
import com.ci.track.persistance.repo.PrescriptionRepository;
import com.ci.track.web.event.PrescriptionInfo;

@Service
public class PrescriptionServiceHandler implements PrescriptionService {
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Override
	public Prescription addPrescription(PrescriptionInfo prescriptionInfo ){
		Prescription prescription = new Prescription();
		BeanUtils.copyProperties(prescriptionInfo, prescription);

		prescriptionRepository.saveAndFlush(prescription);
		
		return prescription;
	}

}
