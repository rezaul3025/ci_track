package com.ci.track.web.rest;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ci.track.persistance.domain.Patient;
import com.ci.track.persistance.service.PatientService;
import com.ci.track.web.event.LabResult;
import com.ci.track.web.event.LabTest;
import com.ci.track.web.event.PatientInfo;
import com.ci.track.web.event.PrescriptionInfo;
import com.ci.track.web.event.Test;

@RestController
@RequestMapping(value="/rest/patient")
public class PatientRestController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PatientService patientServie;
	
	@RequestMapping("/info")
	public PatientInfo getPatientInfo(){
		return new PatientInfo("Tom","Mia",new Date(), "Tom put");
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public PatientInfo addInfo(@RequestBody PatientInfo patientInfo){
		
		LocalDate today = LocalDate.now();
		LocalDate birthday = patientInfo.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		 
		
		Patient patient = new Patient();
		BeanUtils.copyProperties(patientInfo, patient);
		
		Period p = Period.between(birthday, today);
		 
		//Now access the values as below
		/*System.out.println(p.getDays());
		System.out.println(p.getMonths());
		System.out.println(p.getYears());*/
		
		int d = p.getDays();
		int m = p.getMonths();
		int y = p.getYears();
		
		if(y != 0){
			patient.setAge(y+" Year(s)");
		}
		else if(y==0 && m != 0){
			patient.setAge(m+" Month(s)");
		}
		else
		{
			patient.setAge(d+" Day(s)");
		}
		
		patientServie.add(patient);
		
		/*String sql = "INSERT INTO patient(firstName, lastName, dob, address) " +
				" VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {
				patientInfo.getFirstName(),patientInfo.getLastName(), patientInfo.getDob(), patientInfo.getAddress()}, keyHolder);
		*/
		/*
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
		      @Override
		      public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
		        final PreparedStatement ps = connection.prepareStatement("INSERT INTO patient(firstName, lastName, dob, address) " +
						" VALUES (?,?,?,?)",
		            Statement.RETURN_GENERATED_KEYS);
		        ps.setString(1, patientInfo.getFirstName());
		        ps.setString(2, patientInfo.getLastName());
		        ps.setObject(3, patientInfo.getDob());
		        ps.setString(4, patientInfo.getAddress());
		        return ps;
		      }
		    };
		
		jdbcTemplate.update(psc, keyHolder);
		    
		System.out.println(patientInfo);*/
		
		return patientInfo;
	}
	
	@RequestMapping(value="/add-prescription", method=RequestMethod.POST)
	public PrescriptionInfo addPrescription(@RequestBody PrescriptionInfo prescriptionInfo){
		
		System.out.println(prescriptionInfo);
		
		return prescriptionInfo;
	}
	
	@RequestMapping(value="/add-labresult", method=RequestMethod.POST)
	public List<LabResult> addLabResult(@RequestBody List<LabResult> labResult){
		System.out.println(labResult);
		
		return labResult;
	}
	
	@RequestMapping(value="/add-labtest", method=RequestMethod.POST)
	public Test<LabTest> addLabTest(@RequestBody Test<LabTest> labTest){
		
		System.out.println(labTest);
		
		return labTest;
	}
	
	@RequestMapping(value="/get-all", method=RequestMethod.GET)
	public List<Patient> getAll(){
		return patientServie.getAll();
	}
	
	@RequestMapping(value="/findbyid/{id}", method=RequestMethod.GET)
	public Patient findByID(@PathVariable("id") Integer id){
		return patientServie.findById(id);
	}
}
