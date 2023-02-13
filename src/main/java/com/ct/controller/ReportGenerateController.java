package com.ct.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ct.model.CustomerPlanDetails;
import com.ct.model.SearchRequest;
import com.ct.serviceImpl.ReportGenerateServiceImpl;
import com.lowagie.text.DocumentException;

@RestController
public class ReportGenerateController {
	@Autowired
private ReportGenerateServiceImpl customService;
	@GetMapping("/plannames")
	public List<String> getPlanNames(){
		return customService.getPlanNames();
	}
	@GetMapping("/planstatus")
	public List<String> getPlanStatus(){
		return customService.getPlanStatus();
	}
	@PostMapping("/planandstatus")
	public List<CustomerPlanDetails> getCustomerPlan(@RequestBody SearchRequest request){
		return customService.getCustomerPlan(request);
	}
	@GetMapping("/excel")
	public void exportExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey="Content-disposition";
		String headerValue="attachment;filename=customerPlan_details.xls";
		response.setHeader(headerKey, headerValue);
		customService.exportExcel(response);
	}
	@GetMapping("/pdf")
	public void exportPdf(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pd");
		 DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=customers_plan_" + currentDateTime + ".pdf";
	response.setHeader(headerKey, headerValue);
	customService.exportPdf(response);
	}
	@GetMapping("/user")
	public String message() {
		return "wellcome user access portal";
	}
	@GetMapping("/admin")
	public String adminPortal() {
		return "wellcome admin access portal";
	}
	@GetMapping("/")
	public String accessAll() {
		return "access all";
	}
	
}
