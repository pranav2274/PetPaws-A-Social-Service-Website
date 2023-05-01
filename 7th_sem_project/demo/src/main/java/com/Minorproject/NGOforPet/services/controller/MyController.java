package com.Minorproject.NGOforPet.services.controller;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Minorproject.NGOforPet.services.NGOService;
import com.Minorproject.NGOforPet.services.PDFGeneration;
import com.lowagie.text.Document;
import com.Minorproject.NGOforPet.entities.*;

@RestController
@CrossOrigin(origins = "*")
public class MyController {
   
	@Autowired
	private NGOService service;
	
	@Autowired
	private PDFGeneration pdf_obj;
	
	@GetMapping("/home")
	public String home() {
	   return "THis is homepage";
   }
	
   @GetMapping("/getPets")
    public List<volunteers> getPets(){
    	return this.service.getPets();
    }
    @GetMapping("/getPetDetails/{city}")
    public volunteers getPet(@PathVariable String city) {
    	return this.service.getPetDetails(city);
    }
    @PostMapping(path="/addmember",consumes="application/json")
    public ResponseEntity addMembers(@RequestBody volunteers member) {
    	 try {
    		 this.service.addMembers(member);
    		 return new ResponseEntity<>(HttpStatus.OK);
    	 } catch(Exception e) {
    		 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	 }
    }
    @PostMapping(path="/payments")
    public ResponseEntity<byte[]> addPayments(@RequestBody payment_details payment) {
    	 try {
    		 this.service.addPayment_Details(payment);
    		  pdf_obj.receipt_generation(payment);
    		    // retrieve contents of "C:/tmp/report.pdf" that were written in showHelp
    		    byte[] contents = Files.readAllBytes(Paths.get("C:\\Users\\KIIT\\Desktop\\Projects\\receipt.doc"));;

    		    HttpHeaders headers = new HttpHeaders();
    		    headers.setContentType(MediaType.APPLICATION_PDF);
    		    // Here you have to set the actual filename of your pdf
    		    String filename = "output.pdf";
    		    headers.setContentDispositionFormData(filename, filename);
    		    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
    		    ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
    		    return response;
    		 //return new ResponseEntity<>(HttpStatus.OK);
    	 } catch(Exception e) {
    		 System.out.print("Exception has occured:"+e);
    		 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	 }
    }
}
