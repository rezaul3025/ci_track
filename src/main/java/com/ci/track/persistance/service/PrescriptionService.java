package com.ci.track.persistance.service;

import java.util.List;

import com.ci.track.persistance.domain.Prescription;
import com.ci.track.web.event.PrescriptionInfo;
import com.mongodb.gridfs.GridFSDBFile;

public interface PrescriptionService {
	
	Prescription addPrescription(PrescriptionInfo prescriptionInfo );
	
	List<Prescription> findByPatientId(String id);
	
	String generatePrescriptionPdf(Prescription prescription);
	
	GridFSDBFile getPrescriptionPdfById(String id);
}
