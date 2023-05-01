package com.Minorproject.NGOforPet.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class payment_details {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String name;
 private String email;
 private double amount;
 private long contact_no;
 
 
public payment_details() {
	super();
	
}
public payment_details(int id, String name, int contact_no, String email, double amount) {
	super();
	this.id = id;
	this.name = name;
	this.contact_no = contact_no;
	this.email = email;
	this.amount = amount;
}
@Override
public String toString() {
	return "payment_details [id=" + id + ", name=" + name + ", contact_no=" + contact_no + ", email=" + email + ", amount=" + amount
			+ "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public long getContact_no() {
	return contact_no;
}
public void setContact_no(long contact_no) {
	this.contact_no = contact_no;
}
 
}
