package com.fpoly.controllers.admin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fpoly.beans.HistoryModel;
import com.fpoly.repositories.OrderDetailRepository;
import com.fpoly.services.PDFGenerator;
import com.lowagie.text.DocumentException;

@Controller
public class PdfController {

	@Autowired
	private OrderDetailRepository odetailRepo;
	
	@GetMapping("/admin/pdf/{id}")
	public void generatePdf(HttpServletResponse response, @PathVariable("id") Integer id) throws DocumentException, IOException {
		
		response.setContentType("application/pdf");
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerkey, headervalue);
		
		List<HistoryModel> bill = odetailRepo.getBill(id);
		
		PDFGenerator generator = new PDFGenerator();
		generator.setBill(bill);
		generator.generate(response);
}
}