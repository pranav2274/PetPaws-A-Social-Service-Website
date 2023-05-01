package com.Minorproject.NGOforPet.services;

import java.util.ArrayList;
import java.util.List;

import com.Minorproject.NGOforPet.entities.payment_details;
import com.Minorproject.NGOforPet.entities.volunteers;

public interface NGOService {
   public List<volunteers> getPets();
   public volunteers getPetDetails(String city);
  // public registration_members addMembers(registration_members members);
   public String addMembers(volunteers members);
   public String addPayment_Details(payment_details paymentdetails);
  // public ArrayList<petsavailable> getAvailablePets();
} 
