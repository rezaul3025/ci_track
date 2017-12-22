package com.ci.track.web.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	@RequestMapping("/info")
	public PatientInfo getPatientInfo(){
		return new PatientInfo("Tom","Mia",new Date(), "Tom put");
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public PatientInfo addInfo(@RequestBody PatientInfo patientInfo){
		
		LocalDate today = LocalDate.now();
		LocalDate birthday = patientInfo.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		 
		Period p = Period.between(birthday, today);
		 
		//Now access the values as below
		System.out.println(p.getDays());
		System.out.println(p.getMonths());
		System.out.println(p.getYears());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		/*String sql = "INSERT INTO patient(firstName, lastName, dob, address) " +
				" VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {
				patientInfo.getFirstName(),patientInfo.getLastName(), patientInfo.getDob(), patientInfo.getAddress()}, keyHolder);
		*/
		
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
		    
		System.out.println(patientInfo);
		
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
}
