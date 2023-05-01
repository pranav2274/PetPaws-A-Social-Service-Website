package com.Minorproject.NGOforPet.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.Minorproject.NGOforPet.dao.Memberdao;
import com.Minorproject.NGOforPet.dao.Paymentdao;
import com.Minorproject.NGOforPet.entities.payment_details;
import com.Minorproject.NGOforPet.entities.volunteers;

import com.Minorproject.NGOforPet.services.MailService;

@Service
public class NGOServiceImpl implements NGOService {

	List<volunteers> list;
	
	@Autowired
	private MailService notificationService;

	
	@Autowired
	private Memberdao memberDao;
	
	@Autowired
	private Paymentdao paymentdao;
	
	
	public NGOServiceImpl() {
		list=new ArrayList<>();
		//list.add(new registration_members(12,706023,21,"Pranav","Dehradun","pranav2002ddun","student"));
		//list.add(new registration_members(22,706011,21,"Gaurav","Lahore","pranav2002d","studnt"));
	}
	@Override
	public List<volunteers> getPets() {
		// TODO Auto-generated method stub
		
		return list;
	}
	
	@Override
	public volunteers getPetDetails(String city) {
		
		return null;
	}
	@Override
	public String addMembers(volunteers members) {
		
		try {
			 memberDao.saveAndFlush(members);
			// EntityTransaction.commit();
			 notificationService.sendEmail(members);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
		//return members;
	}
	
	@Override
	public String addPayment_Details(payment_details paymentdetails){
					
		          //  paymentdao.saveAndFlush(paymentdetails);
					
		            try {
		   			 paymentdao.saveAndFlush(paymentdetails);
		   			// EntityTransaction.commit();
		   			// notificationService.sendEmail(paymentdetails);
		   		} catch (Exception e) {
		   			System.out.println(e);
		   		}
//		            try {
//						notificationService.sendEmail(paymentdetails);					
//					} catch(MailException mailException) {
//						System.out.println(mailException);
//					}
		                return "Congratulations! Your mail has been send to the user.";
	  }
   }
