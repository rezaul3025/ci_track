package com.ci.track.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ci.track.persistance.service.PrescriptionService;
import com.mongodb.gridfs.GridFSDBFile;

@Controller
@RequestMapping("/prescription")
public class PrescriptionController {
	
	@Autowired
	private PrescriptionService prescriptionService;
	
    private static final String APPLICATION_PDF = "application/pdf";

	
	@GetMapping(value = "/view/{id}")
	public @ResponseBody void viewPrescription(@PathVariable("id") String id, HttpServletResponse response) throws IOException {
		GridFSDBFile prescriptionById = prescriptionService.getPrescriptionPdfById(id);
	   // return IOUtils.toByteArray(prescriptionById.getInputStream());
	    
	    response.setContentType(APPLICATION_PDF);
        response.setHeader("Content-Disposition", "inline; filename=" + prescriptionById.getFilename());
        response.setHeader("Content-Length", String.valueOf(prescriptionById.getLength()));
        FileCopyUtils.copy(prescriptionById.getInputStream(), response.getOutputStream());
	}
	
	@GetMapping(value = "/download/{id}")
	public @ResponseBody void downloadPrescription(@PathVariable("id") String id, HttpServletResponse response) throws IOException {
		GridFSDBFile prescriptionById = prescriptionService.getPrescriptionPdfById(id);
	   // return IOUtils.toByteArray(prescriptionById.getInputStream());
	    
	    response.setContentType(APPLICATION_PDF);
        response.setHeader("Content-Disposition", "attachment; filename=" + prescriptionById.getFilename());
        response.setHeader("Content-Length", String.valueOf(prescriptionById.getLength()));
        FileCopyUtils.copy(prescriptionById.getInputStream(), response.getOutputStream());
	}
}
