package com.ci.track.persistance.service;

import com.ci.track.persistance.domain.Prescription;
import com.ci.track.web.event.PrescriptionInfo;

public interface PrescriptionService {
	Prescription addPrescription(PrescriptionInfo prescriptionInfo );
}
