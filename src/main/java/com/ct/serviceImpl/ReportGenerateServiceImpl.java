package com.ct.serviceImpl;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ct.model.CustomerPlanDetails;
import com.ct.model.SearchRequest;
import com.ct.repo.CustomerPlanDetailsRepo;

import com.ct.service.ReportGenerateService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class ReportGenerateServiceImpl implements ReportGenerateService {
	@Autowired
	private CustomerPlanDetailsRepo customRepo;

	@Override
	public List<String> getPlanNames() {
		// TODO Auto-generated method stub
		// return customRepo.getPlanNames();
		return customRepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		// TODO Auto-generated method stub
		// return customRepo.getPlanStatus();
		return customRepo.getPlanStatus();
	}

	@Override
	public List<CustomerPlanDetails> getCustomerPlan(SearchRequest request) {
		String name = request.getPlanName();
		String status = request.getPlanStatus();
		System.out.println(status);
		// List<CustomerPlanDetails> byStatusAndName =
		// customRepo.getByStatusAndName(status, name);
		// System.out.println(statusAndNameList.get(0).getPlanName());
		// return byStatusAndName;
		CustomerPlanDetails custom = new CustomerPlanDetails();

		if ((request.getPlanName() != null) && (!(request.getPlanName().equals("")))) {
			custom.setPlanName(request.getPlanName());
		}

		if ((request.getPlanStatus() != null) && (!(request.getPlanStatus().equals("")))) {
			custom.setPStatus(request.getPlanStatus());
		}
		Example<CustomerPlanDetails> palnExample = Example.of(custom);
		List<CustomerPlanDetails> customList = customRepo.findAll(palnExample);

		return customList;

	}

	@Override
	public void exportExcel(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
List<CustomerPlanDetails> customerList = customRepo.findAll();
		HSSFWorkbook workBook=new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet("customerPlan_details");
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("cid");
		row.createCell(1).setCellValue("planName");
		row.createCell(2).setCellValue("pStatus");
		row.createCell(3).setCellValue("cemail");
		row.createCell(4).setCellValue("cName");
		row.createCell(5).setCellValue("phNo");
		row.createCell(6).setCellValue("gender");
		row.createCell(7).setCellValue("ssn");
		int dataRowIndex=1;
		for(CustomerPlanDetails list:customerList) {
			HSSFRow row1 = sheet.createRow(dataRowIndex);
			row1.createCell(0).setCellValue(list.getCid());
			row1.createCell(1).setCellValue(list.getPlanName());
			row1.createCell(2).setCellValue(list.getPStatus());
			row1.createCell(3).setCellValue(list.getCemail());
			row1.createCell(4).setCellValue(list.getPlanName());
			row1.createCell(5).setCellValue(list.getPhNo());
			row1.createCell(6).setCellValue(list.getGender());
			row1.createCell(7).setCellValue(list.getSsn());
			dataRowIndex++;
			
		}
		ServletOutputStream outputStream = response.getOutputStream();
		workBook.write(outputStream);
		workBook.close();
		outputStream.close();
	}
	

	@Override
	public void exportPdf(HttpServletResponse response) throws DocumentException, IOException {
		// TODO Auto-generated method stub
		List<CustomerPlanDetails> customerList = customRepo.findAll();
Document document=new Document(PageSize.A4);
PdfWriter.getInstance(document,response.getOutputStream() );
document.open();

Font font = FontFactory.getFont(FontFactory.COURIER_BOLDOBLIQUE);
font.setSize(19);
font.setColor(Color.DARK_GRAY);
Paragraph p=new Paragraph("List Of Customer Plans",font);
p.setAlignment(Paragraph.ALIGN_CENTER);
document.add(p);
PdfPTable pdfTable=new PdfPTable(8);
pdfTable.setWidthPercentage(100);
pdfTable.setWidths(new int[] {2, 2, 2, 2, 2,2,2,2});
pdfTable.setSpacingBefore(10);
PdfPCell cell=new PdfPCell();
cell.setBackgroundColor(Color.CYAN);
cell.setPaddingTop(5);

Font font2 = FontFactory.getFont(FontFactory.HELVETICA);
font2.setColor(Color.WHITE);

cell.setPhrase(new Phrase("cid",font));
pdfTable.addCell(cell);
 
cell.setPhrase(new Phrase("planName",font));
pdfTable.addCell(cell);

cell.setPhrase(new Phrase("pStatus",font));
pdfTable.addCell(cell);

cell.setPhrase(new Phrase("cemail",font));
pdfTable.addCell(cell);
 
cell.setPhrase(new Phrase("cName",font));
pdfTable.addCell(cell);

cell.setPhrase(new Phrase("phNo",font));
pdfTable.addCell(cell);

cell.setPhrase(new Phrase("gender",font));
pdfTable.addCell(cell);
 
cell.setPhrase(new Phrase("ssn",font));
pdfTable.addCell(cell);

for(CustomerPlanDetails list:customerList) {
	pdfTable.addCell(String.valueOf(list.getCid()));
	pdfTable.addCell(list.getCName());
	pdfTable.addCell(list.getGender());
	pdfTable.addCell(list.getPlanName());
	pdfTable.addCell(list.getPStatus());
	pdfTable.addCell(list.getCemail());
	pdfTable.addCell(String.valueOf(list.getPhNo()));
	pdfTable.addCell(String.valueOf(list.getSsn()));
	
	
}

document.add(pdfTable);
document.close();
	}

}
