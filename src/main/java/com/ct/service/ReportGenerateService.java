package com.ct.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.ct.model.CustomerPlanDetails;
import com.ct.model.SearchRequest;
import com.lowagie.text.DocumentException;


public interface ReportGenerateService {
public List<String> getPlanNames();
public List<String> getPlanStatus();
public List<CustomerPlanDetails> getCustomerPlan(SearchRequest request);
public void exportExcel(HttpServletResponse response) throws IOException;
public void exportPdf(HttpServletResponse response) throws DocumentException, IOException;
}
