package com.ci.track.persistance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.track.persistance.domain.Prescription;
import com.ci.track.persistance.domain.PrescriptionItem;
import com.ci.track.persistance.repo.PrescriptionRepository;
import com.ci.track.web.event.PrescriptionInfo;
import com.ci.track.web.event.PrescriptionItemInfo;

@Service
public class PrescriptionServiceHandler implements PrescriptionService {
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Override
	public Prescription addPrescription(PrescriptionInfo prescriptionInfo ){
		Prescription prescription = new Prescription();
		BeanUtils.copyProperties(prescriptionInfo, prescription);
		
		List<PrescriptionItem> prescriptionItemList = new ArrayList<>();
		for(PrescriptionItemInfo prescriptionItemInfo : prescriptionInfo.getPrescriptionItem()){
			PrescriptionItem pescriptionItem = new PrescriptionItem();
			BeanUtils.copyProperties(prescriptionItemInfo, pescriptionItem);
			prescriptionItemList.add(pescriptionItem);
		}
		
		prescription.setPrescriptionItem(prescriptionItemList);

		prescriptionRepository.save(prescription);
		
		return prescription;
	}
	
	@Override
	public List<Prescription> findByPatientId(String id){
		return prescriptionRepository.findByPatientId(id);
	}

}
