package com.Minorproject.NGOforPet.services;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Service;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import com.Minorproject.NGOforPet.entities.payment_details;

@Service
public class PDFGeneration {

	public Document receipt_generation(payment_details payment) throws Exception {
	    Document document = new Document();

	    PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\KIIT\\Desktop\\Projects\\receipt.doc"));
	    document.open();
	    
//	    Image img = Image.getInstance(ClassLoader.getSystemResource("attention-icon.jpg"));
//	    img.scaleAbsolute(10, 10);
//
//	    Phrase phrase = new Phrase();
//	    phrase.add(new Chunk(img, 0,0));
//
//	    document.add(new Paragraph(phrase));
	    
	    document.add(new Paragraph("Receipt for the payment:\n\n\nThanks "+payment.getName()+" for your contribution towards the betterment of the stray dogs. We will be in constant touch with you in future."));
	    document.add(new Paragraph(new Date().toString()));
	    PdfPTable table=new PdfPTable(2);

	    PdfPCell cell = new PdfPCell (new Paragraph ("Payment details"));

	    cell.setColspan (2);
	    cell.setHorizontalAlignment (Element.ALIGN_CENTER);
	    cell.setPadding (10.0f);
	    cell.setBackgroundColor (new Color (140, 221, 8));                                  

	    table.addCell(cell);                                    
	    ArrayList<String[]> row=new ArrayList<String[]>();
	    String[] data=new String[20];
	    data[0]="Amount made";
	    data[1]=""+payment.getAmount();
	    String[] data1=new String[20];
	    data1[0]="Payment mode";
	    data1[1]="Online Transaction";
	    row.add(data);
	    row.add(data1);

	    for(int i=0;i<row.size();i++) {
	      String[] cols=row.get(i);
	      for(int j=0;j<cols.length;j++){
	        table.addCell(cols[j]);
	      }
	    }

	    document.add(table);
	    document.close();

	    return document;   
	}
}
