package com.Minorproject.NGOforPet.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class volunteers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long contact_no;
	private int age;
	private String first_name;
	private String last_name;
	private String city;
	private String email;
	private String gender;
	private String address;
	//private String occupation;
	public volunteers(int id, long phno, int age, String first_name,String second_name,String city, String address, String emailid,
			String gender) {
		super();
		this.id = id;
		this.contact_no = phno;
		this.age = age;
		this.first_name = first_name;
		this.last_name=second_name;
		this.city = city;
		this.address=address;
		this.email = emailid;
		this.gender=gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "registration_members [id=" + id + ", contact_no=" + contact_no + ", age=" + age + ", first_name="
				+ first_name + ", last_name=" + last_name + ", city=" + city + ", emailid=" + email + ", address="
				+ address + ", getId()=" + getId() + ", getContact_no()=" + getContact_no() + ", getAge()=" + getAge()
				+ ", getFirst_name()=" + getFirst_name() + ", getLast_name()=" + getLast_name() + ", getCity()="
				+ getCity() + ", getEmailid()=" + getEmail() + ", getAddress()=" + getAddress() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
   
	
	
}
