package com.ci.track.persistance.service;

import java.util.List;

import com.ci.track.persistance.domain.Prescription;
import com.ci.track.web.event.PrescriptionInfo;

public interface PrescriptionService {
	Prescription addPrescription(PrescriptionInfo prescriptionInfo );
	List<Prescription> findByPatientId(String id);
}
