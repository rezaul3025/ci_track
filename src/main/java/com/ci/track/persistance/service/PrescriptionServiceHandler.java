package com.ci.track.persistance.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.ci.track.persistance.domain.Patient;
import com.ci.track.persistance.domain.Prescription;
import com.ci.track.persistance.domain.PrescriptionItem;
import com.ci.track.persistance.domain.User;
import com.ci.track.persistance.repo.PrescriptionRepository;
import com.ci.track.web.event.PrescriptionInfo;
import com.ci.track.web.event.PrescriptionItemInfo;
import com.lowagie.text.DocumentException;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

@Service
public class PrescriptionServiceHandler implements PrescriptionService {
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Autowired
	private SpringTemplateEngine templateEngine;
	
	@Autowired
	private GridFsTemplate gridFsTemplate;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PatientService patientService;
	
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

		String prescriptionPdfId = generatePrescriptionPdf(prescription);
		
		prescription.setPrescriptionPdfId(prescriptionPdfId);
		
		prescriptionRepository.save(prescription);
		
		return prescription;
	}
	
	@Override
	public List<Prescription> findByPatientId(String id){
		return prescriptionRepository.findByPatientId(id);
	}

	@Override
	public String generatePrescriptionPdf(Prescription prescription) {
		Context ctx = new Context();
	    ctx.setLocale(Locale.US);
	    
	 // Report date
	    LocalDateTime now = LocalDateTime.now();
        System.out.println("Before : " + now);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formatDateTime = now.format(formatter);
	   // sdf.setTimeZone(TimeZone.getTimeZone("GMT+6"));
       
	    ctx.setVariable("issuingTimestamp", formatDateTime);
	    ctx.setVariable("prescription", prescription);
	    User user = userService.findById(prescription.getDoctorId());
	    ctx.setVariable("user", user);
	    Patient patient = patientService.findById(prescription.getPatientId());
	    ctx.setVariable("patient", patient);
	    LocalDate dobLocalDate= patient.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	    ctx.setVariable("dob", dobLocalDate.toString());
	    String htmlContent = templateEngine.process("report_template/pres_template", ctx);

	    // Data Report End
	    ITextRenderer renderer = new ITextRenderer();
	    //String documentRootUrl = generateDocumentRootUrl(event);
	   // LOG.debug("Document root URL for HTML->PDF converter is:" + documentRootUrl);
	    renderer.setDocumentFromString(htmlContent);
	    renderer.layout();
	    ByteArrayOutputStream os = new ByteArrayOutputStream(); 
	    try {
			renderer.createPDF(os, true);
			os.close();
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    InputStream inputStream = new ByteArrayInputStream(os.toByteArray());
	    DBObject metaData = new BasicDBObject();
	    String id = 
	      gridFsTemplate.store(inputStream, prescription.getId()+".pdf", "application/pdf", metaData).getId().toString();

		
		return id;
	}
	
	public GridFSDBFile getPrescriptionPdfById(String id) {
		  return this.gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
	}

}
