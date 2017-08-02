package com.goldfarm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "user_Details")
@Component
public class UserDetails {
private String name;
private String Emailid;
private String phonenumber;
private String twitterusername;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmailid() {
	return Emailid;
}
public void setEmailid(String emailid) {
	Emailid = emailid;
}
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
@Id
public String getTwitterusername() {
	return twitterusername;
}
public void setTwitterusername(String twitterusername) {
	this.twitterusername = twitterusername;
}
 
}
